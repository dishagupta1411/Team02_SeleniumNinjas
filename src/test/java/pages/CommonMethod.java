package pages;

import java.io.IOException;
import java.time.Duration;

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

public class CommonMethod {

    protected WebDriver driver;
    protected Actions actions;
    protected JavascriptExecutor js;
    protected WebDriverWait wait;
    protected ConfigReader config;

    public CommonMethod(Passing_Driver passdr) throws IOException {

        this.driver = passdr.getDriver();

        if (driver == null) {
            throw new IllegalStateException(
                "WebDriver is null. Driver was not initialized."
            );
        }


	    this.actions = new Actions(driver);
	    this.js = (JavascriptExecutor) driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    this.config = new ConfigReader();
	    PageFactory.initElements(driver, this);
	}

    public void navigateToApplication() {
        driver.get(config.getProperty("baseUrl"));
    }
    
    protected void safeClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


    protected void safeClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void safeType(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }


    protected String getText(WebElement element) {
        return wait.until(
            ExpectedConditions.visibilityOf(element)
        ).getText().trim();
    }

    protected boolean isDisplayed(WebElement element) {
        return wait.until(
            ExpectedConditions.visibilityOf(element)
        ).isDisplayed();
    }

	protected boolean waitForUrlContains(String partialUrl) {
        try {
            return wait.until(ExpectedConditions.urlContains(partialUrl));
        } catch (TimeoutException e) {
            return false;
        }
    }

	
}
