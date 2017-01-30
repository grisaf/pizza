package org.exercise.pizza.service;

import java.util.List;

import org.exercise.pizza.dao.PizzaTypeRepository;
import org.exercise.pizza.factory.OrderFactory;
import org.exercise.pizza.model.Ingredient;
import org.exercise.pizza.model.PizzaOrder;
import org.exercise.pizza.model.PizzaType;
import org.exercise.pizza.util.OrderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaTypeService {

    @Autowired
    private PizzaTypeRepository pizzaTypeRepository;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private PizzaOrderService pizzaOrderService;

    @Autowired
    private OrderFactory orderFactory;

    public PizzaType save(PizzaType pizzaType) {
        if (pizzaType.getIngredients() != null) {
            for (int i = 0; i < pizzaType.getIngredients().size(); i++) {
                Ingredient ingredient = ingredientService.add(pizzaType.getIngredients().get(i));
                pizzaType.getIngredients().set(i, ingredient);
            }
        }
        return pizzaTypeRepository.save(pizzaType);
    }

    public List<PizzaType> list() {
        return pizzaTypeRepository.findAllByActiveTrue();
    }

    public PizzaType get(Long id) {
        return pizzaTypeRepository.findOne(id);
    }

    public PizzaType add(PizzaType pizzaType) {
        PizzaType oldPizzaType = pizzaTypeRepository.findOneByName(pizzaType.getName());
        if (oldPizzaType == null) {
            return save(pizzaType);
        } else if (!oldPizzaType.isActive()) {
            oldPizzaType.setActive(true);
            return save(oldPizzaType);
        } else {
            return oldPizzaType;
        }
    }

    public PizzaType update(Long id, PizzaType pizzaType) {
        PizzaType oldPizzaType = get(id);
        oldPizzaType.setName(pizzaType.getName());
        oldPizzaType.setActive(pizzaType.getActive());
        return save(oldPizzaType);
    }

    public PizzaType disable(Long id) {
        PizzaType pizzaType = get(id);
        pizzaType.setActive(false);
        return save(pizzaType);
    }

    public PizzaOrder order(Long id, OrderData orderData) {
        PizzaType pizzaType = get(id);
        PizzaOrder pizzaOrder = orderFactory.createPizzaOrder(pizzaType, orderData);
        return pizzaOrderService.save(pizzaOrder);
    }

}
