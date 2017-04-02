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
@Table(name = "store")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Store implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "storeName")
	private String storeName;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "primaryBeaconId")
	private long primaryBeaconId;

	@Column(name = "map")
	private String map;
	
	@Column(name = "recoMessage")
	private String recoMessage;

	@Column(name = "userId")
	private String userId;

	@Column(name = "password")
	private String password;
	

	@Column(name = "lastRecoEngineSyncTime")
	private Timestamp lastRecoEngineSyncTime;

	public Store() {
		super();
	}

	public Store(int id, String storeName, String latitude, String longitude, boolean status, long primaryBeaconId,
			String map, String recoMessage, String userId, String password, Timestamp lastRecoEngineSyncTime) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
		this.primaryBeaconId = primaryBeaconId;
		this.map = map;
		this.recoMessage = recoMessage;
		this.userId = userId;
		this.password = password;
		this.lastRecoEngineSyncTime = lastRecoEngineSyncTime;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public long getPrimaryBeaconId() {
		return primaryBeaconId;
	}


	public void setPrimaryBeaconId(long primaryBeaconId) {
		this.primaryBeaconId = primaryBeaconId;
	}


	public String getMap() {
		return map;
	}


	public void setMap(String map) {
		this.map = map;
	}


	public String getRecoMessage() {
		return recoMessage;
	}


	public void setRecoMessage(String recoMessage) {
		this.recoMessage = recoMessage;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Timestamp getLastRecoEngineSyncTime() {
		return lastRecoEngineSyncTime;
	}


	public void setLastRecoEngineSyncTime(Timestamp lastRecoEngineSyncTime) {
		this.lastRecoEngineSyncTime = lastRecoEngineSyncTime;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", storeName=" + storeName + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", status=" + status + ", primaryBeaconId=" + primaryBeaconId + ", map=" + map + ", recoMessage="
				+ recoMessage + ", userId=" + userId + ", password=" + password + ", lastRecoEngineSyncTime="
				+ lastRecoEngineSyncTime + "]";
	}

	
}
