Feature: Navigate to Gift Ideas Page
Scenario: User clicks on Gift Ideas from the Home Page
    Given the user is on the BestBuy Home Page
    When the user clicks on the moduleName link
    Then the Gift Ideas page with various categories should be displayed
    
@Pet
Scenario: User clicks on Pets category from Gift Ideas page
	Given the user is on the BestBuy Home Page
	When the user clicks on the moduleName link
    And the user clicks on the categoryname category
    And  click on buttonName category
    Then the Pets category page should display pet-related gift items
    
@Filters
Scenario Outline: Apply filters and view product details
    Given the user is on the BestBuy Home Page
    When the user clicks on the moduleName link
    And the user clicks on the categoryname category
	#And click on filter <rowIndex> <sheetNo>
	And click on filters <rowIndex> <sheetNo>
	#And click on clearall button 
    #And the user selects filter option at row <RowIndex> from Excel sheet <sheetno>
    And the user clicks the product list
    Then the product details page should display price, reviews, and availability

Examples:
    |   rowIndex   | sheetNo  |
    |     1        | 0        |
    |     2        | 0        |  
    |     3        | 0        |
    
@cart   
Scenario: Click a product using petfilter checkbox selected and add it to cart
    Given the user is on the BestBuy Home Page
    When the user clicks on the moduleName link
    And the user clicks on the categoryname category
    And I select the petfilter checkbox filter
    #And I click on the first product under petfilter
    And I click on addcart button
    #And click on Go to Cart section
    And click on checkout button
    Then verify if the user is on signin page
