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
@Table(name = "beacon")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Beacon implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "store_id")
	private long store_id;

	@Column(name = "isPrimary")
	private boolean isPrimary;
	
	@Column(name = "map_index")
	private long map_index;
	
	@Column(name = "defProductId")
	private long defProductId;
	
	public Beacon() {
		super();
	}

	public Beacon(long id, String name, long store_id, boolean isPrimary, long map_index, long defProductId) {
		super();
		this.id = id;
		this.name = name;
		this.store_id = store_id;
		this.isPrimary = isPrimary;
		this.map_index = map_index;
		this.defProductId = defProductId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getStore_id() {
		return store_id;
	}

	public void setStore_id(long store_id) {
		this.store_id = store_id;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public long getMap_index() {
		return map_index;
	}

	public void setMap_index(long map_index) {
		this.map_index = map_index;
	}

	public long getDefProductId() {
		return defProductId;
	}

	public void setDefProductId(long defProductId) {
		this.defProductId = defProductId;
	}

}
