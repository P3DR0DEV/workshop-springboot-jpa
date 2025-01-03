package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_payment")
public class Payment implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;
  private Instant moment;

  @OneToOne
  @MapsId
  @JsonIgnore
  private Order order;

  public Payment() {
  }

  public Payment(UUID id, Instant moment, Order order) {
    this.id = id;
    this.moment = moment;
    this.order = order;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public Order getOrder() {
    return order;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Payment other = (Payment) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
