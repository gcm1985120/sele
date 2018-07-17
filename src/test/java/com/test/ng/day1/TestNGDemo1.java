package com.test.ng.day1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo1 {
	@BeforeClass
	public void beforeClass() {
		System.out.println("this is beforeClass");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("this is beforeTest");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("this is beforeMethod");
	}
	
	@Test
	public void testCase() {
		System.out.println("this is test case one");
	}
	
	 @Test
	public void testCase2() {
		System.out.println("this is test case two");
	}
	 
	@AfterMethod
	public void afterMethod() {
		System.out.println("this is afterMethod");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("this is afterTest");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("this is afterClass");
	}

}
