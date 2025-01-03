package com.educandoweb.course.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController
@RequestMapping("api/v1/orders")
public class OrderResource {
  @Autowired
  private OrderService orderService;

  @GetMapping("")
  public ResponseEntity<List<Order>> findAll() {
    List<Order> orders = orderService.findAll();

    return ResponseEntity.ok().body(orders);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Order> findById(@PathVariable UUID id) {
    Order order = orderService.findById(id);

    if (order == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().body(order);
  }
}
