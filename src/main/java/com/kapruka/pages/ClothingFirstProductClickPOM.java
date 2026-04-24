package com.kapruka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kapruka.sourcePackage.Keyword;
import com.kapruka.utils.WaitFor;

/**
 * Page Object Model for the Clothing page after clicking on the first product. 
 * This class should contain WebElements and methods specific to the product details after clicking on first product.
 */
public class ClothingFirstProductClickPOM {

	@FindBy (xpath = "//div[@class='blockDelivery imgtags']/h1")
	WebElement productTitle;	
	@FindBy (xpath = "//div[@class='price']/span")
	WebElement productPrice;
	
	@FindBy (xpath = "//button[@id='addtocartbutton']")
	WebElement addToCartBtn;
	
	@FindBy (xpath = "//a[text()='View Cart']")
	WebElement viewCartBtn;
	
	@FindBy(xpath = "//a[@id='increaseQty']")
	WebElement increaseQtyBtn;
	
	@FindBy(xpath = "//a[@id='decreaseQty']")
	WebElement decreaseQtyBtn;
	
	@FindBy(xpath = "//input[@id='quantityInput']")
	WebElement quantityTextbx;
	
	@FindBy(xpath = "//span[@class='new']")
	WebElement availableStock;
	
	@FindBy(xpath = "//img[@class='clickable-image sizeGrab']")
	WebElement productImage; 
	
	@FindBy (xpath = "//div[@class='logo_wrapper_block']/a[1]")
	WebElement kaprukaLogo;
	
	@FindBy(xpath = "//a[@id='continue_shopping_popup']")
	WebElement continueShoppingBtn;
	

	{
		PageFactory.initElements(Keyword.threadLocal.get(), this);
	}
	
	
	public String captureProductDescription() {
		WaitFor.elementToBeVisible(By.xpath("//div[@class='blockDelivery imgtags']/h1"));
		return productTitle.getText();
	}
	
	public double captureProductPrice() {
		WaitFor.elementToBeVisible(By.xpath("//div[@class='price']/span"));
		String productPriceText =  productPrice.getText();
		double priceValue = Double.parseDouble(productPriceText.replaceAll("[^0-9.]", ""));
		return priceValue;
	}
	
	public void clickAddToCartBtn() {
		WaitFor.elementToBeClickable(By.xpath("//button[@id='addtocartbutton']"));
		addToCartBtn.click();
	}

	public void clickViewCartBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[text()='View Cart']"));
		viewCartBtn.click();		
	}
	
	public void clickIncreaseQtyBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@id='increaseQty']"));
		increaseQtyBtn.click();
	}
	
	public void clickDecreaseQtyBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@id='decreaseQty']"));
		decreaseQtyBtn.click();
	}
	
	/* public String srcOfImageProduct() {
		WaitFor.elementToBeVisible(By.xpath("//img[@class='clickable-image sizeGrab']"));
		String src = productImage.getAttribute("src");		
		return src;
	} */
	
	public int getMinQuantityNumber() {
		WaitFor.elementToBeVisible(By.xpath("//input[@id='quantityInput']"));
		String quantity = quantityTextbx.getAttribute("min");
		int quantitynum = Integer.parseInt(quantity);
		return quantitynum;		
	}
	
	public int getMAxQuantityNumber() {
		WaitFor.elementToBeVisible(By.xpath("//input[@id='quantityInput']"));
		String quantity = quantityTextbx.getAttribute("max");
		int quantitynum = Integer.parseInt(quantity);
		return quantitynum;		
	}
	
	public int getAvailableStock() {
		WaitFor.elementToBeVisible(By.xpath("//span[@class='new']"));
		String text = availableStock.getText();
		String number = text.replaceAll("[^0-9]", "");  // removes everything except digits
		int stockAvailable = Integer.parseInt(number);
		return stockAvailable;
	}
	
	public void clickKaprukaLogo() {
		WaitFor.elementToBeClickable(By.xpath("//div[@class='logo_wrapper_block']/a[1]"));
		kaprukaLogo.click();
	}	
	
	public void clickCotinueShoppingButton() {
		WaitFor.elementToBeClickable(By.xpath("//a[@id='continue_shopping_popup']"));
		continueShoppingBtn.click();
	}
	
	
	
	
	
	
	
}
