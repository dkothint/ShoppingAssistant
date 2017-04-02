package org.asu.mc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.asu.mc.model.Product;
import org.asu.mc.model.Status;
import org.asu.mc.services.ProductService;
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
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	static final Logger logger = Logger.getLogger(ProductController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addProduct(@RequestBody Product product) {
		System.out.println("Product : "+product);
		try {
			productService.addProduct(product);
			return new Status(1, "Product added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Product getProduct(@PathVariable("id") long id) {
		Product product = null;
		try {
			product = productService.getProductById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Product> getProductList() {

		List<Product> productList = null;
		try {
			productList = productService.getProductList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productList;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteProduct(@PathVariable("id") long id) {

		try {
			productService.deleteProduct(id);
			return new Status(1, "Product deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
