Feature: This is the feature file for login page of Kapruka.com
This feature contains positive, negative tests for the Kapruka login page: https://www.kapruka.com/

#Background: Open the login page
#Given The browser is launched, the URL is opened
 
 
# This test case verify that when user enters valid credentials it should be able to login to the application
@smoke
 Scenario: Login with valid credentials
    When User click on Accounts login button
    And User enters valid username and password
    Then User should be logged in successfully
    
 # This test case verify that when user enters invalid Password it should not be able to login to the application
@test @negative
 Scenario: Login with invalid password
    When User click on Accounts login button
    And User enters valid username and invalid password
    Then User should not be logged in and error message should be displayed
    
 # This test case verify that when user enters invalid username it should not be able to login to the application
 @negative   
 Scenario: Login with invalid username
    When User click on Accounts login button
    And User enters invalid username and valid password
    Then User should not be logged in and error message should be displayed
    