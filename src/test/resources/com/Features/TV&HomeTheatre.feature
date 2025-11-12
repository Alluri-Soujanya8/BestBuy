Feature: BestBuy TV&HomeTheatre Module

This feature deals with TV & HomeTheatre Module in BestBuy Website

@Menu
Scenario: This feature deals with TV & HomeTheatre Module in BestBuy Website

	Given Menu Bar should avaliable
	And click on Menu Bar
	And Select the Shop by Department 
	When I click on Tv&Home Theatre
	Then should display the Product page
	

@TVpage
Scenario: Apply valid filters on TV page
    Given User is on the TV page
    When User scrolls to the filter panel
    And User applies filters whatever want to apply from sheet <sheet> and row <row>
    Then Relevant TV models matching the criteria should be displayed
    
Examples:
| sheet | row|
|   0   |  0 |
|   0   |  1 |
|   0   |  2 |
    
    
#@Brands
#Scenario Outline:Verifiying adding TV by brand and checkout as guest
#   Given Menu Bar should avaliable
#	And click on Menu Bar
#	When I click on Tv&Home Theatre
#	And I click on TVs by Brand
	#Given the user loads testdata for <TestCaseID>
	#When the user navigates through <Menu1> from Excel for <TestCaseID>
	#And the user selects a Tv product
#	Then the TV listingpage for the brand  should be displayed
#	Then I click on Brand
	
#Examples:
#| Brand |






	

	


    
 



