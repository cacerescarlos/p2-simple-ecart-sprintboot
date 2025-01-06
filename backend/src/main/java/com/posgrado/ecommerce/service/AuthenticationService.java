package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.dto.AuthenticationRequest;
import com.posgrado.ecommerce.dto.AuthenticationResponse;

public interface AuthenticationService {

  AuthenticationResponse authenticate(AuthenticationRequest request);

}
