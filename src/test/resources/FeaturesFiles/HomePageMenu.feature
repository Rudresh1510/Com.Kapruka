Feature: This is the feature file for HomePage Menu of Kapruka.com
This feature contains positive, negative tests for the Kapruka HomePage Menu: https://www.kapruka.com

#Background: Open the login page
#Given The browser is launched, the URL is opened
 
 
#This test case verify that 20 productCategories are displayed when click on HomePage menu
@smoke
Scenario: Verify that 20 productCategories are displayed when click on HomePage menu
    Then 20 productCategories should be displayed on the HomePage menu page

#This test case verify that 14 featured products are displayed on HomePage Menu
@smoke
Scenario: Verify that 14 featured products are displayed on HomePage Menu    Then 14 featured products should be displayed on the HomePage menu
    
#This test case verify if home page banner is displayed or not
@smoke
Scenario: Verify that banner is displayed on HomePage Menu    Then Home page banner should be displayed on the HomePage menu
    
#This test case verify that when user click on browse all products button of all products category 
#then it should load all the products page along with below specified category of products
@smoke
Scenario: Verify that when user click on browse all products button of all products category then it should load products with below specified category    When User click on browse all products button of all products category    Then All the products page should be loaded along with below specified category of products
        | Clothing |
        | Electronics |
        | Cake Shop |
        | Books |
        
        
#Search for a valid product
#This test case verify that when user enters a valid prodct name and click on search button 
#then it should load the page with the searched product
@smoke
Scenario: Verify that when user enter a valid product name and click on search button then it should load the page with the searched product    When User enter a valid product name in the search box "Shirt"    And User click on homePage search button    Then It should load the page with the searched product "Shirt"
    
    
#Search with invalid keyword
#This test case verify that when user enters a invalid prodct name and click on search button 
#then it should display a messade as "All items in this category are sold out."
@test
Scenario: Verify that when user enter a invalid product name and click on search button then it should display a messade as "All items in this category are sold out."    When User enter a invalid product name in the search box "xyz123invalid"    And User click on homePage search button    Then It should display a messade as "All items in this category are sold out."