package org.exercise.pizza.controller;

import java.util.List;

import org.exercise.pizza.model.PizzaOrder;
import org.exercise.pizza.service.PizzaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/pizzaorder")
public class PizzaOrderController {

    @Autowired
    public PizzaOrderService pizzaOrderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<PizzaOrder> list() {
        return pizzaOrderService.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PizzaOrder get(@PathVariable Long id) {
        return pizzaOrderService.get(id);
    }

    @RequestMapping(value = "/{id}/prepare", method = RequestMethod.GET)
    public PizzaOrder prepare(@RequestBody Long id) {
        return pizzaOrderService.prepare(id);
    }

    @RequestMapping(value = "/{id}/deliver", method = RequestMethod.GET)
    public PizzaOrder deliver(@RequestBody Long id) {
        return pizzaOrderService.deliver(id);
    }

    @RequestMapping(value = "/{id}/cancel", method = RequestMethod.GET)
    public PizzaOrder cancel(@RequestBody Long id) {
        return pizzaOrderService.cancel(id);
    }

}
