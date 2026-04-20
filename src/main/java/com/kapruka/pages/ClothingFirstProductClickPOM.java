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

	{
		PageFactory.initElements(Keyword.threadLocal.get(), this);
	}
	
	
	public String captureProductDescription() {
		WaitFor.elementToBeVisible(By.xpath("//div[@class='blockDelivery imgtags']/h1"));
		return productTitle.getText();
	}
	
	public String captureProductPrice() {
		WaitFor.elementToBeVisible(By.xpath("//div[@class='price']/span"));
		return productPrice.getText();
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
	
	
	
	
	
	
}
