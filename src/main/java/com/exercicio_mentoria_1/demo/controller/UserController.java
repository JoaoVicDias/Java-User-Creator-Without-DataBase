package com.exercicio_mentoria_1.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio_mentoria_1.demo.model.User;

@RestController
public class UserController {

    private static List<User> users = new ArrayList<User>();
    private static int index = 0;

    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        User newUser = new User();

        newUser.setId(index);
        newUser.setName(user.name);

        users.add(newUser);
        index++;

        return newUser;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        int indice = 0;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).id == user.id) {
                indice = i;
            }
        }

        User newUser = new User();

        newUser.setId(user.id);
        newUser.setName(user.name);

        users.set(indice, newUser);

        return newUser;
    }

    @DeleteMapping
    public List<User> deleteUser(@RequestBody User user) {
        users.removeIf(existingUser -> existingUser.id == user.id);

        return users;
    }
}
