package com.string;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemoTest {
	
	Demo demo=new Demo();
	
	  
    @BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }  
    @Before  
    public void setUp() throws Exception {  
        System.out.println("before");  
    } 
    
    
	@Test
	public void testString() {
		String a="AA";
		String b="BB";
		boolean res=demo.equalsString(a, b);
		assertNotEquals(true, res);
	}
	
	@Test
	public void testInteger() {
		int a=20;
		int b=21;
		boolean res=demo.equlasInteger(a, b);
		assertNotEquals(true, res);
	}
	
	@Test
	public void testBoolean() {
		boolean a=false;
		boolean b=false;
		boolean res=demo.equlasBoolean(a, b);
		assertNotEquals(false, res);
	}
	
	
	@Test
	public void testMaxInt(){
		int[] tab={10,16,8,45,37};
		int max=demo.maxInt(tab);
		assertEquals(45, max);
	}
    @After
    public void tearDown() throws Exception {  
        System.out.println("after");  
    }  
  
    @AfterClass  
    public static void tearDownAfterClass() throws Exception {  
        System.out.println("after class");  
    }  
	

}
