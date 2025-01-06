package com.posgrado.ecommerce.controller;

import com.posgrado.ecommerce.entity.Role;
import com.posgrado.ecommerce.service.RoleService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/roles")
public class RoleController {

  private RoleService roleService;

  @GetMapping("/name/{name}")
  public ResponseEntity<Role> getByName(@PathVariable String name) {
    Role roleFound = roleService.getByName(name);
    return ResponseEntity.status(HttpStatus.OK).body(roleFound);
  }

  @PostMapping
  public ResponseEntity<Role> create(@RequestBody Role role) {
    Role roleSaved = roleService.create(role);
    return ResponseEntity.status(HttpStatus.CREATED).body(roleSaved);
  }

  @GetMapping
  public ResponseEntity<List<Role>> getAll() {
    List<Role> roles = roleService.getAll();
    return ResponseEntity.ok(roles);
  }

}
