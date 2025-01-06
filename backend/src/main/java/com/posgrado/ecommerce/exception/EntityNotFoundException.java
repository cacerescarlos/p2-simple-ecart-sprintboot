package com.posgrado.ecommerce.exception;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException {

  public EntityNotFoundException(String message) {
    super(message);
  }

  public EntityNotFoundException(String entity, UUID id) {
    super(String.format("%s with id %s not found", entity, id.toString()));
  }
}
