package org.exercise.pizza.factory;

import java.util.ArrayList;
import java.util.List;

import org.exercise.pizza.dao.CheeseRepository;
import org.exercise.pizza.dao.CrustRepository;
import org.exercise.pizza.dao.SauceRepository;
import org.exercise.pizza.model.Cheese;
import org.exercise.pizza.model.Crust;
import org.exercise.pizza.model.Ingredient;
import org.exercise.pizza.model.PizzaOrder;
import org.exercise.pizza.model.PizzaType;
import org.exercise.pizza.model.ProductOrder;
import org.exercise.pizza.model.ProductType;
import org.exercise.pizza.model.Sauce;
import org.exercise.pizza.service.IngredientService;
import org.exercise.pizza.util.OrderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {

    @Autowired
    private CheeseRepository cheeseRepository;

    @Autowired
    private SauceRepository sauceRepository;

    @Autowired
    private CrustRepository crustRepository;

    @Autowired
    private IngredientService ingredientService;

    public ProductOrder createProductOrder(ProductType productType, OrderData orderData) {
        ProductOrder order = new ProductOrder(productType, orderData.getComment());
        return order;
    }

    public PizzaOrder createPizzaOrder(PizzaType pizzaType, OrderData orderData) {
        List<Ingredient> removedIngredients = new ArrayList<>();
        if (orderData.getRemove() != null) {
            for (String ingredientName : orderData.getRemove()) {
                Ingredient ingredient = new Ingredient(ingredientName);
                ingredient = ingredientService.add(ingredient);
                removedIngredients.add(ingredient);
            }
        }
        List<Ingredient> extraIngredients = new ArrayList<>();
        if (orderData.getExtra() != null) {
            for (String ingredientName : orderData.getExtra()) {
                Ingredient ingredient = new Ingredient(ingredientName);
                ingredient = ingredientService.add(ingredient);
                extraIngredients.add(ingredient);
            }
        }
        List<Ingredient> ingredients = new ArrayList<>(pizzaType.getIngredients());
        ingredients.removeAll(removedIngredients);
        ingredients.addAll(extraIngredients);
        Cheese cheese = cheeseRepository.findOneByNameContainsIgnoreCase(orderData.getCheese());
        Sauce sauce = sauceRepository.findOneByNameContainsIgnoreCase(orderData.getSauce());
        Crust crust = crustRepository.findOneByNameContainsIgnoreCase(orderData.getCrust());
        String comment = orderData.getComment();
        PizzaOrder order = new PizzaOrder(pizzaType, ingredients, cheese, sauce, crust, comment);
        return order;
    }

}
