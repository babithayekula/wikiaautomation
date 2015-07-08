package com.selenium.WikiaAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	public WebDriver driver=Configuration.browser();
	
	public CommonCode common;
	
	@FindBy(className="sign-in-label")
	private WebElement signInLabel;
	
	@FindBy(id="usernameInput")
	private WebElement userNameTextBox;
	
	@FindBy(id="passwordInput")
	private WebElement passwordInput;
	
	
	@FindBy(className="login-button")
	private WebElement login_button;
	
	@FindBy(id="AccountNavigation")
	private WebElement AccountNavigation;
	
	@FindBy(xpath="//nav[contains(@class,'contribute')]")
	private WebElement contribute;
	
	@FindBy(xpath="//a[text()='Add a Video']")
	private WebElement AddVideo;
	
	@FindBy(className="WikiaMenuElement")
	private WebElement WikiaMenuElement;
	
	
	
	
	
	
	
	
	
	public Home(){
		
		PageFactory.initElements(driver, this);
		common= new CommonCode();
	}
	
	public void loginToApp(String userNmae,String Password){
		common.mouseOver(signInLabel);
		userNameTextBox.sendKeys(userNmae);
		passwordInput.sendKeys(Password);
		common.mouseclick(login_button);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AccountNavigation.isDisplayed();
		
	}
	
	public void contribute(){
		
		contribute.click();
		common.showmenu(WikiaMenuElement);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddVideo.click();
	}
	
	
	
	
	
	
	
	

}
