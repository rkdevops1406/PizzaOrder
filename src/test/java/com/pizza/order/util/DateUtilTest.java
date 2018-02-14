package com.pizza.order.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class DateUtilTest {

	@Before
	public void initMocks(){
	      MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testConvertEpochToUTC() throws Exception {
		Assert.assertNotNull(DateUtil.convertEpochToUTC(Long.valueOf(1234566)));
	}
	@Test
	public void testConvertEpochToUTC_ForNullValue() throws Exception {
		Assert.assertNull(DateUtil.convertEpochToUTC(null));
	}

}
