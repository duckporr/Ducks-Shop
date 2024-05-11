package com.shop.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@Column(name="OrderId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer OrderId;
	@Column(name="date")
	private Date date;
	@Column(name="status")
	private String status;
	@Column(name="address")
	private String address;
	@Column(name="phone")
	private String phone ;

	
	

}
