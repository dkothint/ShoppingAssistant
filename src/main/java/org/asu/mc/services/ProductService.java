package org.asu.mc.services;

import java.util.List;

import org.asu.mc.dao.ProductDao;
import org.asu.mc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public boolean addProduct(Product product) throws Exception {
		return productDao.addProduct(product);
	}

	public Product getProductById(long id) throws Exception {
		return productDao.getProductById(id);
	}

	public List<Product> getProductList() throws Exception {
		return productDao.getProductList();
	}

	public boolean deleteProduct(long id) throws Exception {
		return productDao.deleteProduct(id);
	}

}
