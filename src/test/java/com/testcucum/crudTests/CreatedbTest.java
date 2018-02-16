package com.testcucum.crudTests;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatedbTest {

	public WebDriver driver;
		
	@Given("^open webapp chrome set \"(.*?)\" and \"(.*?)\"$")
	public void open_webapp_chrome_set_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty(arg1,arg2);
		driver  = new ChromeDriver();
		
		driver.get("http://computer-database.herokuapp.com/computers");
	}

	@When("^User click on add new computer button$")
	public void user_click_on_add_new_computer_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Addbutton = driver.findElement(By.id("add"));
    	Addbutton.click();
	}

	@When("^User enters ABC as name of computer$")
	public void user_enters_ABC_as_name_of_computer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		WebElement CName = driver.findElement(By.id("name"));
		System.out.println(CName);
		CName.sendKeys("ABC");     
	    Boolean isPresent = driver.findElements(By.xpath("//div[contains(@class,'clearfix error')]")).size() > 0;
		System.out.println("The error class is not present");
		Assert.assertEquals(isPresent , false);
		//This is to show that this error class only exists when field has errors
	}
		

	@When("^Enters a date to introduced field \"(.*?)\"$")
	public void enters_a_date_to_introduced_field(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement IntroduceDate = driver.findElement(By.id("introduced"));
		IntroduceDate.sendKeys(arg1);
	}

	@When("^Enters \"(.*?)\" to discontinued field$")
	public void enters_to_discontinued_field(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement DiscontinuedDate = driver.findElement(By.id("discontinued"));
		DiscontinuedDate.sendKeys(arg1);
	}

	@When("^chooses a company from drop down$")
	public void chooses_a_company_from_drop_down() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Select dropdown = new Select(driver.findElement(By.id("company")));
		dropdown.selectByVisibleText("IBM");
	}

	@When("^click on create this computer$")
	public void click_on_create_this_computer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']")); 
		submitButton.click();
	}

	@Then("^alert message is displayed new computer is created$")
	public void alert_message_is_displayed_new_computer_is_created() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		String expectedMessage = "Done! Computer ABC has been created";
		String message = driver.findElement(By.xpath("//div[contains(@class,'alert-message warning')]")).getText();
		Assert.assertTrue(message.contains(expectedMessage));
		System.out.println(message);
		driver.quit();
	}

	@Given("^open webapp ie set \"(.*?)\" and \"(.*?)\"$")
	public void open_webapp_ie_set_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty(arg1,arg2);
		driver  = new InternetExplorerDriver();
		
		driver.get("http://computer-database.herokuapp.com/computers");
	}

	@Given("^open webapp Mozilla set \"(.*?)\" and \"(.*?)\"$")
	public void open_webapp_Mozilla_set_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty(arg1, arg2);
		driver = new FirefoxDriver();
		driver.get("http://computer-database.herokuapp.com/computers");
		
	}

	@When("^User enters no name of computer$")
	public void user_enters_no_name_of_computer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Leave the field Computer as blank");
	    
	}

	@When("^Enters \"(.*?)\" correct format to introduced date$")
	public void enters_correct_format_to_introduced_date(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement IntroduceDate1 = driver.findElement(By.id("introduced"));
		IntroduceDate1.sendKeys(arg1);
	}

	@Then("^No computer is created and name field is highlighted$")
	public void no_computer_is_created_and_name_field_is_highlighted() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	    Boolean isPresent = driver.findElements(By.xpath("//div[contains(@class,'clearfix error')]")).size() > 0;
		System.out.println("Computer Name cannot be empty");
		Assert.assertEquals(isPresent , true);
		driver.quit();
	}

	@When("^User enters robot as name of computer$")
	public void user_enters_robot_as_name_of_computer() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement CName = driver.findElement(By.id("name"));
		CName.sendKeys("robot"); 
	}

	@When("^Enters wrong format \"(.*?)\" in introduced date$")
	public void enters_wrong_format_in_introduced_date(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement IntroduceDate_wrongFormat = driver.findElement(By.id("introduced"));
		IntroduceDate_wrongFormat.sendKeys(arg1);
	}

	@Then("^it highlights the introduced date field$")
	public void it_highlights_the_introduced_date_field() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		    Boolean isPresent = driver.findElements(By.xpath("//div[contains(@class,'clearfix error')]")).size() > 0;
			System.out.println("Wrong format on Introduced date");
			Assert.assertEquals(isPresent , true);
			driver.quit();
	}

}
