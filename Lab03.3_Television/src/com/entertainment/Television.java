//Lab 7.1 Packages
package com.entertainment;

import java.util.*;

//Lab 9.1 Interfaces
public class Television implements Volume {
	private String brand = "NoName"; // brand of television
	private int volume; // current volume

	// Data Validation lab 5.1
	private static final List<String> VALID_BRANDS = Arrays.asList("Sony",
			"Zenith", "Hitachi");

	// Optional lab - Implement Muting
	private int oldVolume; // old volume
	private boolean muted;

	private String tvType = "Base";

	// Static variables for 4.3 Static Members
	private static final int MIN_VOLUME = 0;
	private static final int MAX_VOLUME = 100;

	// Lab 8.1 Composition (Optional)
	private Tuner tuner = new Tuner();

	// Constructors for lab 4.2 Adding Constructors
	public Television(String brand, int volume) {
		setVolume(volume);
		try {
			setBrand(brand);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public Television() {
		setVolume(20);
		try {
			setBrand("RCA");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// End Constructors for 4.2

	// Getters and Setters for Lab 4.1 Encapsulation
	public String getTvType() {
		return tvType;
	}

	public void setTvType(String tvType) {
		this.tvType = tvType;
	}

	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		// Using Static Variables from 4.3 to validate volume
		if (volume < MIN_VOLUME) {
			this.volume = Math.min(MIN_VOLUME, MAX_VOLUME);
		} else if (volume > MAX_VOLUME) {
			this.volume = Math.max(MIN_VOLUME, MAX_VOLUME);
		} else {
			this.volume = volume;
		}
	}

	public String getBrand() {
		return this.brand;
	}

	// Lab 10.1 Exceptions
	public void setBrand(String brand) throws Exception {
		// Data Validation lab 5.1
		if (VALID_BRANDS.contains(brand)) {
			this.brand = brand;
		} else {
			throw new Exception("Brand " + brand + " is invalid!");
		}
	}

	// Lab 8.1 Composition Optional
	public void getCurrentChannel() {
		// delegate to the tuner instance
		this.tuner.getChannel();
	}

	public void gotoChannel(String channelIn) {
		// delegate to the tuner instance
		this.tuner.setChannel(channelIn);
	}

	// End Lab 8.1 Optional

	// End Getters and Setters for 4.1

	// Optional lab - Implement Muting
	public void mute() {
		if (this.muted) {
			this.volume = this.oldVolume;
			this.muted = false;

		} else {
			this.oldVolume = this.volume;
			this.volume = 0;
			this.muted = true;
		}
	}

	@Override
	public boolean isMuted() {
		// TODO Auto-generated method stub
		return this.muted;
	}

	// toString method for lab 4.1 Encapsulation
	public String toString() {
		return String.format("Television: brand=%s, volume=%s, channel=%s",
				this.getBrand(), this.getVolume(), this.tuner.getChannel());
	}
}