package org.exercise.pizza.service;

import java.util.List;

import org.exercise.pizza.dao.CrustRepository;
import org.exercise.pizza.model.Crust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrustService {

    @Autowired
    private CrustRepository crustRepository;

    public Crust save(Crust crust) {
        return crustRepository.save(crust);
    }

    public List<Crust> list() {
        return crustRepository.findAll();
    }

    public Crust get(Long id) {
        return crustRepository.findOne(id);
    }

}
