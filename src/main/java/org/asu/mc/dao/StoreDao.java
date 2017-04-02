package org.asu.mc.dao;

import java.util.List;

import org.asu.mc.model.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class StoreDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public boolean addStore(Store store) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(store);
		tx.commit();
		session.close();

		return false;
	}

	public Store getStoreById(long id) throws Exception {
		session = sessionFactory.openSession();
		Store store = (Store) session.get(Store.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return store;
	}

	@SuppressWarnings("unchecked")
	public List<Store> getStoreList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Store> storeList = session.createCriteria(Store.class)
				.list();
		tx.commit();
		session.close();
		return storeList;
	}
	
	public boolean deleteStore(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.get(Store.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
