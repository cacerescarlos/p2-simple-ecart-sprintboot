package com.posgrado.ecommerce.security.jwt;

import com.posgrado.ecommerce.entity.User;

public interface JwtService {

  String createToken(User user);

  User decodeToken(String token);

}
