package com.kapruka.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kapruka.sourcePackage.Keyword;
import com.kapruka.utils.WaitFor;

/**
 * Page Object Model for the Clothing page. This class should contain WebElements and methods specific to the Clothing page.
 * Web address of this page is https://www.kapruka.com/clothing or https://www.kapruka.com/online/clothing (url seems to be changing hence added both the urls here)
 */

public class ClothingPOM {
	
	@FindBy(xpath = "//a[@title='Shop For All Items']")
	WebElement allItemsBtn;    
	
	@FindBy (xpath = "//a[@title='Shop For Womens Clothing b(699)b']")
	WebElement womenClothingBtn;
	
	@FindBy (xpath = "//a[contains(@title,'Shop For Mens Clothing')]//span")
	WebElement menClothingBtn;
	
	@FindBy (xpath = "//a[@title='Shop For Saree b(284)b']")
	WebElement sariClothingBtn;
	
	@FindBy (xpath = "//a[@title='Shop For Kids Clothing b(88)b']")
	WebElement kidsClothingBtn;
	
	@FindBy (xpath ="//a[@title='Shop For Unisex Clothing b(41)b']")
	WebElement unisexClothingBtn;
	
	@FindBy (xpath ="//a[@title='Shop For Clothing Gift Sets b(10)b']")
	WebElement clothingGiftSetBtn;
	
	@FindBy (xpath = "//a[@title='Shop For Saree Blouse']")
	WebElement sareeBlouseBtn;
	
	@FindBy (xpath = "//a[@title='Shop For Mens Activewear']")
	WebElement mensActiveWearBtn;
	
	@FindBy (xpath = "//a[@title='Shop For Women Activewear']")
	WebElement womenActiveWearBtn;
	
	@FindBy(xpath = "//a[@title='Shop For Skirt']")
	WebElement skirtBtn;
	
	@FindBy (xpath = "//a[@title='Shop For Maternity Wear']")
	WebElement materityWearBtn;
	
	// See More / View More button
	@FindBy (xpath = "//a[@id='viewMoreButton']")
	WebElement viewMoreProductsBtn;
	
	@FindBy(xpath = "(//div[@class='catalogueV2textBlock'])[1]/div[1]")
	WebElement firstProductDescription;
	
	@FindBy(xpath = "(//div[@class='catalogueV2textBlock'])[1]/div[2]")
	WebElement firstProductPrice;
	
	@FindBy(xpath = "//input[@id='search-input']")
	WebElement searchInputField;
	
	@FindBy(xpath = "//button[@id='search_btn']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//div[@class='CatalogueV2Design']/div[1]/h4")
	WebElement invalidSearchMessage;
	
	@FindBy(xpath = "//font[contains(text(),'sorry')]")
	WebElement specialCharSearchMessage;
	
	@FindBy(xpath = "//ul[@id='suggestions-dropdown']/li")
	List<WebElement> searchAutoSuggestions;
	
	@FindBy (xpath = "//div[@class='logo_wrapper_block']/a[1]")
	WebElement kaprukaLogo;
	
	//@FindBy(xpath = "//div[contains(@class,'catalogueV2Repeater')]/a")
	//List<WebElement> productDisplayed;
	
	
	{
		PageFactory.initElements(Keyword.threadLocal.get(), this);
	}
		
	public void clickAllItemsBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For All Items']"));
		allItemsBtn.click();
	}
	
	public void clickWomenClothingBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Womens Clothing b(699)b']"));
		womenClothingBtn.click();
	}
	
	public void clickMenClothingBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[contains(@title,'Shop For Mens Clothing')]//span"));
		menClothingBtn.click();
	}
	
	public void clickSariClothingBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Saree b(284)b']"));
		sariClothingBtn.click();
	}
	
	public void clickKidsClothingBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Kids Clothing b(88)b']"));
		kidsClothingBtn.click();
	}
	
	public void clickUnisexClothingBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Unisex Clothing b(41)b']"));
		unisexClothingBtn.click();
	}
	
	public void clickClothingGiftSetBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Clothing Gift Sets b(10)b']"));
		clothingGiftSetBtn.click();
	}
	
	public void clickSareeBlouseBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Saree Blouse']"));
		sareeBlouseBtn.click();
	}
	
	public void clickMensActiveWearBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Mens Activewear']"));
		mensActiveWearBtn.click();
	}
	
	public void clickWomenActiveWearBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Women Activewear']"));
		womenActiveWearBtn.click();
	}
	
	public void clickSkirtBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Skirt']"));
		skirtBtn.click();
	}
	
	
	public void clickMaterityWearBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Maternity Wear']"));
		materityWearBtn.click();
	}
	
	/**
	 * Clicks the view more / see more products button (after ensuring it's visible/clickable).
	 */
	public void clickViewMoreProductsBtn() {
		// ensure the button is in view then click
		try {
			JavascriptExecutor js = (JavascriptExecutor) Keyword.threadLocal.get();
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", viewMoreProductsBtn);
		} catch (Exception e) {
			// fallback, small scroll
			JavascriptExecutor js = (JavascriptExecutor) Keyword.threadLocal.get();
			js.executeScript("window.scrollBy(0,250);");
		}
		WaitFor.elementToBeClickable(By.xpath("//a[@id='viewMoreButton']"));
		viewMoreProductsBtn.click();
	}
	
	/**
	 * Returns the count of product items currently displayed on the catalogue.
	 */
	public int getProductsCount() {
		List<WebElement> products = Keyword.threadLocal.get().findElements(By.xpath("//div[contains(@class,'catalogueV2Repeater')]/a"));
		return products.size();
	}
	
	/**
	 * Count of products displayed at start (keeps compatibility with existing usages).
	 */
	public int countOfProductsDisplayedAtStart() {
		return getProductsCount();
	}
	
	/**
	 * After clicking view more, wait until number of product items is greater than initialCount, then return the new count.
	 */
	public int countOfProductsAfterViewMoreClick(int initialCount) {
		// wait until the number of items is more than initialCount
		WaitFor.presenceOfAllElementLocated(By.xpath("//div[contains(@class,'catalogueV2Repeater')]/a"), initialCount);
		return getProductsCount();
	}
	
	public void clickOnFirstProduct() {
		List<WebElement> products = Keyword.threadLocal.get().findElements(By.xpath("//div[contains(@class,'catalogueV2Repeater')]/a"));
		if (!products.isEmpty()) {
			products.get(0).click();
		}
	}
	
	public String captureFirstProductDescription() {
		WaitFor.elementToBeVisible(By.xpath("(//div[@class='catalogueV2textBlock'])[1]/div[1]"));
		return firstProductDescription.getText().trim();
	}
	
	public double captureFirstProductPrice() {
		WaitFor.elementToBeVisible(By.xpath("(//div[@class='catalogueV2textBlock'])[1]/div[2]"));
		String price =  firstProductPrice.getText();
		//int priceValue = Integer.parseDouble(price.replaceAll("[^0-9]", ""));
		double priceValue = Double.parseDouble(price.replaceAll("[^0-9.]", ""));
		return priceValue;
	}
	

	public void scrollDownToViewMoreProductsBtn() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) Keyword.threadLocal.get();
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", viewMoreProductsBtn);
		} catch (Exception e) {
			// fallback small scroll
			JavascriptExecutor js = (JavascriptExecutor) Keyword.threadLocal.get();
			js.executeScript("window.scrollBy(0,250);");
		}
	}
	
	
	public void searchForProduct(String productName) {
		WaitFor.elementToBeVisible(By.xpath("//input[@id='search-input']"));
		searchInputField.clear();
		searchInputField.sendKeys(productName);		
	}
	
	public void clearSearchInput() {
		WaitFor.elementToBeVisible(By.xpath("//input[@id='search-input']"));
		searchInputField.clear();
	}
	
	public void clickSearchBtn() {
		WaitFor.elementToBeClickable(By.xpath("//button[@id='search_btn']"));
		searchBtn.click();
	}
	
	public String getInvalidSearchMessage() {
		WaitFor.elementToBeVisible(By.xpath("//div[@class='CatalogueV2Design']/div[1]/h4"));
		return invalidSearchMessage.getText();
	}
	
	public String getSpecialCharSearchMessage() {
		WaitFor.elementToBeVisible(By.xpath("//font[contains(text(),'sorry')]"));
		return specialCharSearchMessage.getText();
	}
	
	public List<String> getSearchAutoSuggestions() {
		WaitFor.presenceOfAllElementLocated(By.xpath("//ul[@id='suggestions-dropdown']/li"), 0);
		List<WebElement> autoSuggestions = searchAutoSuggestions;
		return autoSuggestions.stream().map(WebElement::getText).toList();
	}
	
	public void clickKaprukaLogo() {
		WaitFor.elementToBeClickable(By.xpath("//div[@class='logo_wrapper_block']/a[1]"));
		kaprukaLogo.click();
	}
	
	/* public String imgSourceFirstProduct() {
		String src=null;
		WaitFor.presenceOfAllElementLocated(By.xpath("//div[contains(@class,'catalogueV2Repeater')]/a"), getProductsCount());;
		List<WebElement> products = productDisplayed;
		if (!products.isEmpty()) {
			src = products.get(0).getAttribute("src");
		}
		return src;
	} */
	
	
}