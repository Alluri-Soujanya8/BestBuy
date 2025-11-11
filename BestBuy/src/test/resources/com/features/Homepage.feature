Feature: Navigate to Gift Ideas Page
Scenario: User clicks on Gift Ideas from the Home Page
    Given the user is on the BestBuy Home Page
    When the user clicks on the "<moduleName>" link
    Then the Gift Ideas page with various categories should be displayed
    
@Pet
Scenario: User clicks on Pets category from Gift Ideas page
	Given the user is on the BestBuy Home Page
	When the user clicks on the "<moduleName>" link
    And the user clicks on the "<categoryname>" category
    And  click on "<buttonName>" category
    Then the Pets category page should display pet-related gift items
    
@Filters
Scenario Outline: Apply filters, clear them, and view product details
    Given the user is on the BestBuy Home Page
    When the user clicks on the "<moduleName>" link
    And the user clicks on the "<categoryName>" category
	#And the user applies filter "<filterName>"
    And the user selects filter option at row <RowIndex> from Excel sheet <sheetno>
    And the user clicks on <RowIndex> from the product list
    Then the product details page should display price, reviews, and availability

Examples:
    | RowIndex         | sheetno  |
    |   1              |     1    |
   # | Nite Ize      | Nite Ize - NiteHowl Polymer Dog Lighted Collar |
   # | Gift Ideas  | Pets         | Price      | $25 - $49.99   | Shark - Cyclone PET Handheld Vacuum with HyperVelocity Suction, PetExtract Hair Tool          |


Scenario: Share option is missing on the product page
    Given the user is on the product page of a valid product
    When the page is fully loaded
    Then the Share option should be visible and clickable
    But the Share option is not displayed
