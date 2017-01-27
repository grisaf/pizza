package org.exercise.pizza.controller;

import java.util.List;

import org.exercise.pizza.model.Size;
import org.exercise.pizza.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/size")
public class SizeController {

    @Autowired
    public SizeService sizeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Size> list() {
        return sizeService.list();
    }
}
