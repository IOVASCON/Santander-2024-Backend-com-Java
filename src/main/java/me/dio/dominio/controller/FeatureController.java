package me.dio.dominio.controller;

import me.dio.dominio.model.Feature;
import me.dio.dominio.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @GetMapping
    public List<Feature> getAllFeatures() {
        return featureService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Feature> getFeatureById(@PathVariable Long id) {
        return featureService.findById(id);
    }

    @PostMapping
    public Feature createFeature(@RequestBody Feature feature) {
        return featureService.save(feature);
    }

    @DeleteMapping("/{id}")
    public void deleteFeature(@PathVariable Long id) {
        featureService.deleteById(id);
    }
}
