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
