package com.pizza.order;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pizza.order.constants.OrderConstants;
import com.pizza.order.controller.OrderController;
import com.pizza.order.domain.OrderBean;
import com.pizza.order.service.OrderService;

/**
 * @author pdevaraj Main Class
 */
@SpringBootApplication
public class PizzaOrderApplication {
	@Autowired
	OrderService orderService;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PizzaOrderApplication.class);

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApplicationContext ctx = SpringApplication.run(
					PizzaOrderApplication.class, args);
			OrderController orderController = ctx.getBean(OrderController.class);
			if (args.length == 3) {
				List<OrderBean> data = orderController.readData(args[1]);
				boolean flag = orderController.writeData(data, args[2]);
				if (flag) {
					LOGGER.debug(OrderConstants.FILE_GENERATED);
				}
			} else {
				throw new Exception(OrderConstants.INVALID_PARAMETERS);
			}
		} catch (Exception e) {
			LOGGER.error("Error:" + e.getMessage(), e);
		}
	}
}
