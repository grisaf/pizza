package org.exercise.pizza.util;

import java.util.List;

public class OrderData {

    private List<String> remove;
    private List<String> extra;
    private String cheese;
    private String sauce;
    private String crust;
    private String comment;

    public OrderData() {
    }

    public OrderData(List<String> remove, List<String> extra, String cheese, String sauce, String crust, String comment) {
        this.remove = remove;
        this.extra = extra;
        this.cheese = cheese;
        this.sauce = sauce;
        this.crust = crust;
        this.comment = comment;
    }

    public List<String> getRemove() {
        return remove;
    }

    public void setRemove(List<String> remove) {
        this.remove = remove;
    }

    public List<String> getExtra() {
        return extra;
    }

    public void setExtra(List<String> extra) {
        this.extra = extra;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
