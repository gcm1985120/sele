package com.test.ng.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestJavaScript {
	public WebDriver webdriver=null; 
	
	@Test
	public void testJsavScript() {
		  System.setProperty("webdriver.gecko.driver", "C:\\workspace\\maven_test\\drivers\\geckodriver.exe");
		  webdriver=new FirefoxDriver(); 
		 webdriver.get("http://www.baidu.com"); 
		 WebElement webElemen=webdriver.findElement(By.id("kw"));
		 JavascriptExecutor jsExecutor=(JavascriptExecutor)webdriver ;
		 jsExecutor.executeScript("var kw=document.getElementById('kw');"
		 		+ "kw.setAttribute('value','selenium');");
		 
	}
	@Test
	public void testPhantomJS() {
		 System.setProperty("phantomjs.binary.path", "C:\\workspace\\maven_test\\drivers\\phantomjs.exe");
		  webdriver=new PhantomJSDriver();
		 webdriver.get("http://www.baidu.com");
		 webdriver.findElement(By.id("kw")).sendKeys("PhantomJS");
		 System.out.println(webdriver.getTitle());
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(5000);
		 webdriver.quit();
	}
}
