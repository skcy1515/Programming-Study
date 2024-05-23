package com.group.libraryapp.Controller.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.userCreateRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();

    @PostMapping("/user")
    public void saveUser(@RequestBody userCreateRequest request) {
        users.add(new User(request.getName(), request.getAge()));
    }
}