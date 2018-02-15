package com.pizza.order.controller;

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

import com.pizza.order.domain.OrderBean;
import com.pizza.order.service.OrderService;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@InjectMocks
	private OrderController orderController = new OrderController();

	@Mock
	private OrderService orderService;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testReadData() throws Exception {
		Mockito.when(orderService.readData(new String())).thenReturn(getData());
		Assert.assertTrue(orderController.readData(Matchers.anyString()).size() == 1);
	}

	@Test
	public void testReadData_withNullData() throws Exception {
		Mockito.when(orderService.readData(new String())).thenReturn(null);
		Assert.assertNull(orderController.readData(Matchers.anyString()));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testWriteData() throws Exception {
		Mockito.when(
				orderService.writeData(Matchers.any(ArrayList.class),
						Matchers.anyString())).thenReturn(true);
		Assert.assertTrue(orderController.writeData(getData(), getFile()));
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
