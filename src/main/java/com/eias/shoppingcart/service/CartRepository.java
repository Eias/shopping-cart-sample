package com.eias.shoppingcart.service;

import com.eias.shoppingcart.domain.Cart;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Eias on 23-Jul-16.
 */
public interface CartRepository extends CrudRepository<Cart, Integer>, CartRepositoryCustom {
}
