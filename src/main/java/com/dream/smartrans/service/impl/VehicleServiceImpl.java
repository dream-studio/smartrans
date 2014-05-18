package com.dream.smartrans.service.impl;

import java.util.ArrayList;
import java.util.List;

import static com.dream.smartrans.config.Config.GPS_APPROXIMATION;
import com.dream.smartrans.dao.VehicleDao;
import com.dream.smartrans.dao.VehicleLocationDao;
import com.dream.smartrans.po.Vehicle;
import com.dream.smartrans.po.VehicleLocation;
import com.dream.smartrans.service.VehicleService;
import com.dream.smartrans.vo.VehicleVO;

public class VehicleServiceImpl implements VehicleService {

	private VehicleDao vehicleDao;
	private VehicleLocationDao vehicleLocationDao;

	public void setVehicleLocationDao(VehicleLocationDao vehicleLocationDao) {
		this.vehicleLocationDao = vehicleLocationDao;
	}
	
	public void setVehicleDao(VehicleDao vehicleDao){
		this.vehicleDao = vehicleDao;
	}
	
	public List<VehicleVO> getAllWithGPS(){
		List<VehicleVO> voList = new ArrayList<VehicleVO>();
		
		List<Vehicle> vList = vehicleDao.findAll();
		
		for (Vehicle v: vList){
			VehicleVO vo = new VehicleVO();
			vo.from(v);
			vo.from(vehicleLocationDao.findByVehicleId(v.getId()));
			voList.add(vo);
		}
		return voList;
	}
	
	public boolean isValid(String vid){
		return true;
	}
	
	public boolean updateLocation(String vid, List<String> gps){
		if (isValid(vid) && gps != null && !gps.isEmpty()){
			String lastGps = gps.get(gps.size() - 1);
			String[] splitted = lastGps.split(",");
			int lng = Integer.parseInt(splitted[0]) * GPS_APPROXIMATION;
			int lat = Integer.parseInt(splitted[1]) * GPS_APPROXIMATION;
			
			VehicleLocation loc = vehicleLocationDao.findByVehicleId(vid);
			if (loc == null){
				loc = new VehicleLocation();
				loc.setVehicleId(vid);
				loc.setLng(lng);
				loc.setLat(lat);
				return vehicleLocationDao.insert(loc) != null;
			}else{
				loc.setLng(lng);
				loc.setLat(lat);
				return vehicleLocationDao.update(loc);
			}
		}
		
		return false;
	}
}
