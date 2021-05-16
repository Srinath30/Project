package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Customer;
import com.ecommerce.model.SalesOrder;
import com.ecommerce.service.CartService;
import com.ecommerce.service.SalesOrderService;

@Controller
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private SalesOrderService customerOrderService;

	@RequestMapping(value = "/order/{cartId}", method = RequestMethod.GET)
	public String createOrder(@PathVariable("cartId") int cartId) {

		SalesOrder salesOrder = new SalesOrder();
		Cart cart = cartService.getCartById(cartId);
		salesOrder.setCart(cart);

		Customer customer = cart.getCustomer();
		salesOrder.setCustomer(customer);
		salesOrder.setShippingAddress(customer.getShippingAddress());
		salesOrder.setBillingAddress(customer.getBillingAddress());
		customerOrderService.addSalesOrder(salesOrder);
		return "redirect:/checkout?cartId=" + cartId;
	}
}
