package com.educandoweb.course.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;

import com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryResource {
  @Autowired
  private CategoryService categoryService;

  @GetMapping("")
  public ResponseEntity<List<Category>> findAll() {
    List<Category> categories = categoryService.findAll();

    return ResponseEntity.ok().body(categories);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> findById(@PathVariable UUID id) {
    Category category = categoryService.findById(id);

    if (category == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().body(category);
  }
}