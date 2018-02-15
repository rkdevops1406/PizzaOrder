package com.pizza.order.dao.impl;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.pizza.order.dao.OrderDao;
import com.pizza.order.domain.OrderBean;

@RunWith(MockitoJUnitRunner.class)
public class OrderDaoImplTest {

	@InjectMocks
	private OrderDao orderDao = new OrderDaoImpl();

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testReadData() throws Exception {
		Assert.assertNotNull(orderDao.readData(getInputFile()));
	}

	@Test
	public void testWriteData() throws Exception {
		Assert.assertSame(true, orderDao.writeData(getData(), getOutputFile()));
	}

	private ArrayList<OrderBean> getData() {
		ArrayList<OrderBean> orderList = new ArrayList<>();
		OrderBean orderBean = new OrderBean();
		orderBean.setOrderName("Test1");
		orderBean.setOrderTime(Long.valueOf(1223432));
		orderList.add(orderBean);
		return orderList;
	}

	private String getInputFile() {
		return "testIn.txt";
	}

	private String getOutputFile() {
		return "testOut.txt";
	}
}
