package com.qa.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.testbase.TestBase;

public class HomePageTest extends TestBase{
	
	HomePage Homepage;
	
	public HomePageTest() {
		// TODO Auto-generated constructor stub
	
	super();
	}
	
	
	
	@BeforeMethod
	public void setup()
	{   
		
		initialization();
		Homepage=new HomePage(); 
	}
	
	
	@Test
	public void VerifyHomepagetest()
	
	{
		String title=Homepage.verifyHomepge();
	    Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");	
	}
	
	
	@Test
	public void VerifyHomePageLogtest() {
		// TODO Auto-generated method stub

		boolean flag;
		flag=Homepage.verifyflipkartlogo();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void teardown() 
	{
	 
	driver.quit();
	}
    
	
}
