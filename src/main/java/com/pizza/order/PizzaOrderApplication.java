package com.pizza.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pizza.order.domain.OrderBean;
import com.pizza.order.service.OrderService;

@SpringBootApplication

public class PizzaOrderApplication {
	@Autowired
	OrderService orderService;
	public static void main(String[] args) {
		 ApplicationContext ctx =SpringApplication.run(PizzaOrderApplication.class, args);
		 OrderService orderService = ctx.getBean(OrderService.class);
		 List<OrderBean> data = orderService.readData();
		 boolean flag = orderService.writeData(data);
	}
}
