package org.asu.mc.dao;

import java.util.List;

import org.asu.mc.model.Beacon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class BeaconDao {
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public boolean addBeacon(Beacon beacon) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(beacon);
		tx.commit();
		session.close();

		return false;
	}

	public Beacon getBeaconById(long id) throws Exception {
		session = sessionFactory.openSession();
		Beacon beacon = (Beacon) session.get(Beacon.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return beacon;
	}

	@SuppressWarnings("unchecked")
	public List<Beacon> getBeaconList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Beacon> beaconList = session.createCriteria(Beacon.class)
				.list();
		tx.commit();
		session.close();
		return beaconList;
	}
	
	public boolean deleteBeacon(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.get(Beacon.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}
}
