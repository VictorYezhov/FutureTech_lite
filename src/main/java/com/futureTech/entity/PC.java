package com.futureTech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PC extends Commodity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	
	private String videoAdapterType;
	private String processor;
	private String motherboard;
    private String OS;//Operational system
    private int RAM;
    private double weight;
    private int memory;
    
    
	public PC() {
		super();
		setType("PC");
	}


	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public PC(String videoAdapterType, String processor, String motherboard, String oS, int rAM, double weight,
			  int memory) {
		super();
		this.videoAdapterType = videoAdapterType;
		this.processor = processor;
		this.motherboard = motherboard;
		OS = oS;
		RAM = rAM;
		this.weight = weight;
		this.memory = memory;
	}


	public String getVideoAdapterType() {
		return videoAdapterType;
	}


	public void setVideoAdapterType(String videoAdapterType) {
		this.videoAdapterType = videoAdapterType;
	}


	public String getProcessor() {
		return processor;
	}


	public void setProcessor(String processor) {
		this.processor = processor;
	}


	public String getMotherboard() {
		return motherboard;
	}


	public void setMotherboard(String motherboard) {
		this.motherboard = motherboard;
	}


	public String getOS() {
		return OS;
	}


	public void setOS(String oS) {
		OS = oS;
	}


	public int getRAM() {
		return RAM;
	}


	public void setRAM(int rAM) {
		RAM = rAM;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public int getMemory() {
		return memory;
	}


	public void setMemory(int memory) {
		this.memory = memory;
	}
    
    
    
	
	
	
}
