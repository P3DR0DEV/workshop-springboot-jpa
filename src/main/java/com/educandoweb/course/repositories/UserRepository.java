package com.educandoweb.course.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}