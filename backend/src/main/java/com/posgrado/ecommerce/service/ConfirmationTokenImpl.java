package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.entity.ConfirmationToken;
import com.posgrado.ecommerce.exception.EntityNotFoundException;
import com.posgrado.ecommerce.repository.ConfirmationTokenRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ConfirmationTokenImpl implements ConfirmationTokenService {

  private ConfirmationTokenRepository repository;

  @Override
  public ConfirmationToken create(ConfirmationToken confirmationToken) {
    return repository.save(confirmationToken);
  }

  @Override
  public ConfirmationToken getByToken(String token) {
    return repository.findByToken(token)
        .orElseThrow(() -> new EntityNotFoundException("Confirmation token not found"));
  }

  @Override
  public void setConfirmedAt(ConfirmationToken confirmationToken) {
    confirmationToken.setConfirmedAt(LocalDateTime.now());
    repository.save(confirmationToken);
  }
}
