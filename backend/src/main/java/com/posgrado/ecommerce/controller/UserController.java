package com.posgrado.ecommerce.controller;

import com.posgrado.ecommerce.dto.UserDto;
import com.posgrado.ecommerce.service.UserService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getById(@PathVariable UUID id) {
    ;
    return ResponseEntity.ok(userService.getById(id));
  }
}
