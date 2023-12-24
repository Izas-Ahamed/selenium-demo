package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_SignUp_01 extends TestBase{
	
	
		@Test(dataProvider = "AuthDataProvider")
		public void signUp(String firstName,String secondName, String phoneNo, String emailId, String password,String accountType) throws IOException, InterruptedException
		{
			
			if(signup_pages.getDownArrowButton().isDisplayed())
			{
				signup_pages.getDownArrowButton().click();
				
				js.executeScript("scroll(0,0);");
				
			}
			
			signup_pages.getSignUpButton().click();
			
			signup_pages.getFirstNameField().sendKeys(firstName);
			
			signup_pages.getSecondNameField().sendKeys(secondName);
			
			signup_pages.getPhoneNoField().sendKeys(phoneNo);
			
			js.executeScript("scroll(0,300);");
			
			signup_pages.getEmailField().sendKeys(emailId);
			
			signup_pages.getPasswordField().sendKeys(password);
			
			signup_pages.getAccountTypeField().click();
			
			for(WebElement list : signup_pages.getAccountTypes())
			{
				if(list.getText().equals(accountType))
				{
					list.click();
					break;
				}
			}
			
			signup_pages.getSubmitButton().click();
			
			Thread.sleep(2000);
			
			if( signup_pages.getMessages().getText().contains("Signup successfull please login."))
			{
				Reporter.log("Sign Up Successfull");
			}
			else 
			{
				captureScreenShot("signUp");
					
				Assert.assertTrue(false);
			}
					
			Thread.sleep(3000);
			
		}

		@DataProvider(name="AuthDataProvider")
		public Object[][] dataProvider() throws IOException
		{
			return excel.getData("PHP_Travels_TestData","Sheet1");
		}
}
