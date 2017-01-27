package org.exercise.pizza.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer diameter;
    private Integer slices;

    public Size() {
    }

    public Size(String name, Integer diameter, Integer slices) {
        this.name = name;
        this.diameter = diameter;
        this.slices = slices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public Integer getSlices() {
        return slices;
    }

    public void setSlices(Integer slices) {
        this.slices = slices;
    }

}
