package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/v1/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();

        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        User user = userService.findById(id);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping("create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.insert(user);

        // caminho do novo recurso inserido
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(uri).body(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody User entity) {
        User user = userService.update(id, entity);

        return ResponseEntity.ok().body(user);
    }
}
