package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.dto.UserDto;
import com.posgrado.ecommerce.entity.User;
import java.util.UUID;

public interface UserService {

  UserDto getById(UUID id);

  User create(User user);

  boolean existEmail(String email);

  User getByEmail(String email);

  void enableUser(User user);
}
