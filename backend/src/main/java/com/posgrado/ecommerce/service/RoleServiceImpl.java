package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.entity.Role;
import com.posgrado.ecommerce.exception.EntityNotFoundException;
import com.posgrado.ecommerce.exception.RoleAlreadyTaken;
import com.posgrado.ecommerce.repository.RoleRepository;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

  private RoleRepository roleRepository;

  @Override
  public Role getByName(String name) {
    return roleRepository.findByName(name)
        .orElseThrow(() -> new EntityNotFoundException("Role not found"));
  }

  @Override
  public List<Role> getAll() {
    return roleRepository.findAll();
  }

  @Override
  public Role create(Role role) {
    Optional<Role> roleFound = roleRepository.findByName(role.getName());
    if (roleFound.isPresent()) {
      throw new RoleAlreadyTaken(role.getName());
    }

    return roleRepository.save(role);
  }

}
