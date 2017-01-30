package org.exercise.pizza.dao;

import java.util.List;

import org.exercise.pizza.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    public List<ProductType> findAllByActiveTrue();
    public ProductType findOneByName(String name);

}
