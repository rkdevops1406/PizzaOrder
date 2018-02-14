package com.pizza.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.order.dao.OrderDao;
import com.pizza.order.domain.OrderBean;
import com.pizza.order.service.OrderService;
@Service
/**
 * @author pdevaraj
 * OrderServiceImpl class
 */
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;
	/**
	 * Read the data from the file
	 */
	public List<OrderBean> readData(){
		List<OrderBean> orderList = orderDao.readData();
		return orderList;
	}
	/**
	 * Write the content to the file
	 */
	public boolean writeData(List<OrderBean> data){
		return orderDao.writeData(data);
	}
}
