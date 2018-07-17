package com.test.ng.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {
	
	@Test
   public void testCase() {
	   Assert.assertEquals("1aaa", "2sdf","两个值不相等");
	   System.out.println("---------error------");
   }
}
