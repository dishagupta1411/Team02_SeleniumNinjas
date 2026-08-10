package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Passing_Driver;
import utilities.ConfigReader;
import java.net.HttpURLConnection;
import java.net.URL;
import utilities.ExcelReaderFile;

public class CommonMethod {

    protected WebDriver driver;
    protected Actions actions;
    protected JavascriptExecutor js;
    protected WebDriverWait wait;
    protected ConfigReader config;
    protected ExcelReaderFile excelReader;

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
        String excelPath = config.getProperty("loginTestDataPath");
        this.excelReader = new ExcelReaderFile(excelPath);


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
    
    public String getPageTitle() {
        return driver.getTitle();
    }
    public void navigateToInvalidApplication() {
        driver.get(config.getProperty("baseUrl") + "invalid");
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    public int getHttpResponseCode() {

        try {
            URL url = new URL(config.getProperty("baseUrl"));

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            return connection.getResponseCode();

        } catch (Exception e) {
            throw new RuntimeException("Unable to get HTTP response", e);
        }
    }
    
    public void loginAsAdmin() throws IOException {

        String username =
                excelReader.getData("LoginData", "validLogin", "Username");

        String password =
                excelReader.getData("LoginData", "validLogin", "Password");

        String role =
                excelReader.getData("LoginData", "validLogin", "Role");

        // Username
        WebElement usernameField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("username")));

        safeType(usernameField, username);

        // Password
        WebElement passwordField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("password")));

        safeType(passwordField, password);

        // Role dropdown
        WebElement roleDropdown =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//mat-select[@formcontrolname='roleSelected']")));

        safeClick(roleDropdown);

        // Select role
        WebElement roleOption =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(@class,'mat-option-text') and normalize-space()='"
                                + role + "']")));

        safeClick(roleOption);

        // Login button
        WebElement loginButton =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.id("login")));

        safeClick(loginButton);
    }
    
    public void clickOnButton(WebElement element) {
	    try {
	         JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", element);
	    } catch (Exception e) {
	        System.out.println("Failed to click element: " + e.getMessage());
	    }
	
}
    
}