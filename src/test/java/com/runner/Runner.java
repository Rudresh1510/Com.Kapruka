
package com.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "classpath:FeaturesFiles",
    glue = {"com.kapruka"},
    tags = "@smoke",
    plugin = {
    		"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
            },
    dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {

    /**
     * Enable parallel execution of Cucumber scenarios when running via TestNG.
     * We override the scenarios data provider and mark it parallel = true.
     */
    @Override
    @DataProvider(parallel = false) // Set to true to enable parallel execution
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
