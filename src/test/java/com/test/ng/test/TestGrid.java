package com.test.ng.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestGrid {
	
	@Test(dataProvider="datas")
	public void testGrid(String broswer,String url) throws MalformedURLException, InterruptedException {
		DesiredCapabilities desiredCapabilities=null;
		if("firefox".equals(broswer)) {
			  desiredCapabilities=new DesiredCapabilities().firefox();
		 }else {
			 desiredCapabilities=new DesiredCapabilities().chrome(); 
		 }
		
		WebDriver webDriver=new RemoteWebDriver(new URL(url+"/wd/hub"), desiredCapabilities);
		webDriver.get("http://www.baidu.com");
		
		//WebDriverWait wait=new WebDriverWait(webDriver, 10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		//webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		webDriver.quit();
		
	}
	@DataProvider(name="datas")
	public String[][] data(){
		return new String[][] {
			{"firefox"," http://192.168.45.1:4000"},
			{"chrome","http://192.168.45.1:5555"}
		};
	}

}
