package com.eias.shoppingcart.service;

import com.eias.shoppingcart.domain.CartItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Eias on 23-Jul-16.
 */
public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
}
