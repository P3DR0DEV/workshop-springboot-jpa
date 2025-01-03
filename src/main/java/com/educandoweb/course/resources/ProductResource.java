package com.educandoweb.course.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController
@RequestMapping("api/v1/products")
public class ProductResource {
  @Autowired
  private ProductService productService;

  @GetMapping("")
  public ResponseEntity<List<Product>> findAll() {
    List<Product> products = productService.findAll();

    return ResponseEntity.ok().body(products);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> findById(@PathVariable UUID id) {
    Product product = productService.findById(id);

    if (product == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().body(product);
  }
}