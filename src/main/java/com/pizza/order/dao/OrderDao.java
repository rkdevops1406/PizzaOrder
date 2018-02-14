package com.pizza.order.dao;



import java.util.List;

import com.pizza.order.domain.OrderBean;
/**
 *  @author pdevaraj
 */
public interface OrderDao {
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
