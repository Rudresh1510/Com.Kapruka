package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "classpath:FeaturesFiles",
    glue = {"com.kapruka"},
    tags = "@smoke",
    plugin = {
    		"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
            },
    monochrome = true,
    dryRun = true
)
public class Runner extends AbstractTestNGCucumberTests {


}
