@regression
Feature: Update

Background: computer exists in db
Given open webapp app url 


Scenario: Update an existing computer name

Given Search for computer name "APEXCV"
Then Nothing to displayed is not shown
When Go to that existing computer 
And Change the computer name to APEXCVW
And click on Save this computer
Then alert message is displayed Computer APEXCVW has been updated


Scenario: Update the discontinued date to wrong format

Given Search for a new computer name "ASCI Purple"
Then Nothing to displayed is not shown
When Find an existing computer in db 
And Change the discontinued date to "1/2/3"
And click on Save this computer
Then the discontinued date field is higlighted
