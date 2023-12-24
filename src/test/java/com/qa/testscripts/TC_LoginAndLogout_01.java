package com.qa.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_LoginAndLogout_01 extends TestBase {
	
	@Test
	public void login() throws InterruptedException, IOException
	{
		properties = new Properties();
		
		file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\testdata\\"+"inputData.properties");
		
		properties.load(file);
	
		if(	login_and_logout_pages.getDownArrowButton().isDisplayed())
		{
			login_and_logout_pages.getDownArrowButton().click();
		}
		
		login_and_logout_pages.getLoginButton().click();
		
		login_and_logout_pages.getEmailField().sendKeys(properties.getProperty("username"));
		
		login_and_logout_pages.getPasswordField().sendKeys(properties.getProperty("password"));
		
		login_and_logout_pages.getSubmitButton().click();
		
		Thread.sleep(2000);
		
		if(driver.getTitle().contains("Dashboard"))
		{
			Reporter.log("Login Successful");
		}
		else
		{
			captureScreenShot("login");
			
			Reporter.log("Invalid Credentials!");
			
			Assert.assertTrue(false);
		}		
	}
	
	@Test(dependsOnMethods = "login")
	public void logout() throws IOException, InterruptedException
	{
		if(		login_and_logout_pages.getDownArrowButton().isDisplayed())
		{
				
			login_and_logout_pages.getDownArrowButton().click();
				
			js.executeScript("scroll(0,0);");
				
			for(WebElement element : 		login_and_logout_pages.getAccountButton())
			{
				if(element.getText().contains("ACCOUNT"))
				{
					element.click();
					break;
				}
			}
		 }
		
		Thread.sleep(3000);
				
		login_and_logout_pages.getLogoutButton().click();
				
			
		if(driver.getTitle().contains("Login"))
		{
			Reporter.log("Logout Successful");
		}
		else
		{
			captureScreenShot("logout");
			
			Reporter.log("Logout Failed");
			
			Assert.assertFalse(true);
				
		}
	}
}
