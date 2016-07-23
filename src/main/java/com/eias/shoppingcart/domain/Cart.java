package com.eias.shoppingcart.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Eias on 22-Jul-16.
 */
@Entity
@Table(name = "cart", schema = "shoppingcart")
public class Cart {
    private int id;
    private Set<CartItem> items;
    private int userID;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "UserID")
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @OneToMany(mappedBy = "Cart", cascade = CascadeType.ALL)
    public Set<CartItem> getItems() {
        return items;
    }

    public void setItems(Set<CartItem> items) {
        this.items = items;
    }

}
