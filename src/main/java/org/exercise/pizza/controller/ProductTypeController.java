package org.exercise.pizza.controller;

import java.util.List;

import org.exercise.pizza.model.ProductType;
import org.exercise.pizza.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/producttype")
public class ProductTypeController {

    @Autowired
    public ProductTypeService productTypeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ProductType> list() {
        return productTypeService.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductType get(@PathVariable Long id) {
        return productTypeService.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ProductType add(@RequestBody ProductType productType) {
        return productTypeService.add(productType);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ProductType update(@PathVariable Long id, @RequestBody ProductType productType) {
        return productTypeService.update(id, productType);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ProductType delete(@PathVariable Long id) {
        return productTypeService.disable(id);
    }

}
