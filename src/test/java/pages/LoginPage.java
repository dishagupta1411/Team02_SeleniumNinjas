package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import driver.Passing_Driver;
import org.openqa.selenium.Keys;


public class LoginPage extends CommonMethod {
	
	

    public LoginPage(Passing_Driver passdr) throws IOException {
        super(passdr);
    }

    // ============================================================
    // LOGIN PAGE ELEMENTS
    // ============================================================

    // ---------- Logo / Instruction ----------

    @FindBy(xpath = "//img[@src='assets/img/LMS-logo.jpg']")
    private WebElement applicationLogo;

    @FindBy(xpath = "//p[normalize-space()='Please login to LMS application']")
    private WebElement loginInstruction;

    //FOR HOME PAGE VERIFICATION
    @FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
    private WebElement applicationTitle;

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

    public boolean isApplicationBrandingDisplayed() {
        return applicationLogo.isDisplayed();
    }

    public boolean isLoginInstructionDisplayed() {
        return loginInstruction.isDisplayed();
    }
    
    public boolean areInputFieldsDisplayed() {
        return userName.isDisplayed() && password.isDisplayed();
    }
    
    //FOR LANDING ON HOMEPAGE
    public boolean isApplicationTitleDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOf(applicationTitle)
        ).isDisplayed();
    }


    // ---------- Username ----------

    public boolean isUserNameLabelDisplayed() {
        return userNameLabel.isDisplayed();
    }

    public boolean isUserNameRequiredMarkDisplayed() {
        return userNameRequiredMark.isDisplayed();
    }

    public String getUserNameErrorMessage() {

        wait.until(ExpectedConditions.visibilityOf(userNameError));

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

        wait.until(ExpectedConditions.visibilityOf(passwordError));

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

        wait.until(ExpectedConditions.visibilityOf(adminOption));

        return adminOption.isDisplayed()
                && staffOption.isDisplayed()
                && studentOption.isDisplayed();
    }
    
    public String getRoleErrorMessage() {

        wait.until(ExpectedConditions.visibilityOf(roleError));

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
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
    
   // private boolean applicationErrorReceived = false;
    
    public void navigateToInvalidApplication() {
        driver.get(
            "https://lms-frontend-6dcccb9dd0fa-invalid.herokuapp.com/"
        );
    }

    public boolean isApplicationErrorReceived() {
        return !"LMS".equals(driver.getTitle());
    }
    
    
    
    //======== CHECKING FUNCTIONAL SCENARIOS ACTIONS =========
 
    public void enterValidLoginDetails() throws IOException {

        String username =
                excelReader.getData("LoginData", "validLogin", "Username");

        String passwordValue =
                excelReader.getData("LoginData", "validLogin", "Password");

        String role =
                excelReader.getData("LoginData", "validLogin", "Role");

        System.out.println("Username from Excel: " + username);
        System.out.println("Password from Excel: " + passwordValue);
        System.out.println("Role from Excel: " + role);

        enterUsername(username);
        enterPassword(passwordValue);
        selectRole(role);

        System.out.println(
                "Username entered: " + userName.getAttribute("value")
        );

        System.out.println(
                "Password entered: " + password.getAttribute("value")
        );
    }
    

    
    public void enterSpecialCharacterUsernameDetails() throws IOException {

        String username =
                excelReader.getData("LoginData", "specialUsername", "Username");

        String passwordValue =
                excelReader.getData("LoginData", "specialUsername", "Password");

        String role =
                excelReader.getData("LoginData", "specialUsername", "Role");

        enterUsername(username);
        enterPassword(passwordValue);
        selectRole(role);
    }
    

    
    public void enterPasswordAndSelectRole() throws IOException {

        String passwordValue =
                excelReader.getData("LoginData", "emptyUsername", "Password");

        String role =
                excelReader.getData("LoginData", "emptyUsername", "Role");

        enterPassword(passwordValue);
        selectRole(role);
        clickLoginButton();
    }
    
    public void enterUsernameAndSelectRole() throws IOException {

        String username = excelReader.getData(
                "LoginData",
                "emptyPassword",
                "Username"
        );

        String role = excelReader.getData(
                "LoginData",
                "emptyPassword",
                "Role"
        );

        enterUsername(username);
        selectRole(role);
        clickLoginButton();
    }
    
    public void enterValidUsernameRoleWrongPassword() throws IOException {

        String username = excelReader.getData(
                "LoginData",
                "wrongPassword",
                "Username"
        );

        String passwordValue = excelReader.getData(
                "LoginData",
                "wrongPassword",
                "Password"
        );

        String role = excelReader.getData(
                "LoginData",
                "wrongPassword",
                "Role"
        );

        enterUsername(username);
        enterPassword(passwordValue);
        selectRole(role);
        clickLoginButton();
    }
    
    public void enterValidUsernameAndPasswordWithoutRole() throws IOException {

        String username = excelReader.getData(
                "LoginData",
                "noRole",
                "Username"
        );

        String passwordValue = excelReader.getData(
                "LoginData",
                "noRole",
                "Password"
        );

        enterUsername(username);
        enterPassword(passwordValue);

        // Intentionally do NOT select a role
        clickLoginButton();
    }
    
    public void enterValidUsernamePasswordInvalidRole() throws IOException {

        String username = excelReader.getData(
                "LoginData",
                "invalidRole",
                "Username"
        );

        String passwordValue = excelReader.getData(
                "LoginData",
                "invalidRole",
                "Password"
        );

        String role = excelReader.getData(
                "LoginData",
                "invalidRole",
                "Role"
        );

        enterUsername(username);
        enterPassword(passwordValue);
        selectRole(role);
        clickLoginButton();
    }
    
    public void enterValidLoginDetailsUsingKeyboard() throws IOException {

        String username = excelReader.getData(
                "LoginData", "validLogin", "Username");

        String passwordValue = excelReader.getData(
                "LoginData", "validLogin", "Password");

        enterUsername(username);

        actions.sendKeys(Keys.TAB)
               .sendKeys(passwordValue)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.ENTER)
               .perform();

        // At this point role dropdown should have keyboard focus.
        actions.sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.ARROW_UP)
        
               .sendKeys(Keys.ENTER)
               .perform();

        // Move to Login button and submit using keyboard.
        actions.sendKeys(Keys.TAB)
               .sendKeys(Keys.ENTER)
               .perform();
    }
    
    public void clickLoginButtonUsingMouse() {

        actions.moveToElement(loginButton)
               .click()
               .perform();
    }
    
    public void enterValidLoginDetailsUsingMouse() throws IOException {

        String username = excelReader.getData(
                "LoginData", "validLogin", "Username");

        String passwordValue = excelReader.getData(
                "LoginData", "validLogin", "Password");

        String role = excelReader.getData(
                "LoginData", "validLogin", "Role");

        enterUsername(username);
        enterPassword(passwordValue);
        selectRole(role);
    }
    
         
}