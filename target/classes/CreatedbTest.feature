@regression
Feature: Create

Scenario Outline: Crete a new computer in db
Given open webapp <browser> set <driver> and <property>
When User click on add new computer button	
And  User enters ABC as name of computer
And Enters a date to introduced field "2015-02-02"
And Enters "2017-02-02" to discontinued field
And chooses a company from drop down
And click on create this computer 	
Then alert message is displayed new computer is created

Examples:
    | browser | driver | property |
    |chrome| "webdriver.chrome.driver" |"C:\\Users\\Psingh\\Downloads\\chromedriver_win32\\chromedriver.exe" |
    | Mozilla| "webdriver.gecko.driver" |"C:\\Users\\Psingh\\Downloads\\geckodriver-v0.18.0-win64\\geckodriver.exe"|


Scenario Outline: Create a new computer without name
Given open webapp <browser> set <driver> and <property>
When User click on add new computer button	
And  User enters no name of computer
And Enters "2016-03-03" correct format to introduced date
And chooses a company from drop down
And click on create this computer 	
Then No computer is created and name field is highlighted

Examples:
    | browser | driver | property |
    |chrome| "webdriver.chrome.driver" |"C:\\Users\\Psingh\\Downloads\\chromedriver_win32\\chromedriver.exe" |
    | Mozilla| "webdriver.gecko.driver" |"C:\\Users\\Psingh\\Downloads\\geckodriver-v0.18.0-win64\\geckodriver.exe"|


Scenario Outline: Create a new computer with wrong date format
Given open webapp <browser> set <driver> and <property>
When User click on add new computer button	
And  User enters robot as name of computer
And Enters wrong format "2017/02/04" in introduced date
And chooses a company from drop down
And click on create this computer 	
Then it highlights the introduced date field

Examples:
    | browser | driver | property |
    |chrome| "webdriver.chrome.driver" |"C:\\Users\\Psingh\\Downloads\\chromedriver_win32\\chromedriver.exe" |
    | Mozilla| "webdriver.gecko.driver" |"C:\\Users\\Psingh\\Downloads\\geckodriver-v0.18.0-win64\\geckodriver.exe"|
