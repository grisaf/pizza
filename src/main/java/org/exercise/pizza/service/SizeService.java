package org.exercise.pizza.service;

import java.util.List;

import org.exercise.pizza.dao.SizeRepository;
import org.exercise.pizza.model.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    public Size save(Size size) {
        return sizeRepository.save(size);
    }

    public List<Size> list() {
        return sizeRepository.findAll();
    }

    public Size get(Long id) {
        return sizeRepository.findOne(id);
    }

}
