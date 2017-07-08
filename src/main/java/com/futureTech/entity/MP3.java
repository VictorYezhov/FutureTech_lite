package com.futureTech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MP3 extends Commodity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	
	private int memory;
	private double batteryCapacity;
	
	
	public MP3() {
		super();
		setType("MP3");
	}


	public MP3(int memory, double batteryCapacity) {
		super();
		this.memory = memory;
		this.batteryCapacity = batteryCapacity;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMemory() {
		return memory;
	}


	public void setMemory(int memory) {
		this.memory = memory;
	}


	public double getBatteryCapacity() {
		return batteryCapacity;
	}


	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	
	
	
	
	
	
	
	
}
