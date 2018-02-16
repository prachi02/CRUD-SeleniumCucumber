@regression
Feature: Read


Scenario: Read data of an existing computer
Given navigate to application
Given Read the first computer in the list
When read the data of that computer
Then Go back to main page
