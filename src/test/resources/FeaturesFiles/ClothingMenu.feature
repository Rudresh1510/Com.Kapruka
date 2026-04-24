Feature: This is the feature file for Clothing Menu page of Kapruka.com
This feature contains positive, negative tests for the Kapruka clothing page: https://www.kapruka.com/online/clothing

#Background: Open the login page
#Given The browser is launched, the URL is opened
 
 
# This test case verify that when user click on clothing menu it should load the clothing menu page successfully
@smoke
 Scenario: Verify that clothing Menu loads successfully when clicked on clothing button
    When User click on Clothing button
    Then User should nevigate to clothing menu


# This test case verify that when user click on clothing menu and then Mens button it should load the clothing menu page for mens
@smoke
 Scenario: Verify that Men clothing menu loads successfully when clicked on Men clothing button
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
    @smoke
    Scenario: Verify that user cannot navigate to checkout page with an empty cart
    When User click on Clothing button
    And User click on a product
    And User click on Add to Cart button
    And User click on Delete button for the added product
    Then The cart should be empty and checkout button should be disabled and user should not be able to navigate to checkout page
    
    
    #Product search functionality
    # This test case verify that when user click on clothing menu, then enter a product name in the search bar and click on search button the relevant products should be displayed based on the search query
    @smoke
    Scenario: Verify that product search functionality works correctly
    When User click on Clothing button
    And User enters a product name "Tshirt" in the search bar
    And User click on search button
    Then Relevant products should be displayed based on the search query
    
    #Invalid product search functionality
    # This test case verify that when user click on clothing menu, then enter an invalid product name in the search bar and click on search button an appropriate message should be displayed
    @smoke
    Scenario: Verify that appropriate message is displayed for invalid product search
    When User click on Clothing button
    And User enters an invalid product name "asasdsdssdssffdsf" in the search bar
    And User click on search button
    Then An appropriate message should be displayed indicating that "All items in this category are sold out."
    
    #Search without entering product name
    # This test case verify that when user click on clothing menu, then click on search button without entering a product name an appropriate message should be displayed
    @smoke
    Scenario: Verify that appropriate message is displayed when search is performed without entering a product name
    When User click on Clothing button
    And User click on search button without entering a product name
    Then Same clothing menu page should be displayed
    
    #Special characters in search
    # This test case verify that when user click on clothing menu, then enter special characters in the search bar and click on search button
    @smoke
    Scenario: Verify that error message is displayed when special characters are entered in the search bar
    When User click on Clothing button
    And User enters special characters "@#$%^&*" in the search bar
    And User click on search button
    Then An error message should be displayed indicating that "We are sorry. There is a problem with the page you are trying to access."
    
    #verify Auto suggestion in search bar
    # This test case verify that when user click on clothing menu, then enter a product name in the search bar the auto suggestion should be displayed based on the entered text
    @smoke
    Scenario: Verify that auto suggestion is displayed in the search bar
    When User click on Clothing button
    And User enters a product name "shirt" in the search bar
    Then Auto suggestion should be displayed based on the entered text "shirt"
    
    #neviagting back to clothing page after searching for a product
    #This test case verify that when user click on clothing menu, then enter special characters in the search bar and click on search button
    #then click on back button then user should nevigate back to clothing page
    @smoke 
    Scenario: Verify that user neviagte back to clothing page when click on back button after product search
    When User click on Clothing button
    And User enters a product name "shirt" in the search bar
    And User click on search button
    And User click on back page button
    Then User should nevigate back to clothing menu

    #Verify search keyword persists after page refresh
    #This test case verify that when user click on clothing menu, then enter valid product name in the search bar and click on search button
    #and click on refresh button then same page should be displayed
    @smoke
    Scenario: Verify that user stays on same page when click on refresh button after product search
    When User click on Clothing button
    And User enters a product name "shirt" in the search bar
    And User click on search button
    And User click on refresh page button
    Then User should stays on same page
	
    #Verify user cannot decrease quantity below 1
    #This test case verify that when user click on clothing menu, then click on a produt then add to cart 
    #then it can't decrease the product quantity below 1
    @smoke
    Scenario: Verify user cannot decrease quantity below One 
    When User click on Clothing button
    And User click on a product
    And User click on a decrease quantity button
    Then User should not able to decrease quantity below 1 product
    
    #Verify user cannot increase quantity beyond available stock
    #This test case verify that when user click on clothing menu, then click on a produt then add to cart 
    #then it can't increase the product quantity beyond available stock
    @smoke
    Scenario: Verify user cannot increase quantity beyond available stock
	When User click on Clothing button
    And User click on a product
    And User capture available stock
    And User click on a increase quantity button
    Then User should not able to increase quantity beyond available stock
    
    #Verify cart retains products after page refresh
    #This test case verify that when user click on clothing menu, then click on a produt then add to cart
    #then click on refresh button then the products added to cart should still be in the cart
    @smoke
    Scenario: Verify that products added to cart are retained after page refresh
    When User click on Clothing button
    And User click on a product
    And User click on Add to Cart button
    And User click on refresh page button
    Then The products added to cart should still be in the cart after page refresh
    
    #Scenario: Verify cart retains products when user navigates across pages
    #This test case verify that when user click on clothing menu, then click on a produt then add to cart
    #then navigate to home page and then navigate back to clothing page then the products added to cart should still be in the cart
    @smoke
    Scenario: Verify that products added to cart are retained when user navigates across pages
    When User click on Clothing button
    And User click on a product
    And User clicks on Add to Cart button
    And User click on Continue Shopping button
    And User click on Home page button
    And User click on Cart button of Home Page
    Then The products added to cart should still be in the cart when user navigates across pages
   
    #Verify adding same product again updates quantity instead of creating duplicate entry
    #This test case verify that when user click on clothing menu, then click on a produt then add to cart
    #then click on continue shopping button and then click on the same product again and add to cart
    #then the quantity of the product in the cart should be updated instead of creating a duplicate entry for the same product
    @smoke
    Scenario: Verify that adding the same product again updates quantity instead of creating duplicate entry
    When User click on Clothing button
    And User click on a product
    And User clicks on Add to Cart button
    And User click on Continue Shopping button
    And User go back to clothing menu from product details page
    And User click on a product
    And User clicks on Add to Cart button
    And User click on View Cart button
    Then The quantity of the product in the cart should be updated instead of creating a duplicate entry for the same product
    
    #Verify cart retains Same product when user navigates across pages
    #This test case verify that when user click on clothing menu, then click on a produt then add to cart
    #then navigate to home page and then navigate back to clothing page then the products added to cart should still be in the cart
    @smoke
    Scenario: Verify that same products added to cart are retained when user navigates across pages
    When User click on Clothing button
    And User captures the name and price of a product
    And User click on a product    
    And User clicks on Add to Cart button
    And User click on Continue Shopping button
    And User click on Home page button
    And User click on Cart button of Home Page
    Then The same products added to cart should still be in the cart when user navigates across pages
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    