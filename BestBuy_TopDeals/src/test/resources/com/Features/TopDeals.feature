
Feature: Best Buy Top Deals Page

This feature deals with the Top Deals functionality.
 
@FirstScenario
Scenario: test Top Deals Functionality with valid data
 
	Given Top Deals functionality should be availble
	When i click on Top Deals link
	And should display Top Deals page
	And should click on Computer & Tablet Deals
	And should click on Laptops
	Then should display Laptop Deals
	
@SecondScenario	
Scenario: test Saved Items Functionality with valid data
	
	Given Top Deals functionality should be availble
	When i click on Top Deals link
	And should display Top Deals page
	And should click on Computer & Tablet Deals
	And should click on Laptops
	Then should display Laptop Deals
	Given User Laptop Deals page should scroll to Featured deals
	When i click on save option for first laptop
	And click on save option for second laptop
	And scroll up to click on Saved Items
	Then click on See all your saved items
