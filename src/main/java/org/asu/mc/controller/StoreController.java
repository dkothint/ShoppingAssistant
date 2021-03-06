package org.asu.mc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.asu.mc.model.Store;
import org.asu.mc.model.Status;
import org.asu.mc.services.StoreService;
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
@RequestMapping("/store")
public class StoreController {

	@Autowired
	StoreService storeService;

	static final Logger logger = Logger.getLogger(StoreController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addStore(@RequestBody Store store) {
		System.out.println("Store : "+store);
		try {
			storeService.addStore(store);
			return new Status(1, "Store added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Store getStore(@PathVariable("id") long id) {
		Store store = null;
		try {
			store = storeService.getStoreById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return store;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Store> getStoreList() {

		List<Store> storeList = null;
		try {
			storeList = storeService.getStoreList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return storeList;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteStore(@PathVariable("id") long id) {

		try {
			storeService.deleteStore(id);
			return new Status(1, "Store deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
