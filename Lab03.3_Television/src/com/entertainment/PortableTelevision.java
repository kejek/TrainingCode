package com.entertainment;

//Lab 8.2 Inheritance
public class PortableTelevision extends Television {
	private int rechargeLevel;
	private final String tvType = "Portable";

	//Lab 8.3 Optional (Call Super)
	public PortableTelevision(String brand, int volume){
		super(brand,volume);
		this.setTvType(tvType);
		this.setRechargeLevel(50);
	}
	public PortableTelevision(String brand, int volume, int rechargeLevel){
		super(brand,volume);
		this.setTvType(tvType);
		this.setRechargeLevel(rechargeLevel);
	}
	public PortableTelevision(){
		this.setTvType(tvType);
	}
	public int getRechargeLevel() {
		return rechargeLevel;
	}

	public void setRechargeLevel(int rechargeLevel) {
		this.rechargeLevel = rechargeLevel;
	}
	
	//Lab 8.3 Polymorphism
	public String toString() {
		return String.format("%s, recharge level =%s", super.toString(),this.rechargeLevel);
	}
}
