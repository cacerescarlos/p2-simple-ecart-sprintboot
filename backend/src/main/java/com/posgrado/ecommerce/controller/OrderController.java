package com.posgrado.ecommerce.controller;

import com.posgrado.ecommerce.dto.OrderDto;
import com.posgrado.ecommerce.service.OrderService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {

  private OrderService orderService;

  @PostMapping
  public ResponseEntity<String> create(@RequestBody OrderDto order) {
    String message = orderService.create(order);
    return ResponseEntity.status(HttpStatus.CREATED).body(message);
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderDto> getById(@PathVariable UUID id) {
    OrderDto orderDto = orderService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(orderDto);
  }

}
