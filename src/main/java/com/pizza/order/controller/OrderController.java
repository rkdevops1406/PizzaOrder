package com.pizza.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pizza.order.domain.OrderBean;
import com.pizza.order.service.OrderService;
/**
 * @author pdevaraj
 */
@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	/**
	 * @param inputFile
	 * @return
	 * @throws Exception
	 */
	public List<OrderBean> readData(String inputFile) throws Exception {
		List<OrderBean> orderList = orderService.readData(inputFile);
		return orderList;
	}
	/**
	 * @param data
	 * @param outputFile
	 * @return
	 * @throws Exception
	 */
	public boolean writeData(List<OrderBean> data, String outputFile)
			throws Exception {
		return orderService.writeData(data, outputFile);
	}
}
