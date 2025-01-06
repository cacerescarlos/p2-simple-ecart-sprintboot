package com.posgrado.ecommerce.controller;

import com.posgrado.ecommerce.dto.AuthenticationRequest;
import com.posgrado.ecommerce.dto.AuthenticationResponse;
import com.posgrado.ecommerce.dto.RegistrationRequest;
import com.posgrado.ecommerce.service.AuthenticationService;
import com.posgrado.ecommerce.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

  private RegistrationService registrationService;
  private AuthenticationService authenticationService;

  @PostMapping
  public ResponseEntity<String> register(@Valid @RequestBody RegistrationRequest dto) {
    String message = registrationService.register(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(message);
  }

  @GetMapping("/confirm")
  public ResponseEntity<String> confirm(@RequestParam String token) {
    String message = registrationService.confirm(token);
    return ResponseEntity.ok(message);
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @Valid @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(authenticationService.authenticate(request));
  }

}
