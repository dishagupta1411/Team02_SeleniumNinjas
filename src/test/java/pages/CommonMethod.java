package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Passing_Driver;
import utilities.ConfigReader;

/**
 * Base class containing common Selenium utilities.
 * All Page Object classes should extend this class.
 */
public class CommonMethod {

	protected WebDriver driver;
	protected Actions actions;
	protected JavascriptExecutor js;
	protected WebDriverWait wait;
	protected ConfigReader config;

	public CommonMethod(Passing_Driver passdr) throws IOException {

	    this.driver = passdr.getDriver();

	    if(driver == null) {
	        throw new IllegalStateException("WebDriver is null. Driver was not initialized before Page Object creation.");
	    }

	    this.actions = new Actions(driver);
	    this.js = (JavascriptExecutor) driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    this.config = new ConfigReader();

	    PageFactory.initElements(driver, this);
	}

	// ---------- Safe Actions ----------

	protected void safeClick(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	protected void safeClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	protected void safeType(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}

	protected void safeType(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
	}

	protected void safeSendKeys(By locator, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
	}

	// ---------- Getters ----------

	protected String getText(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText().trim();
	}

	protected String getText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText().trim();
	}

	protected String getTitle() {
		return driver.getTitle();
	}

	protected String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	protected String getValidationMessage(By locator) {
		return driver.findElement(locator).getAttribute("validationMessage");
	}

	protected String getAttribute(By locator, String attribute) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getAttribute(attribute);
	}

	// ---------- Waits & Checks ----------

	protected boolean waitForUrlContains(String partialUrl) {
		try {
			return wait.until(ExpectedConditions.urlContains(partialUrl));
		} catch (TimeoutException e) {
			return false;
		}
	}

	protected boolean isElementDisplayed(By locator) {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}
	}

	protected boolean isElementDisplayed(WebElement element) {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}
	}

	protected boolean isElementEnabled(By locator) {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
		} catch (TimeoutException e) {
			return false;
		}
	}

	// ---------- Scrolling helpers ----------

	protected void scrollBy(int yOffset) {
		js.executeScript("window.scrollBy(0, arguments[0]);", yOffset);
	}

	protected void scrollIntoView(By locator) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	protected void scrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	// ---------- Dropdown / Topic helpers ----------

	public void clickOnDropDwnOptions(String option) {
		By optionLocator = By.xpath("//a[@class='dropdown-item'][text()='" + option + "']");
		safeClick(optionLocator);
	}

	public void clickOnTopic(String topicName) {
		scrollBy(400);
		By topicLocator = By.xpath("//a[contains(text(),'" + topicName + "')]");
		safeClick(topicLocator);
	}

	public void clickOnTopicByHref(String href) {
		scrollBy(400);
		By topicLocator = By.xpath("//a[@href='" + href + "']");
		safeClick(topicLocator);
	}
}
