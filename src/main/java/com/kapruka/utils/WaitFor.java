package com.kapruka.utils;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kapruka.sourcePackage.Keyword;

/**
 * Utility wait helpers. Create a new WebDriverWait per call so it always uses the current thread's driver.
 */
public class WaitFor {

    private static WebDriverWait newWait() {
    	if (Keyword.getDriver() == null) {
			throw new IllegalStateException("WebDriver is not initialized. Call openBrowser() before using waits.");
		}
        WebDriverWait wait = new WebDriverWait(Keyword.getDriver(), Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }

    private WaitFor() {
        // prevent instantiation
    }

    public static void elementToBeVisible(By element) {
        newWait().until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void elementToBeClickable(By element) {
        newWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void stalenessOfElement(WebElement element) {
        newWait().until(ExpectedConditions.stalenessOf(element));
    }

    public static void presenceOfAllElementLocated(By element, int initialCount) {
		newWait().until(ExpectedConditions.numberOfElementsToBeMoreThan(element,initialCount));
		//newWait().until(ExpectedConditions.presenceOfElementLocated(element));
	}
}	