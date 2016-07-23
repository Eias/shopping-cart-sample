package com.eias.shoppingcart.service;

import com.eias.shoppingcart.domain.Cart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Eias on 23-Jul-16.
 */
public class CartRepositoryImpl implements CartRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Cart> getOpendCartByUserID(int cartID) {
        return this.entityManager.
                createQuery("select c from Cart c where c.status = 1 AND c.userid = " + cartID).
                getResultList();
    }

}
