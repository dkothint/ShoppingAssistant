package org.asu.mc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "product")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private long pid;

	@Column(name = "store_id")
	private long store_id;
	
	@Column(name = "pname")
	private String pname;

	@Column(name = "category")
	private String category;

	@Column(name = "price")
	private float price;
	
	@Column(name = "discount")
	private float discount;
	
	@Column(name = "beacon_id")
	private long beacon_id;

	@Column(name = "recoProducts")
	private String recoProducts;
	
	public Product() {
		super();
	}

	public Product(long pid, long store_id, String pname, String category, float price, float discount, long beacon_id,
			String recoProducts) {
		super();
		this.pid = pid;
		this.store_id = pid;
		this.pname = pname;
		this.category = category;
		this.price = price;
		this.discount = discount;
		this.beacon_id = beacon_id;
		this.recoProducts = recoProducts;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public long getBeacon_id() {
		return beacon_id;
	}

	public void setBeacon_id(long beacon_id) {
		this.beacon_id = beacon_id;
	}

	public String getRecoProducts() {
		return recoProducts;
	}

	public void setRecoProducts(String recoProducts) {
		this.recoProducts = recoProducts;
	}

	public long getStore_id() {
		return store_id;
	}

	public void setStore_id(long store_id) {
		this.store_id = store_id;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", category=" + category + ", price=" + price
				+ ", discount=" + discount + ", beacon_id=" + beacon_id + ", recoProducts=" + recoProducts + "]";
	}
	
}
