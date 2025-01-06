package com.posgrado.ecommerce.exception;

import com.posgrado.ecommerce.exception.response.ErrorResponse;
import com.posgrado.ecommerce.exception.response.FieldErrorModel;
import com.posgrado.ecommerce.exception.response.ValidationErrorResponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleEntityNotFoundException(Exception ex) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    ErrorResponse error = ErrorResponse.builder()
        .code(status.value())
        .error(status.name())
        .message(ex.getMessage())
        .build();
    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(EmailAlreadyTaken.class)
  public ResponseEntity<ErrorResponse> handleEmailAlreadyTaken(Exception ex) {
    HttpStatus status = HttpStatus.CONFLICT;
    ErrorResponse error = ErrorResponse.builder()
        .code(status.value())
        .error(status.name())
        .message(ex.getMessage())
        .build();
    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<ErrorResponse> handleAuthenticationException(Exception ex) {
    HttpStatus status = HttpStatus.UNAUTHORIZED;
    ErrorResponse error = ErrorResponse.builder()
        .code(status.value())
        .error(status.name())
        .message(ex.getMessage())
        .build();
    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationErrorResponse> handleValidException(
      MethodArgumentNotValidException ex) {

    List<FieldErrorModel> errors = ex.getBindingResult().getAllErrors().stream().map(fieldError -> {
      FieldErrorModel fieldErrorModel = new FieldErrorModel();
      fieldErrorModel.setCode(fieldError.getCode());
      fieldErrorModel.setMessage(fieldError.getDefaultMessage());
      fieldErrorModel.setField(((FieldError) fieldError).getField());
      return fieldErrorModel;
    }).toList();

    HttpStatus status = HttpStatus.BAD_REQUEST;
    ValidationErrorResponse response = new ValidationErrorResponse();
    response.setCode(status.value());
    response.setErrors(errors);

    return ResponseEntity.status(status).body(response);
  }

  @ExceptionHandler(RoleAlreadyTaken.class)
  public ResponseEntity<ErrorResponse> handleRoleAlreadyTaken(Exception ex) {
    HttpStatus status = HttpStatus.CONFLICT;
    ErrorResponse error = ErrorResponse.builder()
            .code(status.value())
            .error(status.name())
            .message(ex.getMessage())
            .build();
    return ResponseEntity.status(status).body(error);
  }


}
