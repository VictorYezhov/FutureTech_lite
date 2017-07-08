package com.futureTech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tablet extends Commodity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	
	
    private boolean wifi;
	private double batteryCapacity;
	private int amountOfSimCards;
	private int memory;
	private int RAM;
	private double camera;
	private String OS;
	private double screenDiagonal;
	
	public Tablet() {
		super();
		setType("Tablet");
	}

	public Tablet(boolean wifi, double batteryCapacity, int amountOfSimCards, int memory, int rAM, double camera,
			String oS, double screenDiagonal) {
		super();
		this.wifi = wifi;
		this.batteryCapacity = batteryCapacity;
		this.amountOfSimCards = amountOfSimCards;
		this.memory = memory;
		RAM = rAM;
		this.camera = camera;
		OS = oS;
		this.screenDiagonal = screenDiagonal;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
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
	
	
	
	
}
