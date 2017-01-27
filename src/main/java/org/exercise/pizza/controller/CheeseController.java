package org.exercise.pizza.controller;

import java.util.List;

import org.exercise.pizza.model.Cheese;
import org.exercise.pizza.service.CheeseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/cheese")
public class CheeseController {

    @Autowired
    public CheeseService cheeseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Cheese> list() {
        return cheeseService.list();
    }
}
