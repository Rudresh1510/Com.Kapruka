package com.kapruka.stepdefinitions;

import static com.kapruka.sourcePackage.Keyword.launchUrl;
import static com.kapruka.sourcePackage.Keyword.openBrowser;
import static com.kapruka.sourcePackage.Keyword.threadLocal;

import org.testng.Assert;

import com.kapruka.pages.LoginPagePOM;
import com.kapruka.utils.App;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	/* @Given("The browser is launched, the URL is opened")
	public void openBrowserAndLaunchUrl(){
		openBrowser(App.getBrowserName());
		launchUrl(App.getUrl("qa"));
		threadLocal.get().manage().window().maximize();
	}
	*/
	
	@When("User click on Accounts login button")
	public void clickOnAccountsButton() {
		LoginPagePOM loginPage = new LoginPagePOM();
		loginPage.loginAccountbtnToBeClickable();
		loginPage.clickLoginAccountBtn();
	}

	@When("User enters valid username and password")
	public void enterValidCredentials() {
		LoginPagePOM loginPage = new LoginPagePOM();
		loginPage.enterUserName(App.getUserName("qa")); 
		loginPage.enterPassword(App.getPassword("qa"));
		loginPage.clickLoginBtn();
	}
	
	@Then("User should be logged in successfully")
	public void verifyUserLoggedIn() {
		LoginPagePOM loginPage = new LoginPagePOM();
		String title = threadLocal.get().getTitle();
		Assert.assertEquals(title, "Your Account"); //Assertions links keeps changing hence using title instead of url for validation
	}
	
	@When("User enters valid username and invalid password")
	public void enterValidUsernameInvalidPassword() {
		LoginPagePOM loginPage = new LoginPagePOM();
		loginPage.loginAccountbtnToBeClickable();
		loginPage.clickLoginAccountBtn();
		loginPage.userNameToBeVisible();
		loginPage.enterUserName(App.getUserName("qa"));
		loginPage.enterPassword("Pass123");
		loginPage.clickLoginBtn();
	}

	@When("User enters invalid username and valid password")
	public void enterInvalidUsernameValidPassword() {
		LoginPagePOM loginPage = new LoginPagePOM();
		loginPage.loginAccountbtnToBeClickable();
		loginPage.clickLoginAccountBtn();
		loginPage.userNameToBeVisible();
		loginPage.enterUserName("aculshing@gmail.com");
		loginPage.enterPassword(App.getPassword("qa"));
		loginPage.clickLoginBtn();
	}

	@Then("User should not be logged in and error message should be displayed")
	public void verifyUserNotLoggedInAndErrorShown() {
		LoginPagePOM loginPage = new LoginPagePOM();
		loginPage.errorMsgToBeVisible();
		String errorMessage = loginPage.getErrorMsg();
		Assert.assertTrue(errorMessage != null && !errorMessage.trim().isEmpty(), "Expected an error message to be displayed but it was empty");
	}
}