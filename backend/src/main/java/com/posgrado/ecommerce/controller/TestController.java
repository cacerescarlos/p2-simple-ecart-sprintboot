package com.posgrado.ecommerce.controller;

import com.posgrado.ecommerce.dto.EmailNotification;
import com.posgrado.ecommerce.dto.OrderItemDto;
import com.posgrado.ecommerce.repository.OrderRepository;
import com.posgrado.ecommerce.service.EmailService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {

  private OrderRepository orderRepository;

  private EmailService emailService;

  @GetMapping("/{orderId}")
  public String getTotalPrice(@PathVariable UUID orderId) {
    double totalPriceSQL = orderRepository.getTotalPriceByOrderId(orderId.toString());
    double totalPriceJPQL = orderRepository.getTotalPrice(orderId);
    return "Total price SQL: " + totalPriceSQL + " Total price JPQL: " + totalPriceJPQL;
  }

  @GetMapping("/items/{orderId}")
  public List<OrderItemDto> getListItems(@PathVariable UUID orderId) {
    List<OrderItemDto> items = orderRepository.getItemsWithTotalPrice(orderId);
    return items;
  }

  @PostMapping
  public void sendEmail() {
    EmailNotification emailNotification = EmailNotification.builder()
        .subject("Test")
        .to("cursosderum@gmail.com")
        .body("Hello world")
        .hasTemplate(false)
        .build();
    emailService.send(emailNotification);
  }
}
