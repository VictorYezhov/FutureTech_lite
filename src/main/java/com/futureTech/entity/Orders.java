package com.futureTech.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Victor on 27.05.2017.
 */

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private LocalDate date;

    private  boolean open;


    // @ManyToMany
    // @JoinTable(name="bank_client", joinColumns=@JoinColumn(name="bank_id"),
    // inverseJoinColumns=@JoinColumn(name="client_id"))

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="Order_Commodity",
    joinColumns = @JoinColumn(name = "Order_id"),
    inverseJoinColumns = @JoinColumn(name="commodity_id"))
    private Set<Commodity> commodityList= new HashSet<>();


    @ElementCollection
	private List<Integer> amountOfCommodity =new ArrayList<>();

    @ManyToOne
    private User user;

    

	public Orders() {
		super();
		open=true;
	}

	

	public Orders(LocalDate date, User user) {
		super();
		this.date = date;
		this.user = user;
	}

	public List<Integer> getAmountOfCommodity() {
		return amountOfCommodity;
	}

	public void setAmountOfCommodity(List<Integer> ammountsOfCommoduty) {
		this.amountOfCommodity = ammountsOfCommoduty;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}



	public Orders(LocalDate date, Set<Commodity> commodityList, User user) {
		super();
		this.date = date;
		this.commodityList = commodityList;
		this.user = user;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public Set<Commodity> getCommoditySet() {
		return commodityList;
	}


	public void setCommoditySet(Set<Commodity> commodityList) {
		this.commodityList = commodityList;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


    
    
    
    
    



}
