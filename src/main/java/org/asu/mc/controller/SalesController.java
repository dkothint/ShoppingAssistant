package org.asu.mc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.asu.mc.model.Sales;
import org.asu.mc.model.Status;
import org.asu.mc.services.SalesService;
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
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	SalesService salesService;

	static final Logger logger = Logger.getLogger(SalesController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addSales(@RequestBody Sales sales) {
		try {
			salesService.addSales(sales);
			return new Status(1, "Sales added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Sales getSales(@PathVariable("id") long id) {
		System.out.println("id : " +id);
		Sales sales = null;
		try {
			sales = salesService.getSalesById(id);
			System.out.println("returning : "+sales);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sales;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Sales> getSalesList() {

		List<Sales> salesList = null;
		try {
			salesList = salesService.getSalesList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return salesList;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteSales(@PathVariable("id") long id) {

		try {
			salesService.deleteSales(id);
			return new Status(1, "Sales deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
