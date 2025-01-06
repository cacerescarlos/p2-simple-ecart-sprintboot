package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.entity.Role;
import java.util.List;

public interface RoleService {

  Role getByName(String name);

  List<Role> getAll();

  Role create(Role role);
}
