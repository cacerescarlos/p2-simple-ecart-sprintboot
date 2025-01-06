package com.posgrado.ecommerce.dto;

import jakarta.validation.constraints.Email;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

  private UUID id;
  private String firstName;
  private String lastName;
  @Email
  private String email;
  private String address;
  private String roleName;

}
