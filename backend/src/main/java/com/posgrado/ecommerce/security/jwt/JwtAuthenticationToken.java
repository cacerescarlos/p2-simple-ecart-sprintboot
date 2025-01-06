package com.posgrado.ecommerce.security.jwt;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

  private final Object principal;

  public JwtAuthenticationToken(Object principal) {
    super(null);
    this.principal = principal;
    super.setAuthenticated(false);
  }

  public JwtAuthenticationToken(
      Object principal,
      Collection<? extends GrantedAuthority> authorities
  ) {
    super(authorities);
    this.principal = principal;
    super.setAuthenticated(true);
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return principal;
  }
}
