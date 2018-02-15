package com.pizza.order.dao;

import java.util.List;

import com.pizza.order.domain.OrderBean;

/**
 * @author pdevaraj
 */
public interface OrderDao {
	/**
	 * @return
	 */
	List<OrderBean> readData(String inputFile) throws Exception;

	/**
	 * @param data
	 * @return
	 */
	boolean writeData(List<OrderBean> data, String outputFile) throws Exception;
}
