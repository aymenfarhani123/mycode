package com.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DemoTest2 {
	
	Demo2 demo=new Demo2();

	@Test
	public void test() {
		String s="abbc";
		String s1=demo.ajoutCharAForAString(s);
		assertEquals("abbca", s1);
		
	}
	
	
	@Test(timeout=0000)
	public void test2(){
		int[] a={3,4,5,6,7};
		int[] b={3,4,5,6,7};
		boolean res=demo.compareIntArrays(a, b);
		assertEquals(true, res);
	}

}
