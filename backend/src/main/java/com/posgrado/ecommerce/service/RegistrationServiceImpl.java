package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.dto.EmailNotification;
import com.posgrado.ecommerce.dto.RegistrationRequest;
import com.posgrado.ecommerce.entity.ConfirmationToken;
import com.posgrado.ecommerce.entity.User;
import com.posgrado.ecommerce.exception.EmailAlreadyTaken;
import com.posgrado.ecommerce.util.HtmlGenerator;
import com.posgrado.ecommerce.util.UriGenerator;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

  private UserService userService;
  private RoleService roleService;
  private ConfirmationTokenService confirmationTokenService;
  private PasswordEncoder passwordEncoder;
  private EmailService emailService;

  @Override
  public String register(RegistrationRequest dto) {
    boolean existEmail = userService.existEmail(dto.getEmail());
    if (existEmail) {
      throw new EmailAlreadyTaken(dto.getEmail());
    }
    User user = new User();
    user.setFirstName(dto.getFirstName());
    user.setLastName(dto.getLastName());
    user.setAddress(dto.getAddress());
    user.setEmail(dto.getEmail());
    String endedPassword = passwordEncoder.encode(dto.getPassword());
    user.setPassword(endedPassword);
    user.setRole(roleService.getByName("USER"));

    userService.create(user);

    String token = UUID.randomUUID().toString();
    ConfirmationToken confirmationToken = new ConfirmationToken(
        token,
        LocalDateTime.now(),
        LocalDateTime.now().plusMinutes(15),
        user
    );

    confirmationTokenService.create(confirmationToken);

    String confirmLink = UriGenerator.create("/auth/confirm", "token", token);
    String bodyHtml = HtmlGenerator.generateConfirmationTemplate(user.getFirstName(), confirmLink);

    EmailNotification emailNotification = EmailNotification.builder()
        .hasTemplate(true)
        .to(user.getEmail())
        .subject("Confirmation Account")
        .body(bodyHtml)
        .build();

    emailService.send(emailNotification);
    return token;
  }

  @Override
  public String confirm(String token) {
    ConfirmationToken confirmationToken = confirmationTokenService.getByToken(token);
    if (confirmationToken.getConfirmedAt() != null) {
      throw new RuntimeException("Token is already confirmed");
    }
    if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())) {
      throw new RuntimeException("Token expired");
    }
    userService.enableUser(confirmationToken.getUser());
    confirmationTokenService.setConfirmedAt(confirmationToken);
    return "User account has been enabled successfully";
  }
}
