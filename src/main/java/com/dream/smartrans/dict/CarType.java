package com.dream.smartrans.dict;

public enum CarType {
	UNKNOWN(0), 
	TRUCK(1), 
	PLATFORM(2), 
	CARRIER(3), 				// 集装箱
	TOWING(4), 					// 牵引式
	VAN(5), 
	REFRIGERATED(6); 			// 冷藏

	private int value;
	public int getValue(){
		return value;
	}

	CarType(int value) {
		this.value = value;
	}

	public static CarType valueOf(int value) {
		switch (value) {
		case 1:
			return TRUCK;
		case 2:
			return PLATFORM;
		case 3:
			return CARRIER;
		case 4:
			return TOWING;
		case 5:
			return VAN;
		case 6:
			return REFRIGERATED;
		default:
			return UNKNOWN;
		}
	}
	
	public boolean equals(int value){
		return this.value == value; 
	}
}
