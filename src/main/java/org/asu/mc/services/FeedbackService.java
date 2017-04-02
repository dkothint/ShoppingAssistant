package org.asu.mc.services;

import java.util.List;

import org.asu.mc.dao.FeedbackDao;
import org.asu.mc.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;

public class FeedbackService {

	@Autowired
	FeedbackDao feedbackDao;
	
	public boolean addFeedback(Feedback feedback) throws Exception {
		return feedbackDao.addFeedback(feedback);
	}

	public Feedback getFeedbackById(long id) throws Exception {
		return feedbackDao.getFeedbackById(id);
	}

	public List<Feedback> getFeedbackList() throws Exception {
		return feedbackDao.getFeedbackList();
	}

	public boolean deleteFeedback(long id) throws Exception {
		return feedbackDao.deleteFeedback(id);
	}

}
