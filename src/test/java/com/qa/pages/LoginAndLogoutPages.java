package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAndLogoutPages {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//header/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement downArrowButton;
	
	@FindBy(linkText ="Login")
	WebElement loginButton;
	
	@FindBy(linkText ="Logout")
	WebElement logoutButton;

	@FindBy(name = "email")
	WebElement emailField;

	@FindBy(name = "password")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//button[@id='currency']")
	List<WebElement> accountButton;
	
	@FindBy(xpath=".//div[@class='message']/div")
	List<WebElement> messages;
	
	public LoginAndLogoutPages(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDownArrowButton() {
		return downArrowButton;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public List<WebElement> getMessages() {
		return messages;
	}

	public List<WebElement> getAccountButton() {
		return accountButton;
	}


}
