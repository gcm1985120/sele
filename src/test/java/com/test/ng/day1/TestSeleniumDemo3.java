package com.test.ng.day1; 
import java.io.File;
import java.io.IOException;
import java.nio.file.Watchable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.swingui.TestSelector;

public class TestSeleniumDemo3 {
	
	public WebDriver webdriver=null;
	
	@BeforeClass
	public void beforeClass() {
		  System.setProperty("webdriver.gecko.driver", "C:\\workspace\\maven_test\\drivers\\geckodriver.exe");
		  webdriver=new FirefoxDriver();
		 //System.setProperty("webdriver.chrome.driver", "C:\\workspace\\maven_test\\drivers\\chromedriver.exe");
		 // webdriver=new ChromeDriver();
		 webdriver.get("file:///C:/test/selenium_html/index.html"); 
		// webdriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 /*System.setProperty("phantomjs.binary.path", "C:\\workspace\\maven_test\\drivers\\phantomjs.exe");
		  webdriver=new PhantomJSDriver();
		  webdriver.get("file:///C:/test/selenium_html/index.html"); */
	 }
	
	@Test
	public void testAlert() throws InterruptedException { 
		WebElement eb=webdriver.findElement(By.className("alert"));
		eb.click();
		Alert at=webdriver.switchTo().alert();
		String str=at.getText(); 
		Thread.sleep(1000); 
		at.accept();
		Assert.assertEquals(str, "请点击确定");
	}
    
	@Test
	public void testConfirm() throws InterruptedException { 
		WebElement eb=webdriver.findElement(By.className("confirm"));
		eb.click();
		Thread.sleep(1000);
		Alert at=webdriver.switchTo().alert(); 
		at.dismiss();
		Thread.sleep(1000);
		System.out.println(at.getText());
		at.accept();
		 
	}
	
	
	@Test
	public void testPrompt() throws InterruptedException { 
		WebElement eb=webdriver.findElement(By.className("prompt"));
		eb.click();
		Thread.sleep(1000);
		Alert at=webdriver.switchTo().alert(); 
		at.sendKeys("abcdefg");
		Thread.sleep(1000);
		at.dismiss();
		Thread.sleep(1000);
		System.out.println(at.getText());
		at.accept();
		 
	}
	@Test
	public void testFrame() throws InterruptedException {
		//转交控制权
		webdriver.switchTo().frame("aa");
		//通过查找ifram元素，转交控制权
		//WebElement ifrme=webdriver.findElement(By.tagName("iframe"));
		//webdriver.switchTo().frame(ifrme);
		WebElement user=webdriver.findElement(By.id("user"));
		user.sendKeys("sdfsdfsdfsd");
		WebElement lin=webdriver.findElement(By.xpath("//div[@id='link']/a"));
		System.out.println(lin.getText());
		lin.click(); 
		webdriver.findElement(By.className("alert")).click();
		//控制权交给原来的界面
		//webdriver.switchTo().defaultContent();
		//webdriver.findElement(By.linkText("登陆界面")).click();
	}
	@Test
	public void testSelect() throws InterruptedException {
		WebElement sElement=webdriver.findElement(By.id("moreSelect"));
		Select select=new Select(sElement);
		select.selectByIndex(1);
		Thread.sleep(2000);
		select.selectByValue("huawei");
		Thread.sleep(2000);
		select.selectByVisibleText("iphone"); 
		Thread.sleep(2000);
		WebElement fElement=select.getFirstSelectedOption();
		System.out.println(fElement.getText());
		List<WebElement> list=select.getAllSelectedOptions(); 
	}
	@Test
	public void testMoreWindows() throws InterruptedException {
	  String nameOrHandle= webdriver.getWindowHandle();
	  System.out.println("parent: "+nameOrHandle);
	  WebElement element=webdriver.findElement(By.xpath("//div[@id='open']/a"));
	  element.click(); 
	  Set<String> handles=webdriver.getWindowHandles();
	  for(String hand:handles) {
		  System.out.println("------"+hand); 
		  if(!hand.equals(nameOrHandle)) {
			  System.out.println("==="+hand); 
			  webdriver.switchTo().window(hand);
		  }
	  }
	   Thread.sleep(3000);
	   WebElement webElement =webdriver.findElement(By.id("kw"));  
	   webElement.sendKeys("selenium");
	   webdriver.findElement(By.id("su")).click(); 
		
	}
	@Test
	public void testWait() throws InterruptedException{
		WebElement webElement=webdriver.findElement(By.xpath("//div[@id='wait']/input"));
		webElement.click();
		//Thread.sleep(5000); 
		WebDriverWait wait= new WebDriverWait(webdriver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='display']/div")));
		WebElement webElet=webdriver.findElement(By.xpath("//div[@id='display']/div"));
		Boolean bdBoolean=webElet.isDisplayed();
		Assert.assertTrue(bdBoolean);
	}
	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		 webdriver.quit();
	}
}
