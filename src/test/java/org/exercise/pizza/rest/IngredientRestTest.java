package org.exercise.pizza.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exercise.pizza.model.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IngredientRestTest {

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void addListUpdateGetDelete() {
        String basePath = "/api/ingredient/";

        String ingredientName = "ingredient name";
        Ingredient newIngredient = restTemplate.postForObject(basePath, new Ingredient(ingredientName), Ingredient.class);
        assertEquals(ingredientName, newIngredient.getName());

        List<Map<String, Object>> ingredientsResponse = restTemplate.getForObject(basePath, List.class);
        List<Ingredient> ingredients = new ArrayList<>();
        for (Map<String, Object> ingredientResponse : ingredientsResponse) {
            Ingredient ingredient = new Ingredient();
            ingredient.setId(((Integer)ingredientResponse.get("id")).longValue());
            ingredient.setName(ingredientResponse.get("name").toString());
            ingredient.setActive(Boolean.parseBoolean(ingredientResponse.get("active").toString()));
            ingredients.add(ingredient);
        }
        assertThat(ingredients.size() != 0);
        assertThat(ingredients.contains(newIngredient));

        String entityPath = basePath + "/{id}";

        String newIngredientName = "new ingredient name";
        Ingredient updatedIngredient = new Ingredient(newIngredientName);
        Map<String, String> param = new HashMap<String, String>();
        param.put("id", newIngredient.getId() + "");
        HttpEntity<Ingredient> ingredientEntity = new HttpEntity<Ingredient>(updatedIngredient);
        updatedIngredient = restTemplate.exchange(entityPath, HttpMethod.PUT, ingredientEntity, Ingredient.class, param).getBody();
        assertEquals(newIngredientName, updatedIngredient.getName());
        assertEquals(newIngredient.getId(), updatedIngredient.getId());
        assertTrue(updatedIngredient.getActive());

        Ingredient getIngredient = restTemplate.getForObject(entityPath, Ingredient.class, param);
        assertEquals(updatedIngredient.getId(), getIngredient.getId());
        assertEquals(updatedIngredient.getName(), getIngredient.getName());
        assertTrue(getIngredient.getActive());

        Ingredient deletedIngredient = restTemplate.exchange(entityPath, HttpMethod.DELETE, null, Ingredient.class, param).getBody();
        assertEquals(getIngredient.getId(), deletedIngredient.getId());
        assertEquals(getIngredient.getName(), deletedIngredient.getName());
        assertFalse(deletedIngredient.getActive());
    }

}
