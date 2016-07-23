package com.eias.shoppingcart.service;

import com.eias.shoppingcart.domain.Cart;
import com.eias.shoppingcart.domain.CartItem;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Eias on 23-Jul-16.
 */
public class CartService {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public void addToCart(CartItem item) {

        //if the added item already exists in the cart, increment the quantity by one
        if(isItemExists(item)) {
            item.incrementQuantity();
        }else{
            Cart cart = getCart();
            item.setCartID(cart.getId());
        }

        cartItemRepository.save(item); //save the added or updated item to database
    }

    public void removeFromCart(CartItem item) {
        cartItemRepository.delete(item); //remove the item from database
    }

    public Cart getCart(){
        Object cartID = this.httpSession.getAttribute("cart_id");
        Cart cart = null;

        //if cart
        if(cartID == null) {
            Object loggedUserID = this.httpSession.getAttribute("user_id");

            //if the user is logged in
            if(loggedUserID != null) {
                int userID = (int)loggedUserID;

                List<Cart> carts = cartRepository.getOpendCartByUserID(userID); //get the current cart for logged in user

                //if the logged in user has an open cart
                if(carts.size() > 0) {
                    cart = carts.get(0);
                }else {
                    //create new cart
                    cart = new Cart();
                    cart.setUserID(userID);
                }
            }

            cart = cartRepository.save(cart); //save the cart to database
            this.httpSession.setAttribute("cart_id", cart.getId()); //save the cart id in the session

        }else{
            //get cart for the logged in user from the database
            cart = cartRepository.findOne((int)cartID);
        }
        return cart;
    }

    private boolean isItemExists(CartItem item) {

        //iterate over shopping cart items
        for (CartItem i : getCart().getItems()) {

            //check if item exists
            if(i.getId() == item.getId())
                return true;
        }
        return false;
    }
}