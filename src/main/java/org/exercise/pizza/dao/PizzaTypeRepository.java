package org.exercise.pizza.dao;

import java.util.List;

import org.exercise.pizza.model.PizzaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaTypeRepository extends JpaRepository<PizzaType, Long> {

    public List<PizzaType> findAllByActiveTrue();
    public PizzaType findOneByName(String name);

}
