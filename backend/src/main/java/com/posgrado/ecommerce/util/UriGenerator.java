package com.posgrado.ecommerce.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class UriGenerator {

  public static String create(String path, String queryName, String queryValue) {
    return ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path(path)
        .queryParam(queryName, queryValue)
        .build()
        .toUriString();
  }

}
