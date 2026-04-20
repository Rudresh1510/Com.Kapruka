package com.sourcePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import kapruka.exceptions.InvalidBrowserNameException;

public class Keyword {

	//private static RemoteWebDriver rDriver;
	public static ChromeOptions option;

	public static final ThreadLocal<RemoteWebDriver> threadLocal = new ThreadLocal();
	//public static final RemoteWebDriver driver = threadLocal.get();
	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			option = new ChromeOptions();
			option.addArguments("--incognito");
			threadLocal.set(new ChromeDriver(option));
		} else if(browserName.equalsIgnoreCase("firefox")) {
			threadLocal.set(new FirefoxDriver());
		}else if(browserName.equalsIgnoreCase("edge")) {
			threadLocal.set(new EdgeDriver());
		}else {
			throw new InvalidBrowserNameException(browserName);
		}		
	}
	
	public static void launchUrl(String url) {
		threadLocal.get().get(url);
		System.out.println("Launched url: "+url);
	}
	/**
	 *This method will enter the text in the text box based on the locator type
	 *and the locator values passed by user. Supported locators are:
	 *<ul>
	 *<li>id</li>
	 *<li>name</li>
	 *<li>className</li>
	 *<li>tagName</li>
	 *<li>linkText</li>
	 *<li>partialLinkText</li>
	 *<li>cssSelector</li>
	 *<li>xPath</li>
	 *</ul> 
	 */
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		if (locatorType.equalsIgnoreCase("id")) {
			threadLocal.get().findElement(By.id(locatorValue)).sendKeys(textToEnter);
		} else if(locatorType.equalsIgnoreCase("name")){
			threadLocal.get().findElement(By.name(locatorValue)).sendKeys(textToEnter);
		}else if(locatorType.equalsIgnoreCase("className")){
			threadLocal.get().findElement(By.className(locatorValue)).sendKeys(textToEnter);
		}else if(locatorType.equalsIgnoreCase("tagName")){
			threadLocal.get().findElement(By.tagName(locatorValue)).sendKeys(textToEnter);
		}else if(locatorType.equalsIgnoreCase("linkText")){
			threadLocal.get().findElement(By.linkText(locatorValue)).sendKeys(textToEnter);
		}else if(locatorType.equalsIgnoreCase("partialLinkText")){
			threadLocal.get().findElement(By.partialLinkText(locatorValue)).sendKeys(textToEnter);
		}else if(locatorType.equalsIgnoreCase("cssSelector")){
			threadLocal.get().findElement(By.cssSelector(locatorValue)).sendKeys(textToEnter);
		}else if(locatorType.equalsIgnoreCase("xpath")){
			threadLocal.get().findElement(By.xpath(locatorValue)).sendKeys(textToEnter);
		}else {
			throw new InvalidSelectorException(locatorType);
		}

	}
	
	/***
	 * This method will click on the web element based on the locator type and locator
	 * @param locatorType
	 * @param locatorValue
	 */
	public static void clickOn(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			threadLocal.get().findElement(By.id(locatorValue)).click();
		} else if(locatorType.equalsIgnoreCase("name")){
			threadLocal.get().findElement(By.name(locatorValue)).click();
		}else if(locatorType.equalsIgnoreCase("className")){
			threadLocal.get().findElement(By.className(locatorValue)).click();
		}else if(locatorType.equalsIgnoreCase("tagName")){
			threadLocal.get().findElement(By.tagName(locatorValue)).click();
		}else if(locatorType.equalsIgnoreCase("linkText")){
			threadLocal.get().findElement(By.linkText(locatorValue)).click();
		}else if(locatorType.equalsIgnoreCase("partialLinkText")){
			threadLocal.get().findElement(By.partialLinkText(locatorValue)).click();
		}else if(locatorType.equalsIgnoreCase("cssSelector")){
			threadLocal.get().findElement(By.cssSelector(locatorValue)).click();
		}else if(locatorType.equalsIgnoreCase("xpath")){
			threadLocal.get().findElement(By.xpath(locatorValue)).click();
		}else {
			throw new InvalidSelectorException(locatorType);
		}
		
	}

}
