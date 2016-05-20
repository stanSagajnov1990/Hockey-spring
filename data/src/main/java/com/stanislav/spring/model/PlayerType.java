package com.stanislav.spring.model;

public enum PlayerType {
	FIELD("F"), GOALIE("G");
	
	private final String type;
	
	PlayerType(String type){
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
