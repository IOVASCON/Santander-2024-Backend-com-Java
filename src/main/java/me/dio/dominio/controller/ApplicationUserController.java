package me.dio.dominio.controller;

import me.dio.dominio.model.ApplicationUser;
import me.dio.dominio.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/application_users")
public class ApplicationUserController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @GetMapping
    public List<ApplicationUser> getAllApplicationUsers() {
        return applicationUserService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ApplicationUser> getApplicationUserById(@PathVariable Long id) {
        return applicationUserService.findById(id);
    }

    @PostMapping
    public ApplicationUser createApplicationUser(@RequestBody ApplicationUser applicationUser) {
        return applicationUserService.save(applicationUser);
    }

    @DeleteMapping("/{id}")
    public void deleteApplicationUser(@PathVariable Long id) {
        applicationUserService.deleteById(id);
    }
}
