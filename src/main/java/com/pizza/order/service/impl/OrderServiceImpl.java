package com.pizza.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.order.dao.OrderDao;
import com.pizza.order.domain.OrderBean;
import com.pizza.order.service.OrderService;
/**
 * @author pdevaraj 
 * OrderServiceImpl class
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;
	/**
	 * readData method
	 */
	@Override
	public List<OrderBean> readData(String inputFile) throws Exception {
		List<OrderBean> orderList = orderDao.readData(inputFile);
		return orderList;
	}
	/**
	 * writeData method
	 */
	@Override
	public boolean writeData(List<OrderBean> data, String outputFile)
			throws Exception {
		return orderDao.writeData(data, outputFile);
	}
}
