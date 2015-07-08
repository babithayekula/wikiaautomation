package com.selenium.WikiaAutomationtTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.selenium.WikiaAutomation.Configuration;



public class TestngAnnotationsTest {

	public WebDriver driver = Configuration.browser();
	
	public TestngAnnotationsTest() {

	
	}

	@BeforeSuite(alwaysRun = true)
	public void invokeURL() {

		driver.get(Configuration.LoginURL());
		driver.manage().window().maximize();
		

	}

	

	

	@AfterSuite(alwaysRun = true)
	public void CloseBrowser() {
		driver.quit();

	}
}
