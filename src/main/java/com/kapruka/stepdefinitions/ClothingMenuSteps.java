package com.kapruka.stepdefinitions;

import static com.kapruka.sourcePackage.Keyword.threadLocal;
import org.testng.Assert;
import com.kapruka.pages.HomePageDashboardPOM;
import com.kapruka.pages.ViewCartPagePOM;
import com.kapruka.pages.ClothingFirstProductClickPOM;
import com.kapruka.pages.ClothingPOM;
import com.kapruka.sourcePackage.Keyword;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClothingMenuSteps {

	String firstProductDescription, firstProductPrice;
	
	@When("User click on Clothing button")
	public void user_click_on_clothing_button() {
		HomePageDashboardPOM homePage = new HomePageDashboardPOM();
		homePage.clothingMenuToBeClickable();
		homePage.clickClothingMenu();
	}

	@When("User click on Men clothing button")
	public void user_lick_on_men_clothing_button() {
		// Use ClothingPOM to click the Men clothing button
		ClothingPOM clothingMenu = new ClothingPOM();
		clothingMenu.clickMenClothingBtn();
	}

	@Then("User should nevigate to clothing menu")
	public void user_should_nevigate_to_clothing_menu() {
		String title = threadLocal.get().getTitle();
		Assert.assertEquals(title, "Clothing Store Sri Lanka | Online Fashion & Clothes Shop");
	}

	@Then("User should nevigate to men clothing menu")
	public void user_should_nevigate_to_men_clothing_menu() {
		String title = threadLocal.get().getTitle();
		Assert.assertEquals(title, "Men's Fashion Online - Shirts & More in Sri Lanka");
	}

	// New steps for See More Products scenario
	int initialProductCount = 0;

	@When("User captures the number of products displayed initially")
	public void user_captures_the_number_of_products_displayed_initially() {
		ClothingPOM clothing = new ClothingPOM();
		initialProductCount = clothing.countOfProductsDisplayedAtStart();
		// sanity check
		if (initialProductCount < 0) {
			initialProductCount = 0;
		}
	}

	@When("User click on See More Products button")
	public void user_clicks_on_see_more_products_button() {
		ClothingPOM clothing = new ClothingPOM();
		clothing.scrollDownToViewMoreProductsBtn();
		clothing.clickViewMoreProductsBtn();
	}

	@Then("More products should be loaded on the clothing menu page")
	public void more_products_should_be_loaded() {
		ClothingPOM clothing = new ClothingPOM();
		int afterClickCount = clothing.countOfProductsAfterViewMoreClick(initialProductCount);
		// Assert that more products are loaded (count increased)
		//System.out.println("Product count after clicking See More: " + afterClickCount);
		Assert.assertTrue(afterClickCount > initialProductCount, "Expected more products to be loaded after clicking See More; initial: " + initialProductCount + " after: " + afterClickCount);
	}
	
	@When("User captures the name and price of a product")
	public void user_captures_the_name_and_price_of_a_product() {
		ClothingPOM clothing = new ClothingPOM();
		firstProductDescription = clothing.captureFirstProductDescription();
		firstProductPrice = clothing.captureFirstProductPrice();		
	}
	
	@When("User click on a product")
	public void user_clicks_on_the_product() {
		ClothingPOM clothing = new ClothingPOM();
		clothing.clickOnFirstProduct();
	}
	
	
	@Then("The product details page should be loaded with accurate product name and price")
	public void the_product_details_page_should_be_loaded_with_accurate_product_name_and_price() {
		ClothingFirstProductClickPOM productPage = new ClothingFirstProductClickPOM();
		String descriptionOnClick = productPage.captureProductDescription();
		String priceOnClick = productPage.captureProductPrice();
		Assert.assertEquals(descriptionOnClick, firstProductDescription, "Product description mismatch: expected '" + firstProductDescription + "' but found '" + descriptionOnClick + "'");
		Assert.assertEquals(priceOnClick, firstProductPrice, "Product price mismatch: expected '" + firstProductPrice + "' but found '" + priceOnClick + "'");
	}
	
	@When("User click on Add to Cart button")
	public void user_click_on_add_to_cart_button() {
		ClothingFirstProductClickPOM productPage = new ClothingFirstProductClickPOM();
		productPage.clickAddToCartBtn();
		productPage.clickViewCartBtn();
	}
	
	@Then("The product should be added to the cart successfully")
	public void view_Cart() {
		//ViewCartPagePOM viewCart = new ViewCartPagePOM();
		String cartTitle = threadLocal.get().getTitle();
		Assert.assertEquals(cartTitle, "Kapruka Shopping Cart");
	}
	
	@When("User click on Delete button for the added product")
	public void clickOnDeleteButton() {
		ViewCartPagePOM viewCart = new ViewCartPagePOM();
		viewCart.clickDeleteProductBtn();
	}
	
	@Then("The product should be removed from the cart successfully")
	public void verifyProductDeletion() {
		ViewCartPagePOM viewCart = new ViewCartPagePOM();
		String deletionMessage = viewCart.getDeletedProductMessage();
		Assert.assertTrue(deletionMessage.contains("Removed From Cart"), "Expected deletion message to confirm product removal, but got: " + deletionMessage);
	}
	
	@When("User click on Keep Shopping button")
	public void clickOnKeepShoppingButton() {
		ViewCartPagePOM viewCart = new ViewCartPagePOM();
		viewCart.clickKeepShoppingBtn();
	}
	
	@Then("User should be navigated to the Home Page successfully")
	public void verifyKeepShoppingNavigation() {
		String homeTitle = threadLocal.get().getTitle();
		Assert.assertTrue(homeTitle.contains("Sri Lanka"), homeTitle);
	}
	
	@When("User click on Checkout button")
	public void clickOnCheckoutButton() {
		ViewCartPagePOM viewCart = new ViewCartPagePOM();
		viewCart.clickCheckoutBtn();
	}
	
	@Then("User should be navigated to the checkout page successfully")
	public void verifyCheckoutNavigation() {
		String checkoutTitle = threadLocal.get().getTitle();
		Assert.assertTrue(checkoutTitle.contains("Checkout"), "Expected to navigate to checkout page, but got: " + checkoutTitle);
	}
	
	@When("User click on quantity increment button")
	public void clickOnQuantityIncrementButton() {
		ClothingFirstProductClickPOM productPage = new ClothingFirstProductClickPOM();
		productPage.clickIncreaseQtyBtn();
	}
	
	@Then("The product should be added to the cart with the updated quantity successfully")
	public void verifyQuantityIncrement() {
		ViewCartPagePOM viewCart = new ViewCartPagePOM();
		int quantity = viewCart.getProductQuantity();
		Assert.assertTrue(quantity > 1, "Expected product quantity to be greater than 1 after increment, but got: " + quantity);
	}
	
	@Then("The cart total should be calculated correctly based on the quantity of the product added to the cart")
	public void verifyCartTotalCalculation() {
		ViewCartPagePOM viewCart = new ViewCartPagePOM();
		int quantity = viewCart.getProductQuantity();
		
		// Remove currency symbol and commas from price string to convert to a number
		String usdPart = firstProductPrice.split("\\(")[0];   // "US$38.34 "
		double price = Double.parseDouble(usdPart.replaceAll("[^0-9.]", ""));
		double expectedTotal = price * quantity;		
		double displayedTotal = viewCart.getDisplayedTotal(); // This method needs to be implemented in ViewCartPagePOM
		Assert.assertEquals(displayedTotal, expectedTotal, "Expected cart total to be " + expectedTotal + " but got " + displayedTotal);
	}
	
	
	
	
	
	
	
}