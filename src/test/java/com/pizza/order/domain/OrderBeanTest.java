package com.pizza.order.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class OrderBeanTest {

	@Before
	public void initMocks(){
	      MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetOrderName() {
		OrderBean orderBean = getOrderBean();
		Assert.assertTrue(orderBean.getOrderName().equals("test"));
	}

	@Test
	public void testSetOrderName() {
		OrderBean orderBean = getOrderBean();
		orderBean.setOrderName("test");
		Assert.assertTrue(orderBean.getOrderName().equals("test"));
	}

	@Test
	public void testGetOrderTime() {
		OrderBean orderBean = getOrderBean();
		Assert.assertTrue(orderBean.getOrderTime() == 12345);
	}

	@Test
	public void testSetOrderTime() {
		OrderBean orderBean = getOrderBean();
		orderBean.setOrderTime(Long.valueOf(1234));
		Assert.assertFalse(orderBean.getOrderTime() == 12345);
	}

	@Test
	public void testCompareTo() {
		OrderBean orderBean = getOrderBean();
		orderBean.setOrderTime(Long.valueOf(1234));
		Assert.assertSame(0, orderBean.compareTo(orderBean));
	}
	private OrderBean getOrderBean(){
		OrderBean orderBean = new OrderBean();
		orderBean.setOrderName("test");
		orderBean.setOrderTime(Long.valueOf(12345));
		return orderBean;
	}
}
