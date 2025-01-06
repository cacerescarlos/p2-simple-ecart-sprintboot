package com.posgrado.ecommerce.service;


import com.posgrado.ecommerce.dto.OrderDto;
import java.util.UUID;

public interface OrderService {

  String create(OrderDto order);

  OrderDto getById(UUID id);
}
