package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import driver.Passing_Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.LoggerUtil;

public class Hooks {

    private WebDriver driver;
    private Passing_Driver passdr;

    public Hooks(Passing_Driver passdr) {
        this.passdr = passdr;
    }

    @Before(order = 0)
    public void setup(Scenario scenario) {

        ConfigReader config = new ConfigReader();

        String browser = config.getProperty("browser");
        boolean headless = Boolean.parseBoolean(
                config.getProperty("headless"));

        DriverFactory.initializeDriver(browser, headless);

        passdr.setDriver(DriverFactory.getDriver());

        driver = passdr.getDriver();

        LoggerUtil.info(
                "Starting Scenario: " + scenario.getName());
    }

    @After(order = 1)
    public void takeScreenshot(Scenario scenario) {

        if (scenario.isFailed() && driver != null) {

            byte[] screenshot =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);

            scenario.attach(
                    screenshot,
                    "image/png",
                    scenario.getName());
        }
    }

    @After(order = 0)
    public void closeBrowser(Scenario scenario) {

        DriverFactory.quitDriver();

        LoggerUtil.info(
                "Scenario completed: " + scenario.getName());
    }
}