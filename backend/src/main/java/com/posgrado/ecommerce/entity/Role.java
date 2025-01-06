package com.posgrado.ecommerce.entity;

import jakarta.persistence.*;

import java.sql.Types;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;

  private String name;

  private String description;

}
