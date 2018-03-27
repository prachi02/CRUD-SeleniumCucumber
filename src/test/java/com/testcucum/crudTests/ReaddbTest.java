package com.testcucum.crudTests;

import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReaddbTest {
	
	public WebDriver driver;
	
	@Given("^navigate to application$")
	public void navigate_to_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Psingh\\\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//driver  = new ChromeDriver();
		
		
		File file = new File("driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		
		driver.get("http://computer-database.herokuapp.com/computers");
	}
	
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Given("^Read the first computer in the list$")
	public void read_the_first_computer_in_the_list() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		List<WebElement> firstComputerFound = driver.findElements(By.tagName("a"));
		String readComputerName=firstComputerFound.get(6).getText();
		firstComputerFound.get(6).click();
		System.out.println(readComputerName);
		//Assert.assertEquals(readComputerName,arg1);
	}

	@When("^read the data of that computer$")
	public void read_the_data_of_that_computer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//Read Name
		String computerName = driver.findElement(By.id("name")).getAttribute("value");
		System.out.println("Computer Name is"+" "+computerName);
		//Read Introduced Date
		String introducedDate = driver.findElement(By.id("introduced")).getAttribute("value");
		System.out.println("IntroducedDate is"+" "+ introducedDate);
		//Read Discontinued Date
		String discontinuedDate = driver.findElement(By.id("discontinued")).getAttribute("value");
		System.out.println("DiscontinuedDate is"+" "+ discontinuedDate);
		//Read company
		String companyName = driver.findElement(By.id("company")).getAttribute("value");
		System.out.println("Company Name is"+" "+companyName);
		
		//We can have asserts if we want to match it to a particular data
	   
	}

	@Then("^Go back to main page$")
	public void go_back_to_main_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//driver.findElement(By.xpath("//a[contains(@href='computers')]")).click();
				//WebElement cm = driver.findElement(By.xpath("//a[contains(@href,'/computers/')]"));
				//driver.findElement(By.tagName("a")).click();
		
		List<WebElement> cancelButton = driver.findElements(By.tagName("a"));
		String cancelFound=cancelButton.get(1).getText();
		cancelButton.get(1).click();
		System.out.println(cancelFound);
		
	}



}
