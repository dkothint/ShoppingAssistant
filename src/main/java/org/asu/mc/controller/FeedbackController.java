package org.asu.mc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.asu.mc.model.Feedback;
import org.asu.mc.model.Status;
import org.asu.mc.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * This is a simple web application that caters to the cloud based web services used by the
 * Shopping assistant mobile application. 
 * 
 * This application has been developed using the following article as the guideline and the code given is modified based 
 * on our needs :
 * http://www.beingjavaguys.com/2014/08/spring-restful-web-services.html
 *  
 * @author DurgaPrasad
 *
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;

	static final Logger logger = Logger.getLogger(FeedbackController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addFeedback(@RequestBody Feedback feedback) {
		System.out.println("Feedback : "+feedback);
		try {
			feedbackService.addFeedback(feedback);
			return new Status(1, "Feedback added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Feedback getFeedback(@PathVariable("id") long id) {
		Feedback feedback = null;
		try {
			feedback = feedbackService.getFeedbackById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return feedback;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Feedback> getFeedbackList() {

		List<Feedback> feedbackList = null;
		try {
			feedbackList = feedbackService.getFeedbackList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return feedbackList;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteFeedback(@PathVariable("id") long id) {

		try {
			feedbackService.deleteFeedback(id);
			return new Status(1, "Feedback deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
