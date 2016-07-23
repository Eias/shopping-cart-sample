package com.eias.shoppingcart.service;

import com.eias.shoppingcart.domain.Cart;

import java.util.List;

/**
 * Created by Eias on 23-Jul-16.
 */
public interface CartRepositoryCustom {
    public List<Cart> getOpendCartByUserID(int userID);

}
