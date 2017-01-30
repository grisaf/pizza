package org.exercise.pizza.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.exercise.pizza.model.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientControllerTest {

    @Autowired
    private IngredientController ingredientController;

    @Test
    public void addListUpdateGetDelete() {
        String ingredientName = "ingredient name";
        Ingredient ingredient = new Ingredient(ingredientName);
        ingredient = ingredientController.add(ingredient);
        assertEquals(ingredientName, ingredient.getName());
        assertNotNull(ingredient.getId());
        assertTrue(ingredient.getActive());

        List<Ingredient> ingredients = ingredientController.list();
        assertThat(ingredients.contains(ingredient));

        String newIngredientName = "new ingredient name";
        ingredient.setName(newIngredientName);
        ingredient = ingredientController.update(ingredient.getId(), ingredient);
        assertEquals(newIngredientName, ingredient.getName());
        assertNotNull(ingredient.getId());
        assertTrue(ingredient.getActive());

        Ingredient otherIngredient = ingredientController.get(ingredient.getId());
        assertEquals(ingredient.getId(), otherIngredient.getId());
        assertEquals(ingredient.getName(), otherIngredient.getName());
        assertEquals(ingredient.getActive(), otherIngredient.getActive());

        ingredient = ingredientController.delete(ingredient.getId());
        assertFalse(ingredient.getActive());
    }

}
