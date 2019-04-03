package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.TestUtil;
import com.qa.util.WebdriverListerner;

public class TestBase {
	
	public static WebDriver driver;
	static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebdriverListerner eventlistener;
	
	public TestBase() {
		// TODO Auto-generated constructor stub
	
		
		
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\Rishabh\\workspace\\FlipkartHybridFramework\\src\\main\\java\\com\\qa\\config\\config.properties");
		
			prop.load(fis);
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	
	
	public static void initialization() {
		// TODO Auto-generated method stub
		
	    String brow=prop.getProperty("browser");
		
	    if (brow.equals("chrome"))
	    {
	    	
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rishabh\\workspace\\FlipkartHybridFramework\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();				
		
	   }
	    
	    else if (brow.equals("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rishabh\\workspace\\FlipkartHybridFramework\\Drivers\\geckodriver");
			driver=new FirefoxDriver();					
			
	    }
	    
	    
	    
		e_driver=new EventFiringWebDriver(driver);
		eventlistener=new WebdriverListerner();
		e_driver.register(eventlistener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
        
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitlywaittimeout,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

	
	
	
	
	
	
}
