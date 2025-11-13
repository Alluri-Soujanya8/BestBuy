Feature: BestBuy TV&HomeTheatre Module

This feature deals with TV & HomeTheatre Module in BestBuy Website

@Menu
Scenario: This feature deals with TV & HomeTheatre Module in BestBuy Website

	Given Menu Bar should avaliable
	And click on Menu Bar
	And Select the Shop by Department 
	When I click on Tv&Home Theatre
	Then should display the Product page

    
@Brands
Scenario Outline: Verifiying adding TV by brand and checkout as guest
   Given Menu Bar should avaliable
	And click on Menu Bar
	When I click on Tv&Home Theatre
	And I click on TVs by Brand 
	And I select from sheet <sheet>  <row>
	Then the TV listingpage for the brand  should be displayed
	Then I click on Brand 
	
Examples:
| sheet | row |
|   0   |  0  |
|   0   |  1  |
#|   0   |  2  |


@Tvtype
Scenario Outline: I need to select different television types
	Given Menu Bar should avaliable
	And click on Menu Bar
	And Select the Shop by Department 
	When I click on Tv&Home Theatre
	Then should display the Product page
	And User select first television type  <sheet> <row>
	And user select second television type <sheet> <row>
	And user select third television type  <sheet> <row>
	Then it displays the avaliable TVs
	
Examples:
| sheet | row |
|   0   |  0  |
|   0   |  1  |
|   0   |  2  |

@ProductPage
Scenario: Go in to the product page

	Given Menu Bar should avaliable
	And click on Menu Bar
	And Select the Shop by Department 
	When I click on Tv&Home Theatre
	And should display the Product page
	When User Select a product it will go into the product page
	And User can click the link for reviews
	And User Add Tv to the Cart
	When Popup appears select go to the cart
	Then it displays cart page
	
@CartPage
Scenario: Go into the cart page

    Given Menu Bar should avaliable
	And click on Menu Bar
	And Select the Shop by Department 
	When I click on Tv&Home Theatre
	And should display the Product page
	When User Select a product it will go into the product page
	And User can click the link for reviews
	And User Add Tv to the Cart
	When Popup appears select go to the cart
	And User is in the Cart Page
	And user can save the product
	And user can remove the product if not needed
	And user will do checkout
	And user will go for the page to sign in
	When clicking on continue as guest
	Then it displays the checkout page








	

	


    
 



