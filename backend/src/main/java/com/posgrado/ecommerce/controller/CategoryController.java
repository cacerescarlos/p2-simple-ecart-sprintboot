package com.posgrado.ecommerce.controller;

import com.posgrado.ecommerce.entity.Category;
import com.posgrado.ecommerce.service.CategoryService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategoryController {

  private CategoryService categoryService;

  @GetMapping("/{id}")
  public ResponseEntity<Category> getById(@PathVariable UUID id) {
    Category categoryFound = categoryService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(categoryFound);
  }

  @GetMapping
  public ResponseEntity<List<Category>> getAll() {
    List<Category> categories = categoryService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(categories);
  }
}
