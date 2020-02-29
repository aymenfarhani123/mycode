package com.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.string.StringHelper;

public class StringHelperTest {

	@Test
	public void test() {
		StringHelper helper=new StringHelper();
		String actual=helper.truncateAInFirst2Positions("AACD");
		String expacted="CD";
		assertEquals(expacted, actual);
	}

}
