package utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionUtil {
	
	// FIX: Initialize the SoftAssert right here so it is never null!
	private static SoftAssert softAssert = new SoftAssert(); 

    // Hard Assert (Use this for critical checks like Page Titles)
	public static void assertEquals(String actual, String expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public static void assertTrue(boolean condition, String message) {
		Assert.assertTrue(condition, message);
	}
	
    // Soft Assert (Use this for minor UI checks, like verifying 5 different font colors)
	public static void softAssertEquals(String actual, String expected, String message) {
		softAssert.assertEquals(actual, expected, message);
	}
	
	public static void softAssertTrue(boolean condition, String message) {
		softAssert.assertTrue(condition, message);		
	}
	
	public static void softAssertFalse(boolean condition, String message) {
		softAssert.assertFalse(condition, message);		
	}
	
	public static void softAssertAll() {
		softAssert.assertAll();
	}
	
	public static void verifyAssertTextContains(String actual, String expectedString, String message) {
		if(!actual.contains(expectedString)) {
			Assert.fail(message + " Actual value is : ["+ actual + "], Expected to contain :"+ expectedString);
		}
	}
	
	public static void isElementDisplayed(WebElement element) {
		Assert.assertTrue(element.isDisplayed(), "WebElement is not displayed on the UI");
	}
}