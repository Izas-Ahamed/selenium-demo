package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPages {
	
	WebDriver driver;
	
	@FindBy(xpath = "//header/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement downArrowButton;
	
	@FindBy(xpath="/html/body/header/div[1]/div/div/div[2]/div/div/a[1]")
	WebElement signUpButton;

	@FindBy(name = "first_name")
	WebElement firstNameField;

	@FindBy(name = "last_name")
	WebElement secondNameField;

	@FindBy(name = "phone")
	WebElement phoneNoField;

	@FindBy(name = "email")
	WebElement emailField;

	@FindBy(name = "password")
	WebElement passwordField;
	
	@FindBy(xpath="//span[@id='select2-account_type-container']")
	WebElement accountTypeField;
	
	@FindBy(xpath = "//ul[@id='select2-account_type-results']/li")
	List<WebElement> accountTypes;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@class='message']")
	WebElement messages;
	
	public SignUpPages(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDownArrowButton() {
		return downArrowButton;
	}

	public WebElement getSignUpButton() {
		return signUpButton;
	}

	public WebElement getFirstNameField() {
		return firstNameField;
	}

	public WebElement getSecondNameField() {
		return secondNameField;
	}

	public WebElement getPhoneNoField() {
		return phoneNoField;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getAccountTypeField() {
		return accountTypeField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getMessages() {
		return messages;
	}

	public List<WebElement> getAccountTypes() {
		return accountTypes;
	}


	
	
}
