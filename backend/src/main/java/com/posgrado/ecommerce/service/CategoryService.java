package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.entity.Category;
import java.util.List;
import java.util.UUID;

public interface CategoryService {

  Category getById(UUID id);

  List<Category> getAll();
}
