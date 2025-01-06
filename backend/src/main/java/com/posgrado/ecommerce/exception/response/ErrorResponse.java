package com.posgrado.ecommerce.exception.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {

  private int code;
  private String error;
  private String message;

}
