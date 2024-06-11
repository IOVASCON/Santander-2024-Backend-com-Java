package me.dio.dominio.service;

import me.dio.dominio.model.ApplicationUser;
import me.dio.dominio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserService {

    @Autowired
    private UserRepository userRepository;

    public List<ApplicationUser> findAll() {
        return userRepository.findAll();
    }

    public Optional<ApplicationUser> findById(Long id) {
        return userRepository.findById(id);
    }

    public ApplicationUser save(ApplicationUser user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
