package com.futureTech.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 27.05.2017.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class Commodity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
   
	@ManyToMany
    @JoinTable(name="Order_Commodity",
    joinColumns = @JoinColumn(name = "Order_id"),
    inverseJoinColumns = @JoinColumn(name="commodity_id"))
    private List<Orders> ordersList = new ArrayList<>();

    

    @ManyToOne
    private Brand brand;

    private double price;
    private String name;
    private  String type;
	private  String pathImage;
    
	public Commodity() {
		super();
	}



	public Commodity(Brand brand, double price, String name) {
		super();
		this.brand = brand;
		this.price = price;
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Orders> getOrdersList() {
		return ordersList;
	}



	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}



	public Brand getBrand() {
		return brand;
	}



	public void setBrand(Brand brand) {
		this.brand = brand;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
    
	
    
    


}
