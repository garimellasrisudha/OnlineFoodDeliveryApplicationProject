package com.cg.onlinefooddelivery.app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FoodCart {

	/**
	 * id of Food Cart
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	//One to one relationship
	@OneToOne(fetch=FetchType.EAGER)
	@JsonIgnore
	private OrderDetail orderDetail;
	//One to many relationship
	
	//@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	//@JoinColumn(name="item_idd")
	//@JsonIgnore
	//@JsonIgnore
	//@OneToMany(mappedBy = "cart",
		   // cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "cart",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Item> itemList;

    @Column(unique=true,updatable=false)
    private String orderNo;
	public FoodCart() {
		super();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}


	public List<Item> getItemList() {
		return itemList;
	}


	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}


	public String getOrderNo() {
		return orderNo;
	}


  public void setOrderNo(String orderNo) {
	this.orderNo = orderNo;
   }
	
	
}
