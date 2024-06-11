package me.dio.dominio.service;

import me.dio.dominio.model.Feature;
import me.dio.dominio.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public List<Feature> findAll() {
        return featureRepository.findAll();
    }

    public Optional<Feature> findById(Long id) {
        return featureRepository.findById(id);
    }

    public Feature save(Feature feature) {
        return featureRepository.save(feature);
    }

    public void deleteById(Long id) {
        featureRepository.deleteById(id);
    }
}
