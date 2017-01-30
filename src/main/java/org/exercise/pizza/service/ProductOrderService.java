package org.exercise.pizza.service;

import java.util.List;

import org.exercise.pizza.dao.ProductOrderRepository;
import org.exercise.pizza.model.ProductOrder;
import org.exercise.pizza.parameters.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    public ProductOrder save(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }

    public List<ProductOrder> list() {
        return productOrderRepository.findAll();
    }

    public ProductOrder get(Long id) {
        return productOrderRepository.findOne(id);
    }

    public ProductOrder prepare(Long id) {
        ProductOrder productOrder = get(id);
        productOrder.setStatus(OrderStatus.PREPARED);
        return save(productOrder);
    }

    public ProductOrder deliver(Long id) {
        ProductOrder productOrder = get(id);
        productOrder.setStatus(OrderStatus.DELIVERED);
        return save(productOrder);
    }
    
    public ProductOrder cancel(Long id) {
        ProductOrder productOrder = get(id);
        productOrder.setStatus(OrderStatus.CANCELLED);
        return save(productOrder);
    }
    
}
