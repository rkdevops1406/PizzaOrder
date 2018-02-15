package com.pizza.order.service.impl;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.pizza.order.dao.OrderDao;
import com.pizza.order.domain.OrderBean;
import com.pizza.order.service.OrderService;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

	@InjectMocks
	private OrderService orderService = new OrderServiceImpl();

	@Mock
	private OrderDao orderDao;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testReadData() throws Exception {
		Mockito.when(orderDao.readData(new String())).thenReturn(getData());
		Assert.assertTrue(orderService.readData(Matchers.anyString()).size() == 1);
	}

	@Test
	public void testReadData_withNullData() throws Exception {
		Mockito.when(orderDao.readData(new String())).thenReturn(null);
		Assert.assertNull(orderService.readData(Matchers.anyString()));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testWriteData() throws Exception {
		Mockito.when(
				orderDao.writeData(Matchers.any(ArrayList.class),
						Matchers.anyString())).thenReturn(true);
		Assert.assertTrue(orderService.writeData(getData(), getFile()));
	}

	private ArrayList<OrderBean> getData() {
		ArrayList<OrderBean> orderList = new ArrayList<>();
		OrderBean orderBean = new OrderBean();
		orderBean.setOrderName("Test1");
		orderBean.setOrderTime(Long.valueOf(1223432));
		orderList.add(orderBean);
		return orderList;
	}

	private String getFile() {
		return "test.txt";
	}
}
