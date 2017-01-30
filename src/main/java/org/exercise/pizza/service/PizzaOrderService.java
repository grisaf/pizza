package org.exercise.pizza.service;

import java.util.List;

import org.exercise.pizza.dao.PizzaOrderRepository;
import org.exercise.pizza.model.PizzaOrder;
import org.exercise.pizza.parameters.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaOrderService {

    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;

    public PizzaOrder save(PizzaOrder pizzaOrder) {
        return pizzaOrderRepository.save(pizzaOrder);
    }

    public List<PizzaOrder> list() {
        return pizzaOrderRepository.findAll();
    }

    public PizzaOrder get(Long id) {
        return pizzaOrderRepository.findOne(id);
    }

    public PizzaOrder prepare(Long id) {
        PizzaOrder pizzaOrder = get(id);
        pizzaOrder.setStatus(OrderStatus.PREPARED);
        return save(pizzaOrder);
    }

    public PizzaOrder deliver(Long id) {
        PizzaOrder pizzaOrder = get(id);
        pizzaOrder.setStatus(OrderStatus.DELIVERED);
        return save(pizzaOrder);
    }

    public PizzaOrder cancel(Long id) {
        PizzaOrder pizzaOrder = get(id);
        pizzaOrder.setStatus(OrderStatus.CANCELLED);
        return save(pizzaOrder);
    }

}
