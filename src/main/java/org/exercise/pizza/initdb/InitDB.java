package org.exercise.pizza.initdb;

import java.util.Arrays;
import java.util.List;

import org.exercise.pizza.model.Cheese;
import org.exercise.pizza.model.Crust;
import org.exercise.pizza.model.Ingredient;
import org.exercise.pizza.model.PizzaType;
import org.exercise.pizza.model.ProductType;
import org.exercise.pizza.model.Sauce;
import org.exercise.pizza.model.Size;
import org.exercise.pizza.service.CheeseService;
import org.exercise.pizza.service.CrustService;
import org.exercise.pizza.service.IngredientService;
import org.exercise.pizza.service.PizzaTypeService;
import org.exercise.pizza.service.ProductTypeService;
import org.exercise.pizza.service.SauceService;
import org.exercise.pizza.service.SizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InitDB implements ApplicationListener<ApplicationReadyEvent> {

    private final Logger log = LoggerFactory.getLogger(InitDB.class);

    @Autowired
    private CheeseService cheeseService;

    @Autowired
    private SauceService sauceService;

    @Autowired
    private CrustService crustService;

    @Autowired
    private SizeService sizeService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private PizzaTypeService pizzaTypeService;

    private List<Cheese> cheeses;
    private List<Sauce> sauces;
    private List<Crust> crusts;
    private List<Size> sizes;
    private List<Ingredient> ingredients;
    private List<ProductType> productTypes;
    private List<PizzaType> pizzaTypes;

    public void populateCheese() {
        cheeses = Arrays.asList(new Cheese("mozzarella"), new Cheese("parmesan"), new Cheese("cheddar"));
        for (Cheese cheese : cheeses) {
            cheeseService.save(cheese);
        }
        log.info("Cheeses populated.");
    }

    public void populateSauces() {
        sauces = Arrays.asList(new Sauce("bolognese"), new Sauce("ragu"), new Sauce("bechamel"));
        for (Sauce sauce : sauces) {
            sauceService.save(sauce);
        }
        log.info("Sauces populated");
    }

    public void populateCrusts() {
        crusts = Arrays.asList(new Crust("thin"), new Crust("thick"), new Crust("filled with cheese"));
        for (Crust crust : crusts) {
            crustService.save(crust);
        }
        log.info("Crusts populated");
    }

    public void populateSizes() {
        sizes = Arrays.asList(new Size("personal", 10, 4), new Size("small", 20, 6), new Size("medium", 30, 8),
                new Size("large", 40, 10));
        for (Size size : sizes) {
            sizeService.save(size);
        }
        log.info("Sizes populated");
    }

    public void populateIngredients() {
        ingredients = Arrays.asList(new Ingredient("ham"), new Ingredient("pineapple"), new Ingredient("egg"),
                new Ingredient("corn"), new Ingredient("onion"), new Ingredient("olives"));
        for (Ingredient ingredient : ingredients) {
            ingredientService.save(ingredient);
        }
        log.info("Ingredients populated");
    }

    public void populateProductTypes() {
        productTypes = Arrays.asList(new ProductType("pizza"), new ProductType("spaghetti"), new ProductType("lasagna"),
                new ProductType("salad"));
        for (ProductType productType : productTypes) {
            productTypeService.save(productType);
        }
        log.info("Product Types populated");
    }

    public void populatePizzaTypes() {
        pizzaTypes = Arrays.asList(new PizzaType("hawaiian", Arrays.asList(ingredients.get(0), ingredients.get(1))),
                new PizzaType("brazilian", Arrays.asList(ingredients.get(2), ingredients.get(3))),
                new PizzaType("veggie", Arrays.asList(ingredients.get(4), ingredients.get(5))));
        for (PizzaType pizzaType : pizzaTypes) {
            pizzaTypeService.save(pizzaType);
        }
        log.info("Pizza Types populated");
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        populateCheese();
        populateSauces();
        populateCrusts();
        populateSizes();
        populateIngredients();
        populateProductTypes();
        populatePizzaTypes();
    }
}
