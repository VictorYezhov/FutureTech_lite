
package com.futureTech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MobileTelephone  extends Commodity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	

	private boolean $3g;
	
	private boolean wifi;
	
	private double batteryCapacity;

	private int amountOfSimCards;
	private int memory;
	private int RAM;
	private double camera;
	private String OS;
	private double screenDiagonal;

	private  String pathImage;
	
	public MobileTelephone() {
		super();
		setType("Telephone");
	}
	
	
	

	public MobileTelephone(boolean wifi, double batteryCapacity, int amountOfSimCards, int memory, int rAM,
			double camera, String oS) {
		super();
		this.wifi = wifi;
		this.batteryCapacity = batteryCapacity;
		this.amountOfSimCards = amountOfSimCards;
		this.memory = memory;
		RAM = rAM;
		this.camera = camera;
		OS = oS;
	}




	public boolean is$3g() {
		return $3g;
	}


	public void set$3g(boolean $3g) {
		this.$3g = $3g;
	}


	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public boolean isWifi() {
		return wifi;
	}


	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}


	public double getBatteryCapacity() {
		return batteryCapacity;
	}


	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}




	public int getAmountOfSimCards() {
		return amountOfSimCards;
	}




	public void setAmountOfSimCards(int amountOfSimCards) {
		this.amountOfSimCards = amountOfSimCards;
	}




	public int getMemory() {
		return memory;
	}




	public void setMemory(int memory) {
		this.memory = memory;
	}




	public int getRAM() {
		return RAM;
	}




	public void setRAM(int rAM) {
		RAM = rAM;
	}




	public double getCamera() {
		return camera;
	}




	public void setCamera(double camera) {
		this.camera = camera;
	}




	public String getOS() {
		return OS;
	}




	public void setOS(String oS) {
		OS = oS;
	}




	public double getScreenDiagonal() {
		return screenDiagonal;
	}




	public void setScreenDiagonal(double screenDiagonal) {
		this.screenDiagonal = screenDiagonal;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
