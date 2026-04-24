package com.kapruka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kapruka.sourcePackage.Keyword;
import com.kapruka.utils.WaitFor;

/**
 * Page Object Model for the View Cart page. This class should contain
 * WebElements and methods specific to the View Cart page, such as deleting a
 * product from the cart. WebAddress of this page is
 * https://www.kapruka.com/shops/checkout/deliveryCartViewPage.jsp
 */

public class ViewCartPagePOM {

	@FindBy(xpath = "//div[@class='contentSwitch']")
	WebElement deleteProductBtn;
	@FindBy(xpath = "//button[@class='keepshopping']")
	WebElement keepShoppingBtn;
	@FindBy(xpath = "//button[@class='checkoutBtn js-checkout']")
	WebElement checkoutBtn;
	@FindBy(xpath = "//div[@class='alert alert-success']")
	WebElement deleteProductMessage;

	@FindBy(xpath = "//span[@class='item-name']")
	WebElement productCount;

	@FindBy(xpath = "//div[@class='shcont']")
	WebElement totalAmount;
	
	@FindBy(xpath= "//span[@class='item-name']")
	WebElement productNameInCart;
	
	@FindBy(xpath = "//span[@class='item-price']")
	WebElement productPriceInCart;
	

	{
		PageFactory.initElements(Keyword.threadLocal.get(), this);
	}

	public void clickDeleteProductBtn() {
		WaitFor.elementToBeClickable(By.xpath("//div[@class='contentSwitch']"));
		deleteProductBtn.click();
	}

	public void clickKeepShoppingBtn() {
		WaitFor.elementToBeClickable(By.xpath("//button[@class='keepshopping']"));
		keepShoppingBtn.click();
	}

	public void clickCheckoutBtn() {
		WaitFor.elementToBeClickable(By.xpath("//button[@class='checkoutBtn js-checkout']"));
		checkoutBtn.click();
	}

	public String getDeletedProductMessage() {
		WaitFor.elementToBeVisible(By.xpath("//div[@class='alert alert-success']"));
		return deleteProductMessage.getText();
	}

	public int getProductQuantity() {
		WaitFor.elementToBeVisible(By.xpath("//span[@class='item-name']"));
		String quantityText = productCount.getText();
		int quantity = Integer.parseInt(quantityText.split(" ")[0]);
		// System.out.println("Product quantity text: " + quantityText); // Debugging
		// statement to check the captured text
		return quantity;
	}

	public double getDisplayedTotal() {
		WaitFor.elementToBeVisible(By.xpath("//div[@class='shcont']"));
		String priceText = totalAmount.getText();

		//String usdPart = priceText.split("\\(")[0]; // "US$38.34 "
		double amount = Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
		return amount;
	}

	public boolean isCheckoutButtonDisplayed() {
		try {
			WaitFor.elementToBeVisible(By.xpath("//button[@class='checkoutBtn js-checkout']"));
			return checkoutBtn.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isCheckoutButtonEnabled() {
		try {
			// WaitFor.elementToBeVisible(By.xpath("//button[@class='checkoutBtn
			// js-checkout']"));
			return checkoutBtn.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isProductPresentInCart() {

		try {
			WaitFor.elementToBeVisible(By.xpath("//span[@class='item-name']"));
			return productCount.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getProductNameInCart() {
		WaitFor.elementToBeVisible(By.xpath("//span[@class='item-name']"));
		return productNameInCart.getText().trim();
	}
	
	
	public int getProductPriceInCart() {
		WaitFor.elementToBeVisible(By.xpath("//span[@class='item-price']"));
		String priceText = productPriceInCart.getText();
		int price = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
		return price;
		//String formatted = String.format("%.2f", value);
	}
	
	
	

}
