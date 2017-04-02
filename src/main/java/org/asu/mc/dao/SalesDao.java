package org.asu.mc.dao;

import java.util.List;

import org.asu.mc.model.Sales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class SalesDao {
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public boolean addSales(Sales sales) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(sales);
		tx.commit();
		session.close();

		return false;
	}

	public Sales getSalesById(long id) throws Exception {
		System.out.println("In dao");
		session = sessionFactory.openSession();
		Sales sales = (Sales) session.get(Sales.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		System.out.println("Sales from DB : "+sales);
		return sales;
	}

	@SuppressWarnings("unchecked")
	public List<Sales> getSalesList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Sales> salesList = session.createCriteria(Sales.class)
				.list();
		tx.commit();
		session.close();
		return salesList;
	}
	
	public boolean deleteSales(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.get(Sales.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}
}
