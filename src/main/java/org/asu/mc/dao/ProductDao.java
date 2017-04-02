package org.asu.mc.dao;

import java.util.List;

import org.asu.mc.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public boolean addProduct(Product product) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(product);
		tx.commit();
		session.close();

		return false;
	}

	public Product getProductById(long id) throws Exception {
		session = sessionFactory.openSession();
		Product product = (Product) session.get(Product.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Product> productList = session.createCriteria(Product.class)
				.list();
		tx.commit();
		session.close();
		return productList;
	}
	
	public boolean deleteProduct(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.get(Product.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}
}
