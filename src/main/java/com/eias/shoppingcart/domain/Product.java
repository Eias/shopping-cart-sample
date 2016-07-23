package com.eias.shoppingcart.domain;

import javax.persistence.*;

/**
 * Created by Eias on 22-Jul-16.
 */
@Entity
@Table(name = "product", schema = "shoppingcart")
public class Product {
    private int id;
    private String name;
    private Double description;
    private double price;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Description")
    public Double getDescription() {
        return description;
    }

    public void setDescription(Double description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
