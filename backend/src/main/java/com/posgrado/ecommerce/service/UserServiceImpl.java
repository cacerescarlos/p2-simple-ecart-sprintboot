package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.dto.UserDto;
import com.posgrado.ecommerce.entity.User;
import com.posgrado.ecommerce.exception.EntityNotFoundException;
import com.posgrado.ecommerce.repository.UserRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Override
  public UserDto getById(UUID id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User", id));

    UserDto dto = new UserDto();
    dto.setId(user.getId());
    dto.setFirstName(user.getFirstName());
    dto.setLastName(user.getLastName());
    dto.setEmail(user.getEmail());
    dto.setAddress(user.getAddress());
    dto.setRoleName(user.getRole().getName());

    return dto;
  }

  @Override
  public User create(User user) {
    return userRepository.save(user);
  }

  @Override
  public boolean existEmail(String email) {
    return userRepository.findByEmail(email).isPresent();
  }

  @Override
  public User getByEmail(String email) {
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new EntityNotFoundException(
            String.format("User with email %s not found", email)));
  }

  @Override
  public void enableUser(User user) {
    user.setEnable(true);
    userRepository.save(user);
  }


}
