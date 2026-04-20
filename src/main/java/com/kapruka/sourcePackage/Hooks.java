package com.kapruka.sourcePackage;

import static com.kapruka.sourcePackage.Keyword.*;

import com.kapruka.utils.App;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	//String appURL = "https://www.kapruka.com/";

	@Before
	public void setup() throws Exception {
		openBrowser(App.getBrowserName());
		launchUrl(App.getUrl("qa"));
		threadLocal.get().manage().window().maximize();
	}

	@After
	public void logout() throws Exception {
		quitBrowser();
		System.out.println("Driver is quite successully...!");
	}
	

}