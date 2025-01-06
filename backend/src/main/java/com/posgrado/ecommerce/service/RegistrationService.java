package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.dto.RegistrationRequest;

public interface RegistrationService {

  String register(RegistrationRequest dto);

  String confirm(String token);
}
