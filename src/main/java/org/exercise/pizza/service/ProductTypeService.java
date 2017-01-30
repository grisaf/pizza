package org.exercise.pizza.service;

import java.util.List;

import org.exercise.pizza.dao.ProductTypeRepository;
import org.exercise.pizza.factory.OrderFactory;
import org.exercise.pizza.model.ProductOrder;
import org.exercise.pizza.model.ProductType;
import org.exercise.pizza.util.OrderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductOrderService productOrderService;

    @Autowired
    private OrderFactory orderFactory;

    public ProductType save(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    public List<ProductType> list() {
        return productTypeRepository.findAllByActiveTrue();
    }

    public ProductType get(Long id) {
        return productTypeRepository.findOne(id);
    }

    public ProductType add(ProductType productType) {
        ProductType oldProductType = productTypeRepository.findOneByName(productType.getName());
        if (oldProductType == null) {
            return save(productType);
        } else if (!oldProductType.isActive()) {
            oldProductType.setActive(true);
            return save(oldProductType);
        } else {
            return oldProductType;
        }
    }

    public ProductType update(Long id, ProductType productType) {
        ProductType oldProductType = get(id);
        oldProductType.setName(productType.getName());
        oldProductType.setActive(productType.getActive());
        return save(oldProductType);
    }

    public ProductType disable(Long id) {
        ProductType productType = get(id);
        productType.setActive(false);
        return save(productType);
    }

    public ProductOrder order(Long id, OrderData orderData) {
        ProductType productType = get(id);
        ProductOrder productOrder = orderFactory.createProductOrder(productType, orderData);
        return productOrderService.save(productOrder);
    }

}
