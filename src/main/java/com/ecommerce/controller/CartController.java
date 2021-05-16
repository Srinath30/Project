package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Customer;
import com.ecommerce.service.CartService;
import com.ecommerce.service.CustomerService;

@Controller
public class CartController {
	@Autowired
	private CustomerService customerService;

	@Autowired
	private CartService cartService;

	@GetMapping("/cart/getCartById")
	public ModelAndView getCartId() {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		Customer customer = customerService.getCustomerByUserName(username);
		ModelAndView modelAndView = new ModelAndView("cart", "cartId", customer.getCart().getId());
		return modelAndView;
	}

	@GetMapping("/cart/getCart/{cartId}")
	@ResponseBody
	public Cart getCartItems(@PathVariable(value = "cartId") int cartId) {
		return cartService.getCartById(cartId);
	}
}