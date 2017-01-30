package org.exercise.pizza.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.exercise.pizza.parameters.OrderStatus;

@Entity
public class PizzaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PizzaType pizzaType;

    @ManyToMany
    private List<Ingredient> ingredients;

    @ManyToOne
    private Cheese cheese;

    @ManyToOne
    private Sauce sauce;

    @ManyToOne
    private Crust crust;

    private String comment;
    private String status;

    public PizzaOrder() {
    }

    public PizzaOrder(PizzaType pizzaType, List<Ingredient> ingredients, Cheese cheese, Sauce sauce, Crust crust, String comment) {
        this(pizzaType, ingredients, cheese, sauce, crust, comment, OrderStatus.NEW);
    }

    public PizzaOrder(PizzaType pizzaType, List<Ingredient> ingredients, Cheese cheese, Sauce sauce, Crust crust, String comment, String status) {
        this.pizzaType = pizzaType;
        this.ingredients = ingredients;
        this.cheese = cheese;
        this.sauce = sauce;
        this.crust = crust;
        this.comment = comment;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
