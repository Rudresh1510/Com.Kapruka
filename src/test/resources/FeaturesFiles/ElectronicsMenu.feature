Feature: This is the feature file for Electronics Menu page of Kapruka.com
This feature contains positive, negative tests for the Kapruka electronics page: https://www.kapruka.com/online/electronics

#Background: Open the login page
#Given The browser is launched, the URL is opened

# This test case verify that when user click on electronics menu it should load the electronics menu page successfully
@smoke
Scenario: Verify that electronics Menu loads successfully when clicked on electronics button
    When User click on Electronics button
    Then User should nevigate to electronics menu

# This test case verify that when user click on electronics menu and Kitchen Appliances 
# it should load the kitchen appliance page successfully
@smoke
Scenario: Verify that Kitchen Appliances page loads successfully when clicked on Kitchen Appliances button
    When User click on Electronics button
    And User click on Kitchen Appliances button
    Then User should nevigate to Kitchen Appliances page

# This test case verify that when user click on electronics menu and then 30 products should be displayed
@smoke
Scenario: Verify that 30 products are displayed when click on electronics menu
    When User click on Electronics button
    Then 30 products should be displayed on the electronics menu page
    
    