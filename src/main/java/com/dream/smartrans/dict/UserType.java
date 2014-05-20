package com.dream.smartrans.dict;

public enum UserType {
	UNKNOWN(0), 
	CUSTOMER(1), 
	DRIVER(2);

	private int value;
	public int getValue(){
		return value;
	}

	UserType(int value) {
		this.value = value;
	}

	public static UserType valueOf(int value) {
		switch (value) {
		case 1:
			return CUSTOMER;
		case 2:
			return DRIVER;
		default:
			return UNKNOWN;
		}
	}
	
	public boolean equals(int value){
		return this.value == value; 
	}
}
