package com.online.shopping.cart.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_cart")
public class OrderCart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="orderCart",cascade = CascadeType.ALL)
	private List<CartProduct> products;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="order_number")
	private String orderNumber;
	
	@Column(name="customer_id")
	private int customerId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public List<CartProduct> getProducts() {
		return products;
	}
	public void setProducts(List<CartProduct> products) {
		this.products = products;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "OrderCart [id=" + id + ", products=" + products + ", orderDate=" + orderDate + ", orderNumber="
				+ orderNumber + ", customerId=" + customerId + "]";
	}    	
}