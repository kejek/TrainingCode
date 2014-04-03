package com.entertainment;

//Lab 8.2 Inheritance
public class ColorTelevision extends Television {
	private int colorTint;
	private final String tvType = "Color";
	
	//Lab 8.3 Optional (Call Super)
	public ColorTelevision(String brand, int volume) {
		super(brand, volume);
		this.setTvType(tvType);
		this.setColorTint(100);
	}
	public ColorTelevision(String brand, int volume, int  colorTint){
		super(brand, volume);
		this.setTvType(tvType);
		this.setColorTint(colorTint);
	}
	public ColorTelevision(){
		this.setTvType(tvType);
	}
	public int getColorTint() {
		return colorTint;
	}

	public void setColorTint(int colorTint) {
		this.colorTint = colorTint;
	}
	
	//Lab 8.3 Polymorphism
	public String toString() {
		return String.format("%s, color tint =%s", super.toString(),this.colorTint);
	}

}
