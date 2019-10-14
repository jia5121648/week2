package com.jiapengxuan.senior2.week2.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private BigDecimal price;
	
	private String baifen;

	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public String getBaifen() {
		return baifen;
	}



	public void setBaifen(String baifen) {
		this.baifen = baifen;
	}



	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", baifen=" + baifen + "]";
	}
	
	
}
