package org.asu.mc.dao;

import java.util.List;

import org.asu.mc.model.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class FeedbackDao {
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public boolean addFeedback(Feedback feedback) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(feedback);
		tx.commit();
		session.close();

		return false;
	}

	public Feedback getFeedbackById(long id) throws Exception {
		session = sessionFactory.openSession();
		Feedback feedback = (Feedback) session.get(Feedback.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return feedback;
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> getFeedbackList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Feedback> feedbackList = session.createCriteria(Feedback.class)
				.list();
		tx.commit();
		session.close();
		return feedbackList;
	}
	
	public boolean deleteFeedback(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.get(Feedback.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}
}
