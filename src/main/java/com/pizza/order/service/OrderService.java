package com.pizza.order.service;

import java.util.List;

import com.pizza.order.domain.OrderBean;
/**
 * @author pdevaraj
 */
public interface OrderService {
	/**
	 * @return
	 */
	public List<OrderBean> readData();
	/**
	 * @param data
	 * @return
	 */
	public boolean writeData(List<OrderBean> data);
}
