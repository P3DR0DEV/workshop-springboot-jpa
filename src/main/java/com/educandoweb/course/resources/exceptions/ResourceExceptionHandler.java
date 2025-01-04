package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

    String error = "Resource not found";
    HttpStatus status = HttpStatus.NOT_FOUND;
    String path = request.getRequestURI();

    StandardError errorResponse = new StandardError(Instant.now(), error, status.value(), e.getMessage(), path);

    return ResponseEntity.status(status).body(errorResponse);
  }

  @ExceptionHandler(DatabaseException.class)
  public ResponseEntity<StandardError> databaseException(DatabaseException e, HttpServletRequest request) {

    String error = "Database error";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    String path = request.getRequestURI();

    StandardError errorResponse = new StandardError(Instant.now(), error, status.value(), e.getMessage(), path);

    return ResponseEntity.status(status).body(errorResponse);
  }
}
