package com.kapruka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kapruka.sourcePackage.Keyword;
import com.kapruka.utils.WaitFor;

public class HomePageDashboardPOM {

	@FindBy(xpath = "//div[@class=' hambuger_menu text menu-icon']")
	WebElement allCategoriesBtn;
	@FindBy(xpath = "//li[@class='active_event']")
	WebElement activeEventsBtn;
	@FindBy(xpath = "//span[@class='active-fes-svg']")
	WebElement rushDeliveryBtn;
	@FindBy(xpath ="//img[@alt='Clothing Image']")
	WebElement clothingMenu;
	
	@FindBy(xpath = "//img[@alt='Electronics Image']")
	WebElement electronicsMenu;
	
	{
		PageFactory.initElements(Keyword.threadLocal.get(), this);
	}
	public void clothingMenuToBeClickable() {
		WaitFor.elementToBeClickable(By.xpath("//img[@alt='Clothing Image']"));
	}
	
	public void clickClothingMenu() {
		clothingMenu.click();
	}
	
	public void clickElectronicsMenu() {
		WaitFor.elementToBeClickable(By.xpath("//img[@alt='Electronics Image']"));
		electronicsMenu.click();
	}


}
