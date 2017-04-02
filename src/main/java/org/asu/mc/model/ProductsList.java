package org.asu.mc.model;

import java.io.Serializable;

public class ProductsList implements Serializable{

	private long[] products;

	public long[] getProducts() {
		return products;
	}

	public void setProducts(long[] products) {
		this.products = products;
	}

	public ProductsList(long[] products) {
		super();
		this.products = products;
	}

	public ProductsList() {
		super();
	}
	
}
