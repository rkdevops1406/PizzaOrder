package com.pizza.order.dao.impl;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.pizza.order.dao.OrderDao;
import com.pizza.order.domain.OrderBean;

@RunWith(MockitoJUnitRunner.class)
public class OrderDaoImplTest {

	@InjectMocks
	private OrderDao orderDao = new OrderDaoImpl();
	
	@Before
	public void initMocks(){
	      MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testReadData() {
		 Assert.assertNotNull(orderDao.readData());
	}

	@Test
	public void testWriteData() {
		 Assert.assertSame(true, orderDao.writeData(getData()));
	}
	
	private ArrayList<OrderBean> getData(){
		ArrayList<OrderBean> orderList = new ArrayList<>();
		OrderBean orderBean = new OrderBean();
		orderBean.setOrderName("Test1");
		orderBean.setOrderTime(Long.valueOf(1223432));
		orderList.add(orderBean);
		return orderList;
	}
	
}
