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

	String firstProductDescription, firstProductPrice, productNameInSearch;
	
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
	public void capturesNameAndPriceOfProduct() {
		ClothingPOM clothing = new ClothingPOM();
		firstProductDescription = clothing.captureFirstProductDescription();
		firstProductPrice = clothing.captureFirstProductPrice();		
	}
	
	@When("User click on a product")
	public void userClicksOnTheProduct() {
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
	public void clickOnAddToCartButton() {
		ClothingFirstProductClickPOM productPage = new ClothingFirstProductClickPOM();
		productPage.clickAddToCartBtn();
		productPage.clickViewCartBtn();
	}
	
	@Then("The product should be added to the cart successfully")
	public void viewCart() {
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
	
	@Then("The cart should be empty and checkout button should be disabled and user should not be able to navigate to checkout page")
	public void verifyEmptyCartAndCheckoutDisabled() {
		ViewCartPagePOM viewCart = new ViewCartPagePOM();
		//int quantity = viewCart.getProductQuantity();
		//Assert.assertEquals(quantity, 0, "Expected cart to be empty with quantity 0, but got: " + quantity);
		boolean isCheckoutEnabled = viewCart.isCheckoutButtonEnabled(); // This method needs to be implemented in ViewCartPagePOM
		Assert.assertFalse(isCheckoutEnabled, "Expected checkout button to be disabled when cart is empty, but it is enabled");		
		//viewCart.clickCheckoutBtn();
		//String currentTitle = threadLocal.get().getTitle();
		//Assert.assertFalse(currentTitle.contains("Checkout"), "Expected not to navigate to checkout page when cart is empty, but navigated to: " + currentTitle);
	}
	
	
	@When("User enters a product name {string} in the search bar")
	public void searchByProduct(String productName) {
		productNameInSearch = productName;
		ClothingPOM clothing = new ClothingPOM();
		clothing.searchForProduct(productName);
	}
	
	@When("User click on search button")
	public void clickOnSearchButton() {
		ClothingPOM clothing = new ClothingPOM();
		clothing.clickSearchBtn();
	}
	
	@Then("Relevant products should be displayed based on the search query")
	public void verifySearchResults() {
		ClothingPOM clothing = new ClothingPOM();
		String url = threadLocal.get().getCurrentUrl();
		Assert.assertTrue(url.contains(productNameInSearch), "Expected search results page URL to contain search query, but got: " + url);		
	}
	
	@When("User enters an invalid product name {string} in the search bar")
	public void searchByInvalidProduct(String productName) {
		//productNameInSearch = "asasdsdssdssffdsf";
		ClothingPOM clothing = new ClothingPOM();
		clothing.searchForProduct(productName);
	}
	
	@Then("An appropriate message should be displayed indicating that {string}")
	public void verifyInvalidProductSearchResultsMessage(String expectedMessage) {
		ClothingPOM clothing = new ClothingPOM();
		String actualMessage = clothing.getInvalidSearchMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Expected no search results message to be '" + expectedMessage + "' but got '" + actualMessage + "'");
	}
	
	
	@When("User click on search button without entering a product name")
	public void clickSearchWithoutEnteringProductName() {
		ClothingPOM clothing = new ClothingPOM();
		clothing.clearSearchInput();
		clothing.clickSearchBtn();
	}
	
	@Then("Same clothing menu page should be displayed")
	public void verifyEmptySearchResults() {
		String title = threadLocal.get().getTitle();
		Assert.assertTrue(title.contains("Sri Lanka"), "Expected to navigate to checkout page, but got: " + title);
		
	}
	
	@When("User enters special characters {string} in the search bar")
	public void searchBySpecialCharacters(String specialChars) {
		ClothingPOM clothing = new ClothingPOM();
		clothing.searchForProduct(specialChars);
	}
	
	@Then("An error message should be displayed indicating that {string}")
	public void verifySpecialCharErrorMessage(String expectedMessage) {
		ClothingPOM clothing = new ClothingPOM();
		String actualMessage = clothing.getSpecialCharSearchMessage();
		Assert.assertEquals(actualMessage, expectedMessage, "Expected no search results message to be '" + expectedMessage + "' but got '" + actualMessage + "'");
	}
	
	@Then("Auto suggestion should be displayed based on the entered text {string}")
	public void verifySearchAutoSuggestion(String searchText) {
		ClothingPOM clothing = new ClothingPOM();		
		boolean hasRelevantSuggestion = clothing.getSearchAutoSuggestions().stream()
				.anyMatch(suggestion -> suggestion.toLowerCase().contains(searchText.toLowerCase()));
		Assert.assertTrue(hasRelevantSuggestion, "Expected at least one search auto-suggestion to contain '" + searchText + "' but no suggestions were relevant");
	}
	
	@When("User click on back page button")
	public void nevigateToBackPage() {
		Keyword.threadLocal.get().navigate().back();
				
	}
	
	@Then("User should nevigate back to clothing menu")
	public void backToClothingMenu() {
		String title = Keyword.threadLocal.get().getTitle();
		Assert.assertTrue(title.contains("Sri Lanka"), "Expected to navigate to clothing page, but got: " + title);
		
	}
	
	@When("User click on refresh page button")
	public void refreshPage() {
		Keyword.threadLocal.get().navigate().refresh();
	}
	
	@Then("User should stays on same page")
	public void stayOnSamePage() {
		String url = Keyword.threadLocal.get().getCurrentUrl();
		Assert.assertTrue(url.contains(productNameInSearch), "Expected to navigate to clothing page, but got: " + url);
		
	}
	
	@When("User click on a decrease quantity button")
	public void decreaseProductQuantity() {
		ClothingFirstProductClickPOM productPage = new ClothingFirstProductClickPOM();
		productPage.clickDecreaseQtyBtn();
	}
	
	@Then("User should not able to decrease quantity below {int} product")
	public void verifyProductQuantity(int minQuantity) {
		ClothingFirstProductClickPOM productPage = new ClothingFirstProductClickPOM();
		int quantity = productPage.getMinQuantityNumber();
		Assert.assertEquals(quantity, minQuantity);		
	}
	
	int stockQuantity;
	@When("User capture available stock")
	public void availableStock() {
		ClothingFirstProductClickPOM productPage = new ClothingFirstProductClickPOM();
		stockQuantity = productPage.getAvailableStock();		
	}
	
	@When("User click on a increase quantity button")
	public void clickOnProductIncreamentButton() {
		ClothingFirstProductClickPOM productPage = new ClothingFirstProductClickPOM();		
		for (int i = 0; i < (stockQuantity+1); i++) {
			productPage.clickIncreaseQtyBtn();
		}		
	}
	
	@Then("User should not able to increase quantity beyond available stock")
	public void verifyQunatityAfterAvailableStocksClick() {
		ClothingFirstProductClickPOM productPage = new ClothingFirstProductClickPOM();
		int quantity = productPage.getMAxQuantityNumber();
		Assert.assertEquals(quantity, stockQuantity);		
	}
	
	@Then("The products added to cart should still be in the cart after page refresh")
	public void verifyCartPersistenceAfterRefresh() {
		ViewCartPagePOM viewCart = new ViewCartPagePOM();
		boolean isProductInCart = viewCart.isProductPresentInCart(); // This method needs to be implemented in ViewCartPagePOM
		Assert.assertTrue(isProductInCart, "Expected product to still be in the cart after page refresh, but it is not found");
	}
	
	
	
	
	
	
	
	
	
	/* String srcofProductBeforeClick;
	@When("User capture the image source for first product")
	public void imageSourceOfProduct() {
		ClothingPOM clothing = new ClothingPOM();
		srcofProductBeforeClick = clothing.imgSourceFirstProduct();		
	}
	
	@Then("Image displayed before and after clicking on product should remain same")
	public void verifyImageConsistency() {
		ClothingFirstProductClickPOM product = new ClothingFirstProductClickPOM();
		String srcOfImage = product.srcOfImageProduct();
		
		Assert.assertEquals(srcOfImage, srcofProductBeforeClick);
	} */
	
	
	
	
	
	
	
	
	
}