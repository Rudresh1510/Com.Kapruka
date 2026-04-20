package com.sourcePackage;

import static com.sourcePackage.Keyword.*;
import com.kapruka.utils.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	// public RemoteWebDriver driver;
	String appURL = "https://www.kapruka.com/";

	// Keyword keyword = new Keyword();
	@BeforeMethod
	public void setup() {
		//threadLocal.get();
		openBrowser(App.getBrowserName());
		launchUrl(App.getUrl("qa"));
		threadLocal.get().manage().window().maximize();
	}

	@AfterMethod
	public void logout() {
		threadLocal.get().close();
		System.out.println("Driver quite successfully....!");
	}

}
