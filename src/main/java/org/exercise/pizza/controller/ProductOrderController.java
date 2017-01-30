package org.exercise.pizza.controller;

import java.util.List;

import org.exercise.pizza.model.ProductOrder;
import org.exercise.pizza.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/productorder")
public class ProductOrderController {

    @Autowired
    public ProductOrderService productOrderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ProductOrder> list() {
        return productOrderService.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductOrder get(@PathVariable Long id) {
        return productOrderService.get(id);
    }

    @RequestMapping(value = "/{id}/prepare", method = RequestMethod.GET)
    public ProductOrder prepare(@RequestBody Long id) {
        return productOrderService.prepare(id);
    }

    @RequestMapping(value = "/{id}/deliver", method = RequestMethod.GET)
    public ProductOrder deliver(@RequestBody Long id) {
        return productOrderService.deliver(id);
    }

    @RequestMapping(value = "/{id}/cancel", method = RequestMethod.GET)
    public ProductOrder cancel(@RequestBody Long id) {
        return productOrderService.cancel(id);
    }

}
