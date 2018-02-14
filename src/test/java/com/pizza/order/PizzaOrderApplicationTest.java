package com.pizza.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class PizzaOrderApplicationTest {
	@Before
	public void initMocks(){
	      MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testMain() {
		String [] arg = new String[]{};
		PizzaOrderApplication.main(arg);
		Assert.assertTrue(true);
	}

}
