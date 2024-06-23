package com.himalaya.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * This class serves as the TestNG runner for executing Cucumber feature files.
 */
@CucumberOptions(
		glue={"classpath:com.himalaya.step_definitions"},
		tags ="@Blog",
		features={"classpath:features/Blog.feature","classpath:features/HerbFinder.feature","classpath:features/AccountDashboard.feature","classpath:features/HomePage.feature"},
		plugin= {"pretty","html:target/site/cucumber-report.html"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}