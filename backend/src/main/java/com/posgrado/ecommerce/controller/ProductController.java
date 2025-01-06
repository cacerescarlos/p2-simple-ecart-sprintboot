package com.posgrado.ecommerce.controller;

import com.posgrado.ecommerce.dto.PageDto;
import com.posgrado.ecommerce.dto.ProductDto;
import com.posgrado.ecommerce.entity.Product;
import com.posgrado.ecommerce.service.ProductService;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

  private ProductService productService;

  @PostMapping
  public ResponseEntity<Product> create(@Valid @RequestBody ProductDto dto) {
    Product productSaved = productService.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> update(@PathVariable UUID id, @Valid @RequestBody ProductDto dto) {
    Product productSaved = productService.update(id, dto);
    return ResponseEntity.status(HttpStatus.OK).body(productSaved);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getById(@PathVariable UUID id) {
    Product productFound = productService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(productFound);
  }

  @GetMapping("/category/{categoryId}")
  public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable UUID categoryId) {
    List<Product> products = productService.getProductsByCategoryId(categoryId);
    return ResponseEntity.status(HttpStatus.OK).body(products);
  }

  @GetMapping("/category/{categoryId}/pageable")
  public ResponseEntity<PageDto<Product>> getProductsByCategoryIdPagination(
          @PathVariable UUID categoryId,
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "20") int size
  ){
    Pageable pageable = PageRequest.of(page, size);
    PageDto<Product> productPage = productService.getProductsByCategoryIdPagination(categoryId, pageable);
    return ResponseEntity.status(HttpStatus.OK).body(productPage);
  }

  @GetMapping("/pageable")
  public ResponseEntity<Page<Product>> getProducts(@RequestParam int page, @RequestParam int size) {
    Pageable pageable = PageRequest.of(page, size);
    Page<Product> productPage = productService.getProducts(pageable);
    return ResponseEntity.status(HttpStatus.OK).body(productPage);
  }

  @GetMapping
  public ResponseEntity<PageDto<Product>> getFilteredProducts(
      @RequestParam(required = false) Double minPrice,
      @RequestParam(required = false) Double maxPrice,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size,
      @RequestParam(defaultValue = "id") String sortField,
      @RequestParam(defaultValue = "asc") String sortOrder
  ) {
    if (minPrice == null) {
      minPrice = Double.MIN_VALUE;
    }
    if (maxPrice == null) {
      maxPrice = Double.MAX_VALUE;
    }
    Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
    Pageable pageable = PageRequest.of(page, size, sort);
    PageDto<Product> productPage = productService.getFilteredProducts(minPrice, maxPrice, pageable);
    return ResponseEntity.status(HttpStatus.OK).body(productPage);
  }

}
