@regression
Feature: Delete


Scenario: Delete an existing computer
Given navigate to url 
Given Search for the computerName "ASCI Red"
Then Nothing to displayed message is not shown
When Click on existing computerName "ASCI Red"
And Delete this computer 
Then An alert message says Done!  Computer has been deleted
