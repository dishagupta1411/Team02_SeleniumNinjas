package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Passing_Driver;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(Passing_Driver passdr) {

        this.driver = passdr.getDriver();

        PageFactory.initElements(driver, this);

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    // ============================================================
    // LOGIN PAGE ELEMENTS
    // ============================================================

    // ---------- Logo / Instruction ----------

    @FindBy(xpath = "//img[@src='assets/img/LMS-logo.jpg']")
    private WebElement applicationLogo;

    @FindBy(xpath = "//p[normalize-space()='Please login to LMS application']")
    private WebElement loginInstruction;


    // ---------- Username ----------

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(xpath = "//label[@for='username']//span[normalize-space()='User']")
    private WebElement userNameLabel;

    @FindBy(xpath = "//label[@for='username']//span[contains(@class,'mat-placeholder-required')]")
    private WebElement userNameRequiredMark;

    @FindBy(xpath = "//mat-error[normalize-space()='Please enter your user name']")
    private WebElement userNameError;


    // ---------- Password ----------

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//label[@for='password']//span[normalize-space()='Password']")
    private WebElement passwordLabel;

    @FindBy(xpath = "//label[@for='password']//span[contains(@class,'mat-placeholder-required')]")
    private WebElement passwordRequiredMark;
    
    @FindBy(xpath = "//mat-error[normalize-space()='Please enter your password']")
    private WebElement passwordError;

 // ---------- Role Dropdown ----------

    @FindBy(xpath = "//mat-select[@formcontrolname='roleSelected']")
    private WebElement roleDropdown;

    @FindBy(xpath = "//mat-select[@formcontrolname='roleSelected']//span[contains(@class,'mat-select-placeholder')]")
    private WebElement rolePlaceholder;

    @FindBy(xpath = "//span[contains(@class,'mat-option-text') and normalize-space()='Admin']")
    private WebElement adminOption;

    @FindBy(xpath = "//span[contains(@class,'mat-option-text') and normalize-space()='Staff']")
    private WebElement staffOption;

    @FindBy(xpath = "//span[contains(@class,'mat-option-text') and normalize-space()='Student']")
    private WebElement studentOption;
    
    @FindBy(xpath = "//mat-error[normalize-space()='Please select your Role']")
    private WebElement roleError;
    
 // ---------- Login Error ----------

    @FindBy(id = "errormessage")
    private WebElement invalidLoginError;
    
 // ---------- Login Form ----------

    @FindBy(css = "div.signin-content")
    private WebElement loginContainer;
    
    @FindBy(xpath = "//mat-select[@formcontrolname='roleSelected']/following-sibling::span[contains(@class,'mat-form-field-label-wrapper')]//span[normalize-space()='Select the role']")
    private WebElement roleLabel;


    // ---------- Login Button ----------
    @FindBy(id = "login")
    private WebElement loginButton;

//    @FindBy(xpath = "//span[contains(@class,'mat-button-wrapper') and normalize-space()='Login']")
//    private WebElement loginButton;
    
    
    

    // ============================================================
    // LOGIN PAGE VERIFICATIONS
    // ============================================================

    // ---------- Logo / Instruction ----------

    public boolean isApplicationLogoDisplayed() {
        return applicationLogo.isDisplayed();
    }

    public boolean isLoginInstructionDisplayed() {
        return loginInstruction.isDisplayed();
    }
    
    public boolean areInputFieldsDisplayed() {
        return userName.isDisplayed() && password.isDisplayed();
    }


    // ---------- Username ----------

    public boolean isUserNameLabelDisplayed() {
        return userNameLabel.isDisplayed();
    }

    public boolean isUserNameRequiredMarkDisplayed() {
        return userNameRequiredMark.isDisplayed();
    }

    public String getUserNameErrorMessage() {
        return userNameError.getText().trim();
    }


    // ---------- Password ----------

    public boolean isPasswordLabelDisplayed() {
        return passwordLabel.isDisplayed();
    }

    public boolean isPasswordRequiredMarkDisplayed() {
        return passwordRequiredMark.isDisplayed();
    }
    
    public String getPasswordErrorMessage() {
        return passwordError.getText().trim();
    }
    
 // ---------- Role Dropdown ----------

    public boolean isRoleDropdownDisplayed() {
        return roleDropdown.isDisplayed();
    }

    public String getRolePlaceholderText() {
        return rolePlaceholder.getText().trim();
    }

    public boolean areRoleOptionsDisplayed() {
        return adminOption.isDisplayed()
                && staffOption.isDisplayed()
                && studentOption.isDisplayed();
    }
    
    public String getRoleErrorMessage() {
        return roleError.getText().trim();
    }
    
 // ---------- Login Error ----------

    public String getInvalidLoginErrorMessage() {
        return invalidLoginError.getText().trim();
    }


    // ---------- Login Button ----------

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
    
    // ----------- Login Form ------------------
    
    public boolean isLoginFormCentered() {

        int windowWidth = driver.manage().window().getSize().getWidth();

        int elementX = loginContainer.getLocation().getX();
        int elementWidth = loginContainer.getSize().getWidth();

        int elementCenter = elementX + (elementWidth / 2);
        int windowCenter = windowWidth / 2;

        return Math.abs(elementCenter - windowCenter) <= 20;
    }
    
    public boolean areInputLabelsLeftAligned() {

        int usernameX = userNameLabel.getLocation().getX();
        int passwordX = passwordLabel.getLocation().getX();
        int roleX = roleLabel.getLocation().getX();

        return Math.abs(usernameX - passwordX) <= 5
                && Math.abs(passwordX - roleX) <= 5;
    }
    
    public String getUserNameLabelColor() {
        return userNameLabel.getCssValue("color");
    }

    public String getPasswordLabelColor() {
        return passwordLabel.getCssValue("color");
    }


    // ============================================================
    // LOGIN PAGE ACTIONS
    // ============================================================

    public void enterUsername(String username) {
        userName.clear();
        userName.sendKeys(username);
    }

    public void enterPassword(String passwordValue) {
        password.clear();
        password.sendKeys(passwordValue);
    }
    public void clickRoleDropdown() {
        roleDropdown.click();
    }
    
    public void selectRole(String role) {

        clickRoleDropdown();

        switch (role.trim().toLowerCase()) {

            case "admin":
                adminOption.click();
                break;

            case "staff":
                staffOption.click();
                break;

            case "student":
                studentOption.click();
                break;

            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
    
    public void clickLoginButton() {
        loginButton.click();
    }
}