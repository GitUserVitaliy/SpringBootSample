package com.cko.sampleSpringProject.controller.rest;

import com.cko.sampleSpringProject.dao.UserDAO;
import com.cko.sampleSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    UserDAO userDAO;

    @PostMapping("/add")
    public void addUser() {

    }

    @GetMapping
    public User getUserById(@RequestParam Long id) {
        return userDAO.findUserById(id);
    }
}
