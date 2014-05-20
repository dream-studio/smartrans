package com.dream.smartrans.dict;

public enum UserStatus {
	DEACTIVATED(0), 
	ACTIVATED(1);

	private int value;
	public int getValue(){
		return value;
	}

	UserStatus(int value) {
		this.value = value;
	}

	public static UserStatus valueOf(int value) {
		switch (value) {
		case 1:
			return ACTIVATED;
		default:
			return DEACTIVATED;
		}
	}
	
	public boolean equals(int value){
		return this.value == value; 
	}
}
