package com.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testbase.TestBase;
import com.qa.util.TestUtil;

public class LoginTest extends TestBase {
	
	
LoginPage LoginPage;
HomePage HomePage;

String xlssheetpath;
String sheetname="datapro";
	
	public LoginTest() {
		// TODO Auto-generated constructor stub
	
	super();
	}
	
	
	
	@BeforeMethod
	public void setup()
	{   
		
		initialization();
		LoginPage=new LoginPage(); 
	}
	
	@DataProvider
	public Object[][] getcelldata() throws IOException
	{
		Object[][] data;
		
			data = TestUtil.getdatafromexcel(sheetname);
	
		return data;
		
	}
	
	
	@Test(priority=1)
	public void VerifyLoginpagetest()
	
	{
		
	   boolean flag=LoginPage.verifyloginpage();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=2,dataProvider="getcelldata")
	public void LoginStepsTest(String username, String password) {
		// TODO Auto-generated method stub

		HomePage=LoginPage.loginSteps(username, password);
		
	
	}
	
	@AfterMethod
	public void teardown() 
	{
	 
	driver.quit();
	}

}
