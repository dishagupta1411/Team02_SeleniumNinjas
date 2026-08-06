package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Passing_Driver;

/**
 * Page Object for the Manage Program page.
 * Extends CommonMethod to reuse common Selenium utilities.
 */
public class ProgramPage extends CommonMethod {
	
		public ProgramPage(Passing_Driver passdr) throws IOException {
		super(passdr); // initializes driver, wait, actions, js, config
	}
}
