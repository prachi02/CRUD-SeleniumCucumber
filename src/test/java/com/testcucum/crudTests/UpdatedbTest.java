package com.testcucum.crudTests;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class UpdatedbTest {
	public WebDriver driver;
	
	@Given("^open webapp app url$")
	public void open_webapp_app_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Psingh\\\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver  = new ChromeDriver();
		
		driver.get("http://computer-database.herokuapp.com/computers");
		
	}
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Given("^Search for computer name \"(.*?)\"$")
	public void search_for_computer_name(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement searchField = driver.findElement(By.id("searchbox"));
		searchField.sendKeys(arg1);
		WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']")); 
		submitButton.click();
	}

	@Then("^Nothing to displayed is not shown$")
	public void nothing_to_displayed_is_not_shown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Boolean isAlertPresent = driver.findElements(By.className("well")).size() > 0;
		Assert.assertEquals(isAlertPresent , false);
		
	}


	@When("^Go to that existing computer$")
	public void go_to_that_existing_computer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> searchedCompName =driver.findElements(By.tagName("a"));
		String deletedComputerName=searchedCompName.get(6).getText();
		searchedCompName.get(6).click();
		System.out.println(deletedComputerName);
		
	}

	@When("^Change the computer name to ABCD$")
	public void change_the_computer_name_to_ABCD() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement ComputerName = driver.findElement(By.id("name"));
		ComputerName.sendKeys(Keys.chord(Keys.CONTROL, "a"), "ABCD");
	}

	@When("^click on Save this computer$")
	public void click_on_Save_this_computer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']")); 
		submitButton.click();
	}

	@Then("^alert message is displayed Computer ABCD has been updated$")
	public void alert_message_is_displayed_Computer_ABCD_has_been_updated() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String expectedMessage = "Done! Computer ABCD has been updated";
		String message = driver.findElement(By.xpath("//div[contains(@class,'alert-message warning')]")).getText();
		Assert.assertTrue(message.contains(expectedMessage));
		System.out.println(message);
		driver.quit();
	}

	@Given("^User wants to update date$")
	public void user_wants_to_update_date() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Update date");
	}
	
	@When("^Find an existing computer in db$")
	public void find_an_existing_computer_in_db() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> searchedCompName =driver.findElements(By.tagName("a"));
		String deletedComputerName=searchedCompName.get(6).getText();
		searchedCompName.get(6).click();
		System.out.println(deletedComputerName);
		//Assert.assertEquals(deletedComputerName,arg1);
	}
	
	@Given("^Search for a new computer name \"(.*?)\"$")
	public void search_for_a_new_computer_name(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement searchField = driver.findElement(By.id("searchbox"));
		searchField.sendKeys(arg1);
		WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']")); 
		submitButton.click();
	}

	@When("^Change the discontinued date to \"(.*?)\"$")
	public void change_the_discontinued_date_to(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement DiscontinuedDate = driver.findElement(By.id("discontinued"));
		DiscontinuedDate.sendKeys(arg1);
	}

	@Then("^the discontinued date field is higlighted$")
	public void the_discontinued_date_field_is_higlighted() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Boolean isClassPresent = driver.findElements(By.xpath("//div[contains(@class,'clearfix error')]")).size() > 0;
		Assert.assertEquals(isClassPresent , true);
		
	}





}
