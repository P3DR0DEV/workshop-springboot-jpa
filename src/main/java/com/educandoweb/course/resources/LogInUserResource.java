package com.educandoweb.course.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
import com.educandoweb.course.util.BcryptHashPassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/sign-in")
public class LogInUserResource {

  @Autowired
  private UserService userService;

  @PostMapping("")
  public ResponseEntity<String> postMethodName(@RequestBody User entity) {
    User user = userService.findByEmail(entity.getEmail());

    if (user == null) {
      return ResponseEntity.badRequest().body("Email incorreto");
    }

    // primeiro parametro é a senha enviada, segundo é a senha salva no banco
    Boolean passwordVerification = BcryptHashPassword.verifyPassword(entity.getPassword(), user.getPassword());

    if (!passwordVerification) {
      return ResponseEntity.status(
          HttpStatus.UNAUTHORIZED).body("Email ou senha incorretos");
    }

    return ResponseEntity.ok().body("Login efetuado com sucesso");
  }

}