package com.ecommerce.dao;

import java.io.IOException;
import com.ecommerce.model.Cart;

public interface CartDao {
	Cart getCartById(int cartId);

	Cart validate(int cartId) throws IOException;
}