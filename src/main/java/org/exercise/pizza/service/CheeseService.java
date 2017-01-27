package org.exercise.pizza.service;

import java.util.List;

import org.exercise.pizza.dao.CheeseRepository;
import org.exercise.pizza.model.Cheese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheeseService {

    @Autowired
    private CheeseRepository cheeseRepository;

    public Cheese save(Cheese cheese) {
        return cheeseRepository.save(cheese);
    }

    public List<Cheese> list() {
        return cheeseRepository.findAll();
    }

    public Cheese get(Long id) {
        return cheeseRepository.findOne(id);
    }

}
