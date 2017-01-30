package org.exercise.pizza.controller;

import java.util.List;

import org.exercise.pizza.model.PizzaType;
import org.exercise.pizza.service.PizzaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/pizzatype")
public class PizzaTypeController {

    @Autowired
    public PizzaTypeService pizzaTypeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<PizzaType> list() {
        return pizzaTypeService.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PizzaType get(@PathVariable Long id) {
        return pizzaTypeService.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public PizzaType add(@RequestBody PizzaType pizzaType) {
        return pizzaTypeService.add(pizzaType);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PizzaType update(@PathVariable Long id, @RequestBody PizzaType pizzaType) {
        return pizzaTypeService.update(id, pizzaType);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public PizzaType delete(@PathVariable Long id) {
        return pizzaTypeService.disable(id);
    }

}
