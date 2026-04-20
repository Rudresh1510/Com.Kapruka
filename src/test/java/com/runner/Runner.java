package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "classpath:LoginFeatures",
    glue = {"com.kapruka"},
    tags = "@smoke",
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true,
    dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {

	
}