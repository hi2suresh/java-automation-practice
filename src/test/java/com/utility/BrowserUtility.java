package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}else {
			System.err.println("Invalid browserName please choose chrome or edge");
		}
	}
	
	public BrowserUtility(Browser browser) {
		if(browser == Browser.CHROME) {
			driver = new ChromeDriver();
		}else if(browser == Browser.EDGE){
			driver = new EdgeDriver();
		}else {
			System.err.println("Invalid browserName please choose chrome or edge");
		}
	}
	
	public void goToWebsite(String url) {
		driver.get(url);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}
	
	public void enterText(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
	}
	
	public String getVisibleText(By locator) {
		WebElement element = driver.findElement(locator);
		return element.getText();
	}
}
