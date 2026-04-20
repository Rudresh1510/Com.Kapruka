package com.kapruka.stepdefinitions;

import org.testng.Assert;

import com.kapruka.pages.ElectronicsPOM;
import com.kapruka.pages.HomePageDashboardPOM;
import com.kapruka.sourcePackage.Keyword;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ElectronicsMenuSteps {

	@When("User click on Electronics button")
	public void clickOnElectronicsButton() {
		HomePageDashboardPOM homePage = new HomePageDashboardPOM();
		homePage.clickElectronicsMenu();
	}
	
	@Then("User should nevigate to electronics menu")
	public void nevigateToElectronicsMenu() {
		String title = Keyword.threadLocal.get().getTitle();
		Assert.assertEquals(title, "Electronics Sri Lanka | Best Home Appliances Price - Kapruka 4.8 Rating");
	}
	
	@When("User click on Kitchen Appliances button")
	public void clickOnKitchenAppliancesButton() {
		ElectronicsPOM electronicsMenu = new ElectronicsPOM();
		electronicsMenu.clickKitchenAppliancesBtn();
	}
	
	@Then("User should nevigate to Kitchen Appliances page")
	public void nevigateToKitchenAppliancesPage() {
		String title = Keyword.threadLocal.get().getTitle();
		Assert.assertEquals(title, "Top Kitchen Appliances in Sri Lanka - Shop Online");
	}
	
	@Then("30 products should be displayed on the electronics menu page")
	public void productsAtTheStartOnElectronicsMenuPage() {
		ElectronicsPOM electronicsMenu = new ElectronicsPOM();
		int productCount = electronicsMenu.countOfProductsDisplayedAtStart();
		Assert.assertEquals(productCount, 30, "Expected 30 products to be displayed on the electronics menu page, but found " + productCount);
	}
	
	
	
	
	
	
}
