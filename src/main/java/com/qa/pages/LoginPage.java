package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class LoginPage extends TestBase {
	

	@FindBy(xpath="//input[@class='_2zrpKA']")
	WebElement usernametxt;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordtxt;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbtn;
	
    @FindBy(xpath="//span[text()='Login']")
    WebElement LoginWebElement;
    
    @FindBy(xpath="//*[text()='CONTINUE']")
    WebElement Continuebtn;
    
	
	public LoginPage() {
		// TODO Auto-generated constructor stub
	
	PageFactory.initElements(driver, this);
		
	}
	
	public boolean verifyloginpage()
	{
		boolean flag=LoginWebElement.isDisplayed();
		return flag;
	}
	
	
	public HomePage loginSteps(String username,String password)
	{
		usernametxt.sendKeys(username);
		if (passwordtxt.isDisplayed())
		{
		passwordtxt.sendKeys(password);
		loginbtn.click();
		}else
		{
			
			Continuebtn.click();
		}
			
		
		return new HomePage();
		
	}
	
	

}
