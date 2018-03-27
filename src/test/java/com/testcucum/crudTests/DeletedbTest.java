package com.testcucum.crudTests;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeletedbTest {

	
	public WebDriver driver;

	@Given("^navigate to url$")
	public void navigate_to_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Psingh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver  = new ChromeDriver();
		
		driver.get("http://computer-database.herokuapp.com/computers");
	}
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Given("^Search for the computerName \"(.*?)\"$")
	public void search_for_the_computerName(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement searchField = driver.findElement(By.id("searchbox"));
		searchField.sendKeys(arg1);
		WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']")); 
		submitButton.click();
	}

	@Then("^Nothing to displayed message is not shown$")
	public void nothing_to_displayed_message_is_not_shown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Boolean isPresent = driver.findElements(By.className("well")).size() > 0;
		System.out.println("Element is not prsent");
			Assert.assertEquals(isPresent , false);
			//It would fail if the computer doesn't exist
		}
		

	@When("^Click on existing computerName \"(.*?)\"$")
	public void click_on_existing_computerName(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> searchedCompName =driver.findElements(By.tagName("a"));
		String deletedComputerName=searchedCompName.get(6).getText();
		searchedCompName.get(6).click();
		System.out.println(deletedComputerName);
		Assert.assertEquals(deletedComputerName,arg1);
		
		
	}

	@When("^Delete this computer$")
	public void delete_this_computer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//driver.FindElement(By.cssSelector(input[type='submit'][value='Delete this computer']));
		driver.findElement(By.xpath("//input[@value='Delete this computer']")).click();
		 
	}

	@Then("^An alert message says Done!  Computer has been deleted$")
	public void an_alert_message_says_Done_Computer_has_been_deleted() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement alertMessage = driver.findElement(By.tagName("strong"));
		System.out.println(alertMessage.getText());
		
	}


}
