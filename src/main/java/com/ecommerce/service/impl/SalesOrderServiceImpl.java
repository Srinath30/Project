package com.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.SalesOrderDao;
import com.ecommerce.model.SalesOrder;
import com.ecommerce.service.SalesOrderService;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

	@Autowired
	private SalesOrderDao salesOrderDao;

	public void addSalesOrder(SalesOrder salesOrder) {
		salesOrderDao.addSalesOrder(salesOrder);
	}
}
