Feature: Navigation to Deal of the Day
  Scenario: Verify navigation to Deal of the Day page
    Given User is on BestBuy homepage
    When the user clicks on the Deal of the Day
    Then the Deal of the Day page should be displayed

  
  @FAQ
   Scenario: Navigate from Deal of the Day to FAQ and then Help Center
    Given User is on Deal of the Day page
    When the user clicks on the FAQ link
    And the FAQ page should be displayed
    And the user clicks on the Help Center link
    Then the Help Center page should be displayed
    
  @Product
  Scenario Outline: Validate clicking product navigates to full product detail page
   Given user is on the Deal of the Day page
   When user click on the search button
   And user enters the product from sheet <sheet> and row <row>
   Then it should display product details

Examples:
   |sheet|row|
   |  0  | 0 |
   |  0  | 1 |
  
   	@Cart
 	Scenario: Navigate to product details page and check cart icon 
 	Given user is on the Deal of the Day Page Module
 	When user clicks on the first product of Bonus Deals
 	And Navigate to the product page
 	And click on cart icon navigate to add to cart page
 	Then verify no product to be is visible  

	@Fifth
	Scenario Outline: Validate product details and checkbox selection on BestBuy
    Given user is on the Deal of the Day page
    When user clicks on the first product in the Bonus deal of the day section
    And product details page opens
    And user clicks on the opened product to view full product details
    And user selects checkboxes for price options from sheet <sheet> and row <row>
    Then it should display the selected price options correctly

Examples:
   | sheet | row |
   |   1   |  0  |
   |   1   |  1  |
	
	
	
	
	
	


   
 
   
 


 