package com.eias.shoppingcart.domain;

import javax.persistence.*;

/**
 * Created by Eias on 22-Jul-16.
 */
@Entity
@Table(name = "cartitem", schema = "shoppingcart")
public class CartItem {
    private int id;
    private int cartID;
    private double price;
    private int quantity;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    @Basic
    @Column(name = "Price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity(){
        this.quantity++;
    }
}
