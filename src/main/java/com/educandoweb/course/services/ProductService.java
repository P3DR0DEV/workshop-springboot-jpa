package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public List<Product> findAll() {
    return repository.findAll();
  }

  public Product findById(UUID id) {
    Optional<Product> product = repository.findById(id);

    return product.orElseThrow(() -> new ResourceNotFoundException(id));
  }
}
