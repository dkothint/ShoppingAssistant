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
@Table(name = "feedback")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Feedback implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	private long feedback_id;

	@Column(name = "store_id")
	private long store_id;

	@Column(name = "feedback_time")
	private Timestamp feedback_time;
	
	@Column(name = "productsNotPicked")
	private String productsNotPicked;
	
	public Feedback() {
		super();
	}

	public Feedback(long feedback_id, long store_id, Timestamp feedback_time, String productsNotPicked) {
		super();
		this.feedback_id = feedback_id;
		this.store_id = store_id;
		this.feedback_time = feedback_time;
		this.productsNotPicked = productsNotPicked;
	}

	public long getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(long feedback_id) {
		this.feedback_id = feedback_id;
	}

	public long getStore_id() {
		return store_id;
	}

	public void setStore_id(long store_id) {
		this.store_id = store_id;
	}

	public Timestamp getFeedback_time() {
		return feedback_time;
	}

	public void setFeedback_time(Timestamp feedback_time) {
		this.feedback_time = feedback_time;
	}

	public String getProductsNotPicked() {
		return productsNotPicked;
	}

	public void setProductsNotPicked(String productsNotPicked) {
		this.productsNotPicked = productsNotPicked;
	}

	
}
