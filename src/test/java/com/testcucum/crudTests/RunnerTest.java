package com.testcucum.crudTests;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//tags = {"@calendarpicker"},
				
		//format = {"pretty","html:target/html/"},
		//features={"src/test/resource"})
				
				features={"src/test/resource/CreatedbTest.feature"})


public class RunnerTest {

	

}