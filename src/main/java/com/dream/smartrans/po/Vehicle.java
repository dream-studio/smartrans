package com.dream.smartrans.po;

import java.util.Date;

import com.dream.smartrans.dict.CarType;

public class Vehicle {
	private String id;
	private String name;
	private CarType type;
	private int carLoad;
	private Date creationTime;
	private Date lastUpdate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CarType getType() {
		return type;
	}
	public void setType(CarType type) {
		this.type = type;
	}
	public int getCarLoad() {
		return carLoad;
	}
	public void setCarLoad(int carLoad) {
		this.carLoad = carLoad;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
