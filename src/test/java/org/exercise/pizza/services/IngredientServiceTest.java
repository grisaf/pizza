package org.exercise.pizza.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.exercise.pizza.model.Ingredient;
import org.exercise.pizza.service.IngredientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientServiceTest {

    @Autowired
    private IngredientService ingredientService;

    @Test
    public void addListUpdateGetDelete() {
        String ingredientName = "ingredient name";
        Ingredient ingredient = new Ingredient(ingredientName);
        ingredient = ingredientService.add(ingredient);
        assertEquals(ingredientName, ingredient.getName());
        assertNotNull(ingredient.getId());
        assertTrue(ingredient.getActive());

        List<Ingredient> ingredients = ingredientService.list();
        assertThat(ingredients.contains(ingredient));

        String newIngredientName = "new ingredient name";
        ingredient.setName(newIngredientName);
        ingredient = ingredientService.update(ingredient.getId(), ingredient);
        assertEquals(newIngredientName, ingredient.getName());
        assertNotNull(ingredient.getId());
        assertTrue(ingredient.getActive());

        Ingredient otherIngredient = ingredientService.get(ingredient.getId());
        assertEquals(ingredient.getId(), otherIngredient.getId());
        assertEquals(ingredient.getName(), otherIngredient.getName());
        assertEquals(ingredient.getActive(), otherIngredient.getActive());

        ingredient = ingredientService.disable(ingredient.getId());
        assertFalse(ingredient.getActive());
    }

}
