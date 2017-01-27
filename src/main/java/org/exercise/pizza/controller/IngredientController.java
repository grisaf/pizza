package org.exercise.pizza.controller;

import java.util.List;

import org.exercise.pizza.model.Ingredient;
import org.exercise.pizza.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ingredient")
public class IngredientController {

    @Autowired
    public IngredientService ingredientService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Ingredient> list() {
        return ingredientService.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Ingredient get(@PathVariable Long id) {
        return ingredientService.get(id);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Ingredient add(@RequestBody Ingredient ingredient) {
        return ingredientService.add(ingredient);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Ingredient update(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        return ingredientService.update(id, ingredient);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Ingredient delete(@PathVariable Long id) {
        return ingredientService.disable(id);
    }

}
