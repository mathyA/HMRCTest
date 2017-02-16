package com.hotel.test.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber-html-report", "json:target/report_example.json"}, 
		glue = { "com.hotel.test.steps" },
		features = { "classpath:basic/" }
		,monochrome=true
		//,dryRun=true
				
)
public class CreateDeletEntryFeature {
	//This is just a runner
	
}
