package com.orangeHRM.actiondriver;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangeHRM.base.BaseClass;

public class ActionDriver {

	private WebDriver driver;
	private WebDriverWait wait;

	public ActionDriver(WebDriver driver) {
		this.driver = driver;
		int explicitWait = Integer.parseInt(BaseClass.getProp().getProperty("explicitWait"));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
	}

	// Method to click an element
	public void click(By by) {
		try {
			waitForElementToBeClickable(by);
			driver.findElement(by).click();
		} catch (Exception e) {
			System.out.println("Unable to click element :" + e.getMessage());

		}

	}

	// Method to enter text in an input field
	public void enterText(By by, String value) {
		try {
			waitForElementToBeVisible(by);
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(value);
		} catch (Exception e) {
			System.out.println("Unable to enter the vlue in input box : " + e.getMessage());
		}
	}

	// Metgod to get text from an input field
	public String getText(By by) {
		try {
			waitForElementToBeVisible(by);
			return driver.findElement(by).getText();
		} catch (Exception e) {
			System.out.println("Unable to get the text:" + e.getMessage());
			return " ";
		}
	}

	public boolean compareText(By by, String expectedText) {
		try {
			waitForElementToBeVisible(by);
			String actualText = driver.findElement(by).getText();
			if (expectedText.equals(actualText)) {
				System.out.println("Text are Matching: " + actualText + " equals " + expectedText);
				return true;
			} else {
				System.out.println("Text are Matching: " + actualText + " not equals " + expectedText);
				return false;
			}
		} catch (Exception e) {
			System.out.println("Unable to compare texts: " + e.getMessage());

		}
		return false;
	}

	// Method to check if an element is diaplayed
	public boolean isDisplayed(By by) {
		try {
			waitForElementToBeVisible(by);
			return driver.findElement(by).isDisplayed();
		} catch (Exception e) {
			System.out.println("Element is not displayed:"+e.getMessage());
			return false;
		}
	}
	
	// Wait for the page to load
			public void waitForPageLoad(int timeOutInSec) {
				try {
					wait.withTimeout(Duration.ofSeconds(timeOutInSec)).until(WebDriver -> ((JavascriptExecutor) WebDriver)
							.executeScript("return document.readyState").equals("complete"));
					System.out.println("Page loaded successfully.");
				} catch (Exception e) {
					System.out.println("Page did not load within " + timeOutInSec + " seconds. Exception: " + e.getMessage());
				}
			}
	
	// Scroll to an element 
		public void scrollToElement(By by) {
			try {
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement element = driver.findElement(by);
				js.executeScript("arguments[0].scrollIntoView(true);", element);
			} catch (Exception e) {
				
				System.out.println("Unable to locate element:" + e.getMessage());
			}
		}

	// Wait for element to be clickable
	private void waitForElementToBeClickable(By by) {
		try {

			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {

			System.out.println("Element is not clickable : " + e.getMessage());

		}

	}

	// Wait for Element to be Visible
	private void waitForElementToBeVisible(By by) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			System.out.println("Element is not visible" + e.getMessage());

		}

	}
	
	

}
