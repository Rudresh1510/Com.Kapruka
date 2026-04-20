package com.kapruka.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kapruka.sourcePackage.Keyword;
import com.kapruka.utils.WaitFor;

public class ElectronicsPOM {

	@FindBy(xpath = "//a[@title='Shop For Kitchen Appliances b(555)b']/span")
	WebElement kitchenAppliancesBtn;
	
	@FindBy(xpath = "//div[@class='catalogueV2Repeater ']")
	WebElement productList;
	
	{
		PageFactory.initElements(Keyword.threadLocal.get(), this);
	}
	
	public void clickKitchenAppliancesBtn() {
		WaitFor.elementToBeClickable(By.xpath("//a[@title='Shop For Kitchen Appliances b(555)b']/span"));
		kitchenAppliancesBtn.click();
	}
	
	public int countOfProductsDisplayedAtStart() {
		WaitFor.elementToBeVisible(By.xpath("//div[@class='catalogueV2Repeater ']"));
		List<WebElement> products = Keyword.threadLocal.get().findElements(By.xpath("//div[@class='catalogueV2Repeater ']"));
		if (products != null) {
			return products.size();
		}
		return 0;
		
	}
	
	
}
