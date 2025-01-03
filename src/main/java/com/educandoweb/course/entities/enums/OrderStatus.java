package com.educandoweb.course.entities.enums;

public enum OrderStatus {
  WAITING_PAYMENT(0),
  PAID(1),
  SHIPPED(2),
  DELIVERED(3),
  CANCELLED(4);

  private int value;

  private OrderStatus(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static OrderStatus fromValue(int value) {
    for (OrderStatus status : OrderStatus.values()) {
      if (status.getValue() == value) {
        return status;
      }
    }
    throw new IllegalArgumentException("Invalid Order Status code: " + value);
  }
}
