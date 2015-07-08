package com.selenium.WikiaAutomationtTest;

import org.testng.annotations.Test;

import com.selenium.WikiaAutomation.Configuration;
import com.selenium.WikiaAutomation.Home;
import com.selenium.WikiaAutomation.ReadExcel;
import com.selenium.WikiaAutomation.WikiaVideoAdd;

public class SanityTest extends TestngAnnotationsTest {

	public Home home;
	public ReadExcel read;
	public WikiaVideoAdd addvideo;

	public SanityTest() {
		
		
		home = new Home();
		read = new ReadExcel();
		addvideo= new WikiaVideoAdd();

	}

	@Test(testName = "login_Positive", description = "login_Positive", timeOut = 190000, enabled = true, groups = {
			"sanity", "1" })
	public void alogin_Positive() {

		home.loginToApp(Configuration.LoginuserNmae(),
				Configuration.LoginPassword());
	}

	@Test(testName = "add Video", description = "add Video", timeOut = 190000, enabled = true, groups = {
			"sanity", "2" }, dependsOnGroups = { "1" })
	public void login_Negative() {
		home.contribute();
		addvideo.addUrl(read.readData("youtubeURL"));
		addvideo.validateVideoPage();
		addvideo.clickuploadedVideo();

	}

}
