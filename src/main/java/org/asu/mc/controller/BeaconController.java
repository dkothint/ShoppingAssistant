package org.asu.mc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.asu.mc.model.Beacon;
import org.asu.mc.model.Status;
import org.asu.mc.services.BeaconService;
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
@RequestMapping("/beacon")
public class BeaconController {

	@Autowired
	BeaconService beaconService;

	static final Logger logger = Logger.getLogger(BeaconController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addBeacon(@RequestBody Beacon beacon) {
		System.out.println("Beacon : "+beacon);
		try {
			beaconService.addBeacon(beacon);
			return new Status(1, "Beacon added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Beacon getBeacon(@PathVariable("id") long id) {
		Beacon beacon = null;
		try {
			beacon = beaconService.getBeaconById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return beacon;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Beacon> getBeaconList() {

		List<Beacon> beaconList = null;
		try {
			beaconList = beaconService.getBeaconList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return beaconList;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteBeacon(@PathVariable("id") long id) {

		try {
			beaconService.deleteBeacon(id);
			return new Status(1, "Beacon deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
