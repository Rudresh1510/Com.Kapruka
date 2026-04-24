package com.kapruka.pages;

import java.util.List;

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
	
	@FindBy(xpath = "//span[@class='icon pull-left septr']//*[name()='svg']")
	WebElement cartIcon;
	
	@FindBy(xpath = "//img[@alt='Electronics Image']")
	WebElement electronicsMenu;
	
	@FindBy(xpath = "//div[@class='second_layout']/div/a")
	List<WebElement> allCategoriesList;
	
	@FindBy(xpath = "//div[@class='main_inner_content_v2 top_v2']/div/div[2]/div/div")
	List<WebElement> featuredProductsList;
	
	@FindBy(xpath = "//div[@class='bannerArea']")
	WebElement homePageBanner;
	
	@FindBy(xpath = "//div[@class='main_inner_content_v2 top_v2']/div/div/a")
	WebElement browseAllCategoriesProductsBtn;
	
	@FindBy(xpath = "//div[@class='rebrandCircles']/a")
	List<WebElement> allProductCategoriesOnAllProductsPage;
	
	@FindBy(xpath = "//input[@id='search-input']")
	WebElement searchInput;
	
	@FindBy(xpath = "//button[@id='search_btn']")
	WebElement searchBtn;
	
	@FindBy(xpath= "//div[@class='CatalogueV2Design']/div")
	List<WebElement> productsDisplayedOnSearch;
	
	@FindBy(xpath = "//div[@class='CatalogueV2Design']/div/h4[1]")
	WebElement invalidSearchMessage;
	
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
	
	public void clickCartIcon() {
		WaitFor.elementToBeClickable(By.xpath("//span[@class='icon pull-left septr']//*[name()='svg']"));
		cartIcon.click();
	}
	
	public int countOfAllCategories() {
		WaitFor.presenceOfAllElementLocated(By.xpath("//div[@class='second_layout']/div/a"),0);
		return allCategoriesList.size();
	}
	
	public int countOfFeaturedProducts() {
		WaitFor.presenceOfAllElementLocated(By.xpath("//div[@class='main_inner_content_v2 top_v2']/div/div[2]/div/div"),0);
		return featuredProductsList.size();
	}
	
	public boolean isHomePageBannerDisplayed() {
		WaitFor.elementToBeVisible(By.xpath("//div[@class='bannerArea']"));
		return homePageBanner.isDisplayed();
	}

	public void clickBrowseAllCategoriesProductsBtn() {
		WaitFor.elementToBeClickable(By.xpath("//div[@class='main_inner_content_v2 top_v2']/div/div/a"));
		browseAllCategoriesProductsBtn.click();
	}
	
	public List<WebElement> getAllProductCategoriesOnAllProductsPage() {
		WaitFor.presenceOfAllElementLocated(By.xpath("//div[@class='rebrandCircles']/a"),0);
		return allProductCategoriesOnAllProductsPage;
	}
	
	public void enterSearchKeyword(String keyword) {
		WaitFor.elementToBeVisible(By.xpath("//input[@id='search-input']"));
		searchInput.sendKeys(keyword);
	}
	
	public void clickSearchBtn() {
		WaitFor.elementToBeClickable(By.xpath("//button[@id='search_btn']"));
		searchBtn.click();
	}
	
	public List<WebElement> getProductsDisplayedOnSearch() {
		WaitFor.presenceOfAllElementLocated(By.xpath("//div[@class='CatalogueV2Design']/div"),0);
		return productsDisplayedOnSearch;
	}
	
	public String getInvalidSearchMessage() {
		WaitFor.elementToBeVisible(By.xpath("//div[@class='CatalogueV2Design']/div/h4[1]"));
		return invalidSearchMessage.getText();
	}
	
	
}
