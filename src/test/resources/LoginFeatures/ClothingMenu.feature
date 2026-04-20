Feature: This is the feature file for Clothing Menu page of Kapruka.com
This feature contains positive, negative tests for the Kapruka clothing page: https://www.kapruka.com/online/clothing

#Background: Open the login page
#Given The browser is launched, the URL is opened
 
 
# This test case verify that when user click on clothing menu it should load the clothing menu page successfully
@smoke
 Scenario: Verify that cloting Menu loads successfully when clicked on clothing button
    When User click on Clothing button
    Then User should nevigate to clothing menu


# This test case verify that when user click on clothing menu and then Mens button it should load the clothing menu page for mens
@smoke
 Scenario: Verify that Men cloting menu loads successfully when clicked on Men clothing button
    When User click on Clothing button
    And User click on Men clothing button
    Then User should nevigate to men clothing menu
    
# This test case verify that when user click on clothing menu and then click on See More Products button it should load more products
@smoke
Scenario: Verify that more products are loaded when click on See More Products button
    When User click on Clothing button
    And User captures the number of products displayed initially
    And User click on See More Products button
    Then More products should be loaded on the clothing menu page
     
 # This test case verify that when user click on clothing menu and then click on a product then the product details page should be loaded and the product name and price should be accurate
 @smoke
 Scenario: Verify that product details are accurate when click on a product
    When User click on Clothing button
    And User captures the name and price of a product
    And User click on a product
    Then The product details page should be loaded with accurate product name and price
    
 # This test case verify that when user click on clothing menu, a product and then click on Add to Cart button the product should be added to the cart successfully
 @smoke
 Scenario: Verify that user can add a product to the cart successfully
    When User click on Clothing button
    And User click on a product
    And User click on Add to Cart button
    Then The product should be added to the cart successfully
    

 # This test case verify that when user click on clothing menu, a product and then click on Add to Cart button the product should be added to the cart successfully 
 # and then when user click on delete button the product should be removed from the cart
 
 @smoke
 Scenario: Verify that user can delete a product from the cart successfully
    When User click on Clothing button
    And User click on a product
    And User click on Add to Cart button
    And User click on Delete button for the added product
    Then The product should be removed from the cart successfully
    
  
  # This test case verify that when user click on clothing menu, a product and then click on Add to Cart button the product should be added to the cart successfully
  # and then when user click on Keep Shopping button the user should be navigated to the clothing menu page successfully
  @smoke
  Scenario: Verify that user can navigate to clothing menu page successfully after clicking on Keep Shopping button
    When User click on Clothing button
    And User click on a product
    And User click on Add to Cart button
    And User click on Keep Shopping button
    Then User should be navigated to the Home Page successfully
    
   # This test case verify that when user click on clothing menu, a product and then click on Add to Cart button the product should be added to the cart successfully
   # and then when user click on Checkout button the user should be navigated to the checkout page successfully
   @smoke
   Scenario: Verify that user can navigate to checkout page successfully after clicking on Checkout button
    When User click on Clothing button
    And User click on a product
    And User click on Add to Cart button
    And User click on Checkout button
    Then User should be navigated to the checkout page successfully
   
   # This test case verify that when user click on clothing menu, a product and then click on quantity increment and 
   # click Add to Cart button the product should be added to the cart with the updated quantity successfully
   @smoke
   Scenario: Verify that user can update the quantity of a product and add to cart successfully
    When User click on Clothing button
    And User click on a product
    And User click on quantity increment button
    And User click on Add to Cart button
    Then The product should be added to the cart with the updated quantity successfully
    
   #Verify cart total calculation 
   # This test case verify that when user click on clothing menu, a product and then click on quantity increment and
   # click Add to Cart button the product should be updated in the cart with the correct total price based on the quantity
   @smoke
   Scenario: Verify that cart total is calculated correctly based on the quantity of the product added to the cart
    When User click on Clothing button
    And User captures the name and price of a product
    And User click on a product
    And User click on quantity increment button
    And User click on Add to Cart button
    Then The cart total should be calculated correctly based on the quantity of the product added to the cart
    
    #Checkout with empty cart
    # This test case verify that when user click on clothing menu, a product and
    # click Add to Cart button the product should be updated in the cart, then when user click on delete button 
    #the product should be removed from the cart and then checkout button should be disabled and user should not be able to navigate to checkout page
    #@test
    #Scenario: Verify that user cannot navigate to checkout page with an empty cart
    #When User click on Clothing button
    #And User click on a product
    #And User click on Add to Cart button
    #And User click on Delete button for the added product
    #Then The cart should be empty and checkout button should be disabled and user should not be able to navigate to checkout page
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    