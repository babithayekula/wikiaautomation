package com.selenium.WikiaAutomation;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;




import com.google.common.base.Function;

//this class is were we will use all the reuseable functions e.g getwindow handle.

public class CommonCode {
	public WebDriver driver = Configuration.browser(); // This will read the
														// configuration.java >
														// Gets the webdriver
														// instance

	public void getWindowHandle() {
		Set<String> handles = driver.getWindowHandles();// We will use this if
														// windows is greater
														// than 1 - otherwise we
														// just getwindowhandle
														// ();
		if (handles.size() >= 1) {
			System.out.println("Number of broiwsers opened are"
					+ handles.size());
			for (String handle : handles) {
				driver.switchTo().window(handle);

			}
		}

	}

	public WebElement fluentWait(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return foo;
	};

	
	
	public void mouseOver(WebElement e){
		
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}
	
public void mouseclick(WebElement e){
		
		Actions a = new Actions(driver);
		a.click(e).perform();;
	}
	
	
	public void enterdata(WebElement e,String data){
		
		e.sendKeys(data);
	}

	public void showmenu(WebElement e) {

		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'display: block !important;');",
						e);
	}
	
	

}
