package com.test.ng.day1;
  
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class TestSeleniumDemo1 {
	
	@Test
	public void optFirefox() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\workspace\\maven_test\\drivers\\geckodriver.exe");
		WebDriver webDriver =new FirefoxDriver();
		webDriver.get("https://www.baidu.com");
		System.out.println("title:"+webDriver.getTitle());
		System.out.println("url:"+webDriver.getCurrentUrl());
		System.out.println("pageSource:"+webDriver.getPageSource());
		System.out.println("windowHandle:"+webDriver.getWindowHandle());
		Thread.sleep(3000);
		webDriver.navigate().to("http://www.youku.com/"); 
		Thread.sleep(3000);
		webDriver.navigate().back();
		org.openqa.selenium.Dimension dimension =new Dimension(200, 200);
		webDriver.manage().window().setSize(dimension);
		Thread.sleep(3000);
		webDriver.manage().window().maximize(); 
		webDriver.navigate().forward();
		Thread.sleep(3000);
		webDriver.navigate().refresh(); 
		webDriver.quit(); 
	}
	
	@Test
	public void openFireFox() throws InterruptedException {
		System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\workspace\\maven_test\\drivers\\geckodriver.exe");
		WebDriver wDriver=new FirefoxDriver();
		wDriver.get("https://www.baidu.com");
		Thread.sleep(5000);
		wDriver.quit();
	}
	
	@Test
    public void openChrom() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "C:\\workspace\\maven_test\\drivers\\chromedriver.exe");
    	WebDriver wDriver=new ChromeDriver(); 
		wDriver.get("https://www.baidu.com/");
		Thread.sleep(5000);
		wDriver.quit();
    }
	@Test
	public void openIE() throws InterruptedException {
		System.setProperty("webdriver.ie.driver", "C:\\workspace\\maven_test\\drivers\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		driver.get("https://www.baidu.com");
		Thread.sleep(5000);
		driver.quit();
	}
	@Test
	public void openEdge() throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\workspace\\maven_test\\drivers\\MicrosoftWebDriver.exe");
		WebDriver driver =new EdgeDriver();
		driver.get("https://www.baidu.com");
		Thread.sleep(5000); 
		driver.quit();
	}
	
}
