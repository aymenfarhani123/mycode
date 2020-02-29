package com.string;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DemoTest.class, DemoTest2.class })
public class AllTests {
	
	@BeforeClass
	public static void setup(){
		System.out.println("Before all classes");
	}

}
