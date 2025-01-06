package com.posgrado.ecommerce.exception.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FieldErrorModel {

  private String field;
  private String message;
  private String code;

}
