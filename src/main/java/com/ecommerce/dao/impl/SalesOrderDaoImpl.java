package com.ecommerce.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.SalesOrderDao;
import com.ecommerce.model.SalesOrder;

@Repository
public class SalesOrderDaoImpl implements SalesOrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addSalesOrder(SalesOrder salesOrder) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(salesOrder);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}