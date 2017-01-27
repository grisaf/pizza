package org.exercise.pizza.controller;

import java.util.List;

import org.exercise.pizza.model.Crust;
import org.exercise.pizza.service.CrustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/crust")
public class CrustController {

    @Autowired
    public CrustService crustService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Crust> list() {
        return crustService.list();
    }
}
