package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static final ThreadLocal<WebDriver> driver =	new ThreadLocal<>();

	public static void initializeDriver(String browser, boolean headless){

		WebDriver webDriver;

		switch(browser.toLowerCase()){
		case "chrome":

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			if(headless){
				options.addArguments("--headless=new");
			}

			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			webDriver = new ChromeDriver(options);
			break;

		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefox = 	new FirefoxOptions();

			if(headless){
				firefox.addArguments("--headless");
			}
			webDriver = new FirefoxDriver(firefox);
			break;

		case "edge":

			WebDriverManager.edgedriver().setup();
			EdgeOptions edge =	new EdgeOptions();

			if(headless){
				edge.addArguments("--headless=new");
			}
			webDriver = new EdgeDriver(edge);
			break;


		default:
			throw new IllegalArgumentException("Unsupported browser: "+browser);

		}

		webDriver.manage().deleteAllCookies();
		webDriver.manage().window().maximize();

		driver.set(webDriver);

	}
	
	public static WebDriver getDriver(){
		return driver.get();
	}


	public static void quitDriver(){
		if(driver.get()!=null){
			driver.get().quit();
			driver.remove();
		}

	}

}