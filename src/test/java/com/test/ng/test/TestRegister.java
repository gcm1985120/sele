package com.test.ng.test;

 

import java.nio.file.Watchable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRegister {
   
	public WebDriver webdriver=null;
	
	@BeforeMethod
	public void befor() {
		   System.setProperty("webdriver.gecko.driver", "C:\\workspace\\maven_test\\drivers\\geckodriver.exe");
		   webdriver=new FirefoxDriver(); 
		 //System.setProperty("webdriver.chrome.driver", "C:\\workspace\\maven_test\\drivers\\chromedriver.exe");
		 // webdriver=new ChromeDriver();
	}
	
	@Test
	public void testregist() throws InterruptedException {
		 webdriver.get("https://mail.163.com/"); 
		webdriver.switchTo().frame("x-URS-iframe"); 
		WebElement registButton=webdriver.findElement(By.id("changepage"));
		registButton.click();
		
		String parentHandle=webdriver.getWindowHandle();
		Set<String> handles=webdriver.getWindowHandles();
		for(String handle:handles) {
			if(!handle.equals(parentHandle)) {
				webdriver.switchTo().window(handle);
			}
		}
		Thread.sleep(1000);
		String time=String.valueOf(System.currentTimeMillis()/100);
		WebElement eamil=webdriver.findElement(By.id("nameIpt"));
		eamil.sendKeys("email"+time); 
		WebElement mainPwdIpt=webdriver.findElement(By.id("mainPwdIpt"));
		mainPwdIpt.sendKeys("1qaz2wsx");
		WebElement mainCfmPwdIpt=webdriver.findElement(By.id("mainCfmPwdIpt"));
		mainCfmPwdIpt.sendKeys("1qaz2wsx");
		WebElement mainMobileIpt=webdriver.findElement(By.id("mainMobileIpt"));
		mainMobileIpt.sendKeys(time);
		WebElement vcodeIpt=webdriver.findElement(By.id("vcodeIpt"));
		vcodeIpt.sendKeys("abdcdd");
		WebElement mainAcodeIpt=webdriver.findElement(By.id("mainAcodeIpt"));
		mainAcodeIpt.sendKeys("123433");
		webdriver.findElement(By.id("mainRegA")).click();
		WebDriverWait wait=new WebDriverWait(webdriver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='m_mainAcode']/span")));
		
		WebElement errorTip=webdriver.findElement(By.xpath("//div[@id='m_mainAcode']/span"));
		String tipStr=errorTip.getText();
		Assert.assertEquals(tipStr, "  手机验证码不正确，请重新填写");
	}
	
	@Test
	public void  testLogin() throws InterruptedException {
		 webdriver.get("https://mail.126.com/"); 
		webdriver.switchTo().frame("x-URS-iframe");
		webdriver.findElement(By.name("email")).sendKeys("gcm120");
		webdriver.findElement(By.name("password")).sendKeys("gcm120198512020");
		 
		webdriver.findElement(By.id("dologin")).click();
		
		WebDriverWait wait=new WebDriverWait(webdriver, 30);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='_mail_component_45_45']/a")));
		//webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webdriver.findElement(By.id("_mail_input_0_143_inputId"));
	}
	
	@Test
	public void  testSendEmail() throws InterruptedException {
		 webdriver.get("https://mail.126.com/"); 
		webdriver.switchTo().frame("x-URS-iframe");
		webdriver.findElement(By.name("email")).sendKeys("gcm120");
		webdriver.findElement(By.name("password")).sendKeys("gcm120198512020");
		 
		webdriver.findElement(By.id("dologin")).click();
		
		WebDriverWait wait=new WebDriverWait(webdriver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='_mail_component_45_45']/a")));
		
		webdriver.findElement(By.xpath("//*[@id='_mail_component_45_45']/a")).click();
	}
	
	@AfterMethod
	public void after() throws InterruptedException {
		Thread.sleep(3000);
		webdriver.quit();
	}
}
