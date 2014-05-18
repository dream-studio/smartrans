package com.dream.smartrans.dao;

import java.util.List;

import com.dream.smartrans.po.VehicleLocation;

public interface VehicleLocationDao {

	List<VehicleLocation> findAll();

	VehicleLocation findByVehicleId(String vehicleId);

	boolean update(VehicleLocation vl);

	String insert(VehicleLocation vl);
}
