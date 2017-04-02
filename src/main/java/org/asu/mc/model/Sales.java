package org.asu.mc.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "sales")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Sales implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private long transaction_id;

	@Column(name = "store_id")
	private long store_id;

	@Column(name = "transaction_time")
	private Timestamp transaction_time;
	
	@Column(name = "products")
	private String products;
	
	public Sales() {
		super();
	}

	public Sales(long transaction_id, long store_id, Timestamp transaction_time, String products) {
		super();
		this.transaction_id = transaction_id;
		this.store_id = store_id;
		this.transaction_time = transaction_time;
		this.products = products;
	}

	public long getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}

	public long getStore_id() {
		return store_id;
	}

	public void setStore_id(long store_id) {
		this.store_id = store_id;
	}

	public Timestamp getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(Timestamp transaction_time) {
		this.transaction_time = transaction_time;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

}
