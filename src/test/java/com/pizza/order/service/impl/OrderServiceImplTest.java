package com.pizza.order.service.impl;

import static org.junit.Assert.fail;

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
	public void initMocks(){
	      MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testReadData() {
		Mockito.when(orderDao.readData()).thenReturn(getData());
		Assert.assertTrue (orderService.readData().size()==1);
	}

	@Test
	public void testReadData_withNullData() {
		Mockito.when(orderDao.readData()).thenReturn(null);
		Assert.assertNull (orderService.readData());
	}
	
	@Test
	public void testWriteData() {
		Mockito.when(orderDao.writeData(Matchers.any(ArrayList.class))).thenReturn(true);
		Assert.assertTrue (orderService.writeData(getData()));
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
