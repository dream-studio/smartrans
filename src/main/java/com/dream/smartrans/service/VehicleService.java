package com.dream.smartrans.service;

import java.util.List;

import com.dream.smartrans.vo.VehicleVO;

public interface VehicleService {

	List<VehicleVO> getAllWithGPS();

	boolean isValid(String vid);

	boolean updateLocation(String vid, List<String> gps);
}
