package com.test.ng.day1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActions {
public WebDriver webdriver=null;
	
	@BeforeClass
	public void beforeClass() {
		   System.setProperty("webdriver.gecko.driver", "C:\\workspace\\maven_test\\drivers\\geckodriver.exe");
		  webdriver=new FirefoxDriver();
		 //System.setProperty("webdriver.chrome.driver", "C:\\workspace\\maven_test\\drivers\\chromedriver.exe");
		  //webdriver=new ChromeDriver();
		 //webdriver.get("http://www.baidu.com"); 
		// webdriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@Test
	public void testMouseRightclick() {
		 webdriver.get("http://www.baidu.com"); 
		WebElement webElement=webdriver.findElement(By.id("su"));
		Actions actions =new Actions(webdriver);
		//右击
		actions.contextClick(webElement).perform();
		
	}
	
	@Test
	public void testDoubleClick() {
		 webdriver.get("http://www.baidu.com"); 
		WebElement webElement=webdriver.findElement(By.id("su"));
		webdriver.findElement(By.id("kw")).sendKeys("selenium");
		Actions actions =new Actions(webdriver);
		//右击
		actions.doubleClick(webElement).perform();
		
		
	}
	@Test
	public void testMouseMove() throws InterruptedException {
		 webdriver.get("file:///C:/test/selenium_html/index.html");
         WebElement webElement= webdriver.findElement(By.xpath("//div[@id='action']/input[1]"));
		 
		 Actions actions=new Actions(webdriver); 
		 actions.moveToElement(webElement).perform();
		 Thread.sleep(2000);
		 String rs=webdriver.findElement(By.xpath("//div[@id='over']/div")).getText();
		 Assert.assertEquals(rs, "Hello World!"); 
		/* webdriver.get("file:///C:/test/selenium_html/demo1.html"); 
		 WebElement webElement= webdriver.findElement(By.xpath("//div[@id='alert']/input[1]"));
		 Actions actions=new Actions(webdriver); 
		 actions.moveToElement(webElement).perform();*/
	}
	@Test
	public void testDrag() throws InterruptedException{
		 webdriver.get("file:///C:/test/selenium_html/dragAndDrop.html");
         WebElement webElement= webdriver.findElement(By.id("drag"));
         WebElement webElement1= webdriver.findElement(By.xpath("/html/body/h1"));
         Thread.sleep(2000);
         Actions actions=new Actions(webdriver); 
         //actions.dragAndDropBy(webElement, 300,300).perform();
         actions.clickAndHold(webElement).moveToElement(webElement1).release().perform();
		}
	@Test
	public void testMuiltSelect() throws InterruptedException {
		  webdriver.get("file:///C:/test/selenium_html/index.html");
          WebElement webElement= webdriver.findElement(By.id("selectWithMultipleEqualsMultiple"));
          List<WebElement> options=webElement.findElements(By.tagName("option"));
          Actions actions=new Actions(webdriver);
         // actions.keyDown(Keys.SHIFT).click(options.get(1)).click(options.get(2)).keyUp(Keys.SHIFT).perform();
		 actions.keyDown(Keys.CONTROL).click(options.get(2)).keyUp(Keys.CONTROL).perform();
	 }
	@Test
	public void testRobot() throws InterruptedException, AWTException {
		 webdriver.get("file:///C:/test/selenium_html/index.html");
		 Robot robot =new Robot();
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 int keyS=(int)new Character('A');
		 robot.keyPress(keyS);
		 Thread.sleep(2000);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
	}
	@Test
	public void testUploadFile() throws InterruptedException, AWTException {
		 webdriver.get("file:///C:/test/selenium_html/index.html");
		 WebElement webElement= webdriver.findElement(By.id("load"));
		 webElement.sendKeys("C:\\workspace\\img\\img1.png");
	} 
	
	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(5000);
		 webdriver.quit();
	}

}
