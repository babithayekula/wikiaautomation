package com.selenium.WikiaAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WikiaVideoAdd {
	
	
public WebDriver driver=Configuration.browser();
	


	public CommonCode common;
	public ReadExcel read;
	
	
	
	@FindBy(id="wpWikiaVideoAddUrl")
	private WebElement wpWikiaVideoAddUrl_TextBox;
	
	@FindBy(xpath="//input[@value='Add']")
	private WebElement addBtn;
	
	
	@FindBy(xpath="//div[@class='msg']//a")
	private WebElement vidoeLink;
	
	@FindBy(className="msg")
	private WebElement successMessage;
	
	
	@FindBy(xpath="//div[contains(@class,'header-title')]//h1")
	private WebElement videoTitle;
	
	
	
	
	

	public WikiaVideoAdd(){
		
		PageFactory.initElements(driver, this);
		common= new CommonCode();
		read= new ReadExcel();
	}
	
	public void validateVideoPage(){
		
		Assert.assertEquals(driver.getTitle(), read.readData("Videotitle"));
	}
	
	public void addUrl(String Url){
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wpWikiaVideoAddUrl_TextBox.sendKeys(Url);
		addBtn.click();
		Assert.assertTrue(successMessage.getText().contains(read.readData("Successmessage")));
		
	}
	
	public void clickuploadedVideo(){
		String musicName=vidoeLink.getText();
		vidoeLink.click();		
		Assert.assertTrue(musicName.contains(videoTitle.getText()));
	}
	
	
	
	

}
