package com.posgrado.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.posgrado.ecommerce.entity.OrderState;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

  private String comment;
  private List<OrderItemDto> items;

  @JsonProperty(access = Access.READ_ONLY)
  private Double totalPrice;

  @JsonProperty(access = Access.READ_ONLY)
  private OrderState state;
}
