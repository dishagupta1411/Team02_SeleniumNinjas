package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/LMS_Selenium.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, // reporting
																										// purpose
		monochrome = false, // console output color
		tags = "", features = { "src/test/resources/features/program.feature" }, // location of feature files
		glue = { "stepDefinitions", "hooks" }) // location of step definition files

public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}