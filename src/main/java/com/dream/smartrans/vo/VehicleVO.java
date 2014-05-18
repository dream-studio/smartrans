package com.dream.smartrans.vo;

import java.util.Date;

import com.dream.smartrans.dict.CarType;
import com.dream.smartrans.po.Vehicle;
import com.dream.smartrans.po.VehicleLocation;

public class VehicleVO implements ViewObject {

	private String id;
	private String name;
	private CarType type;
	private int carLoad;
	private Date creationTime;
	private Date lastUpdate;
	
	private boolean hasGPS;
	private String gpsId;
	private int lat;
	private int lng;
	private String lngLat;
	private Date gpsLastUpdate;
	
	public void from(Vehicle v){
		if (v != null){
			this.id = v.getId();
			this.name = v.getName();
			this.type = v.getType();
			this.carLoad = v.getCarLoad();
			this.creationTime = v.getCreationTime();
			this.lastUpdate = v.getLastUpdate();
		}
	}
	
	public void from(VehicleLocation loc){
		if (loc != null){
			hasGPS = true;
			this.gpsId = loc.getId();
			this.lat = loc.getLat();
			this.lng = loc.getLng();
			this.lngLat = loc.getLngLat();
			this.gpsLastUpdate = loc.getLastUpdate();
		}
	}
	
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
	public String getLocId() {
		return gpsId;
	}
	public void setLocId(String gpsId) {
		this.gpsId = gpsId;
	}
	public int getLat() {
		return lat;
	}
	public void setLat(int lat) {
		this.lat = lat;
	}
	public int getLng() {
		return lng;
	}
	public void setLng(int lng) {
		this.lng = lng;
	}
	public String getLngLat() {
		return lngLat;
	}
	public void setLngLat(String lngLat) {
		this.lngLat = lngLat;
	}
	public boolean hasGPS() {
		return hasGPS;
	}
	public Date getGpsLastUpdate() {
		return gpsLastUpdate;
	}
	public void setGpsLastUpdate(Date gpsLastUpdate) {
		this.gpsLastUpdate = gpsLastUpdate;
	}
}
