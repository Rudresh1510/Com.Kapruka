package com.kapruka.stepdefinitions;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.kapruka.pages.HomePageDashboardPOM;
import com.kapruka.sourcePackage.Keyword;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageMenuSteps {

	@Then("{int} productCategories should be displayed on the HomePage menu page")
	public void productCategoriesDisplayedOnHomePageMenu(int expectedCount) {
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		int countOfCategoriesDisplayed = homepage.countOfAllCategories();
		Assert.assertEquals(countOfCategoriesDisplayed, expectedCount,
				"Expected" + expectedCount + "product categories to be displayed on the HomePage menu page, but found "
						+ countOfCategoriesDisplayed);
	}

	@Then("{int} featured products should be displayed on the HomePage menu")
	public void featuredProductsDisplayedOnHomePageMenu(int expectedCount) {
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		int countOfFeaturedProducts = homepage.countOfFeaturedProducts();
		Assert.assertEquals(countOfFeaturedProducts, expectedCount, "Expected " + expectedCount
				+ " featured products to be displayed on the HomePage menu page, but found " + countOfFeaturedProducts);
	}

	@Then("Home page banner should be displayed on the HomePage menu")
	public void homePageBannerDisplayedOnHomePageMenu() {
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		boolean isBannerDisplayed = homepage.isHomePageBannerDisplayed();
		Assert.assertTrue(isBannerDisplayed,
				"Expected home page banner to be displayed on the HomePage menu page, but it was not displayed.");
	}

	@When("User click on browse all products button of all products category")
	public void userClickOnBrowseAllProductsButtonOfAllProductsCategory() {
		JavascriptExecutor js = (JavascriptExecutor) Keyword.threadLocal.get();
		js.executeScript("window.scrollBy(0, 500);");
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		homepage.clickBrowseAllCategoriesProductsBtn();
	}

	@Then("All the products page should be loaded along with below specified category of products")
	public void productsCategoryLoaded(io.cucumber.datatable.DataTable dataTable) {
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		List<WebElement> productsDisplayed = homepage.getAllProductCategoriesOnAllProductsPage();
		List<String> products = dataTable.asList();
		int count = 0;
		for (WebElement element : productsDisplayed) {
			String productName = element.getText();
			if (products.contains(productName)) {
				count++;
			}
		}
		// int expectedCount = products.size();
		Assert.assertEquals(count, products.size(), "Expected " + products.size()
				+ " product categories to be displayed on the All Products page, but found " + count);
	}
	
	@When("User enter a valid product name in the search box {string}")
	public void userEnterValidProductName(String productName) {
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		homepage.enterSearchKeyword(productName);
	}
	
	@When("User click on homePage search button")
	public void userClickOnSearchButton() {
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		homepage.clickSearchBtn();
	}
	
	@Then("It should load the page with the searched product {string}")
	public void searchResultPageShouldLoad(String productSearched) {
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		List<WebElement> productsDisplayed = homepage.getProductsDisplayedOnSearch();
		boolean isProductFound = false;
		productSearched = productSearched.toLowerCase();
		for (WebElement element : productsDisplayed) {
			String productName = element.getText();
			productName = productName.toLowerCase();
			if (productName.contains((productSearched))) {
				isProductFound = true;
				break;
			}
		}
		Assert.assertTrue(isProductFound, "Expected to find the searched product "+ productSearched +" in the search results, but it was not found.");
	}
	
	@When("User enter a invalid product name in the search box {string}")
	public void userEnterInvalidProductName(String productName) {
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		homepage.enterSearchKeyword(productName);
	}
	
	@Then("It should display a messade as {string}")
	public void invalidSearchErrorMessage(String expectedMessage) {
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		String actualMessage = homepage.getInvalidSearchMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Expected message: " + expectedMessage + ", but found: " + actualMessage);
	}	
	
	@Then("{int} products should be displayed in the best seller products section on the HomePage menu page")
	public void countOfProductsInBestSeller(int expectedCount) {
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		int countOfBestSellerProducts = homepage.countOfBestSellerProducts();
		Assert.assertEquals(countOfBestSellerProducts, expectedCount, "Expected " + expectedCount
				+ " best seller products to be displayed on the HomePage menu page, but found " + countOfBestSellerProducts);
	}
	
	@Then("Products should be displayed in the popular products section on the HomePage menu page")
	public void productsDisplayedInPopularProducts() {
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		boolean isProductDisplayedInPopularProducts = homepage.productDisplayedinPopularProducts();
		Assert.assertTrue(isProductDisplayedInPopularProducts, "Expected products to be displayed in the popular products section");
	}
	
	@Then("Footer note should be displayed and should have text {string} on the HomePage menu page")
	public void footerNoteDisplayedWithText(String expectedFooterNote) {
		HomePageDashboardPOM homepage = new HomePageDashboardPOM();
		String actualFooterNote = homepage.getFooterText();
		boolean footerTextConainsExpectedText = actualFooterNote.contains(expectedFooterNote);
		Assert.assertTrue(footerTextConainsExpectedText, "Expected footer note to contain text: " + expectedFooterNote + ", but found: ");
	}
	
	
	
	
	
	
	
	
	
	
	

}
