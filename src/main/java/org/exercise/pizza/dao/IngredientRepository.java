package org.exercise.pizza.dao;

import java.util.List;

import org.exercise.pizza.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    public List<Ingredient> findAllByActiveTrue();
    public Ingredient findOneByName(String name);
}
