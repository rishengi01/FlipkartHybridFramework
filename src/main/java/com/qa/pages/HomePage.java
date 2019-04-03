package com.qa.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class HomePage extends TestBase{
	//practise git modified file push 
	@FindBy(xpath="//a[text()='Login & Signup']")
	WebElement LoginAndSinguplink;
	
	
	@FindBy(xpath="//input[@class='LM6RPg']")
	WebElement searchbox;
	
	@FindBy(xpath="//img[@title='Flipkart']")
	WebElement flipkartlogo;
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	public String verifyHomepge()
	{
		return driver.getTitle();
			
	}
	
	
	public boolean verifyflipkartlogo()
	{
		return flipkartlogo.isDisplayed();
	}
	
	

}
