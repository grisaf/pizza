package org.exercise.pizza.controller;

import java.util.List;

import org.exercise.pizza.model.Sauce;
import org.exercise.pizza.service.SauceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/sauce")
public class SauceController {

    @Autowired
    public SauceService sauceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Sauce> list() {
        return sauceService.list();
    }
}
