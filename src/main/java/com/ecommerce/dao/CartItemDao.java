package com.ecommerce.dao;

import com.ecommerce.model.Cart;
import com.ecommerce.model.CartItem;

public interface CartItemDao {
    void addCartItem(CartItem cartItem);
    
    void removeCartItem(int CartItemId);
    
    void removeAllCartItems(Cart cart);
}

