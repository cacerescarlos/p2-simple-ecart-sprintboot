package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.dto.OrderDto;
import com.posgrado.ecommerce.entity.Order;
import com.posgrado.ecommerce.entity.OrderItem;
import com.posgrado.ecommerce.entity.User;
import com.posgrado.ecommerce.exception.EntityNotFoundException;
import com.posgrado.ecommerce.repository.OrderRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

  private ProductService productService;
  private OrderRepository orderRepository;

  @Override
  public String create(OrderDto dto) {

    Order order = new Order();
    order.setComment(dto.getComment());

    List<OrderItem> items = dto.getItems().stream().map((itemDto) -> {
      OrderItem item = new OrderItem();
      item.setQuantity(itemDto.getQuantity());
      item.setProduct(productService.getById(itemDto.getProductId()));
      item.setOrder(order);
      return item;
    }).toList();

    order.setItems(items);

    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    order.setUser(user);

    Order orderSaved = orderRepository.save(order);

    return "Order saved successfully";
  }

  @Override
  public OrderDto getById(UUID id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Order", id));

    OrderDto orderDto = new OrderDto();
    orderDto.setComment(order.getComment());
    orderDto.setState(order.getState());
    orderDto.setTotalPrice(orderRepository.getTotalPrice(id));
    orderDto.setItems(orderRepository.getItemsWithTotalPrice(id));

    return orderDto;
  }
}
