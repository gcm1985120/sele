package com.test.ng.day1; 
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSeleniumDemo2 {
	
	public WebDriver webdriver=null;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "C:\\workspace\\maven_test\\drivers\\geckodriver.exe");
		webdriver=new FirefoxDriver();
	}

	@Test
	public void  testFindElements() throws InterruptedException {
		webdriver.get("https://www.baidu.com");
		//WebElement webElement=webdriver.findElement(By.id("kw"));
		//WebElement webElement =webdriver.findElement(By.name("wd"));
		//WebElement webElement =webdriver.findElement(By.className("s_ipt"));
		//WebElement webElement =webdriver.findElement(By.cssSelector("#kw"));  
		//WebElement webElement =webdriver.findElement(By.cssSelector("[id=kw]"));  
		 WebElement webElement =webdriver.findElement(By.xpath("//input[@id='kw']"));  
		   webElement.sendKeys("seleniumabc");
		   String stext=webElement.getAttribute("value");
		   
		   Thread.sleep(1000);
		   webElement.clear();
		   String stext1=webElement.getAttribute("value");
		   Thread.sleep(1000);
		   //Assert.assertEquals(stext, "seleniumabc","输入内容错误");
		  // Assert.assertEquals(stext1,"","清空失败");
		   webElement.sendKeys("selenium");
		   
		   Thread.sleep(1000);
		//WebElement webElement1=webdriver.findElement(By.id("su")); 
		//WebElement webElement1 =webdriver.findElement(By.linkText("新闻"));
		//WebElement webElement1 =webdriver.findElement(By.partialLinkText("新"));
		 //WebElement webElement1 =webdriver.findElement(By.cssSelector("#su"));
		// WebElement webElement1 =webdriver.findElement(By.cssSelector("[id=su]"));
		   WebElement webElement1 =webdriver.findElement(By.xpath("//input[@id='su']"));
		   Boolean bdBoolean=webElement1.isDisplayed();
		   System.out.println(bdBoolean);
		   Assert.assertTrue(bdBoolean,"不显示");
		   webElement1.click();
		/* List<WebElement> ls=webdriver.findElements(By.tagName("input"));
		 for(WebElement element :ls) {
			 System.out.println(element.getAttribute("name")+" "+element.getAttribute("type"));
		 }
		 List<WebElement> ls =webdriver.findElements(By.xpath("//a[@class='mnav'][1]")); 
		 for(WebElement element :ls) {
			 element.click();
			 System.out.println(element.getText());
		 }
		 System.out.println("元素个数："+ls.size());*/
		Thread.sleep(2000);
		//String title=webdriver.getTitle();
		//Assert.assertEquals(title, "selenium_百度搜索","搜索失败");
		
	}
	@Test
    private void testExporlor() throws InterruptedException {
		 webdriver.get("file:///C:/test/selenium_html/index.html");
		//WebElement webElement=webdriver.findElement(By.xpath("//div[@id='radio']/input[@name='identity'][1]"));
		//webElement.click();
		//Boolean boolean1=webElement.isSelected();
		WebElement dElement=webdriver.findElement(By.xpath("//div[@id='button']/input[1]"));
		System.out.println(dElement.getAttribute("value"));
		Boolean boolean2 =dElement.isEnabled(); 
		Thread.sleep(3000);
		Assert.assertFalse(boolean2);
		//Assert.assertTrue(boolean1);
	}
	
	@Test
	public void shotImg() {
		 webdriver.get("http://news.baidu.com/");
		 TakesScreenshot takesScreenshot=(TakesScreenshot)webdriver;
		 File file=takesScreenshot.getScreenshotAs(OutputType.FILE); 
		 try {
			org.apache.commons.io.FileUtils.copyFile(file, new File("C:\\workspace\\img\\img1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void afterClass() {
		webdriver.quit();
	}
}
