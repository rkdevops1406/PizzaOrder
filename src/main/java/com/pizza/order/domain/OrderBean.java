package com.pizza.order.domain;

import java.io.Serializable;

/**
 * @author pdevaraj 
 * OrderBean Class
 */
public class OrderBean implements Serializable, Comparable {

	private static final long serialVersionUID = 1L;

	private String orderName;

	private Long orderTime;

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Long getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Long orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public int compareTo(Object o) {
		OrderBean incomingOrder = (OrderBean) o;
		if (this.orderTime < incomingOrder.getOrderTime()) {
			return -1;
		}
		return 0;
	}
}
