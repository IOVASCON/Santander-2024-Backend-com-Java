package me.dio.dominio.controller;

import me.dio.dominio.model.ApplicationUser;
import me.dio.dominio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application_users")
public class ApplicationUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<ApplicationUser> getAllApplicationUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public ApplicationUser createApplicationUser(@RequestBody ApplicationUser applicationUser) {
        return userRepository.save(applicationUser);
    }
}
