package org.exercise.pizza.service;

import java.util.List;

import org.exercise.pizza.dao.SauceRepository;
import org.exercise.pizza.model.Sauce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SauceService {

    @Autowired
    private SauceRepository sauceRepository;

    public Sauce save(Sauce sauce) {
        return sauceRepository.save(sauce);
    }

    public List<Sauce> list() {
        return sauceRepository.findAll();
    }

    public Sauce get(Long id) {
        return sauceRepository.findOne(id);
    }

}
