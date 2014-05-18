package com.dream.smartrans.action.api;

import java.util.List;

import com.dream.smartrans.service.VehicleService;

public class VehicleAction extends APIAction {

	private static final long serialVersionUID = -5511762610921296785L;
	
	private String vid;
	private List<String> gps;
	
	private VehicleService vehicleService;
	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	public String gpsUpload(){
		System.out.println(vid);
		vehicleService.updateLocation(vid, gps);
		return JSON;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public List<String> getGps() {
		return gps;
	}

	public void setGps(List<String> gps) {
		this.gps = gps;
	}
}
