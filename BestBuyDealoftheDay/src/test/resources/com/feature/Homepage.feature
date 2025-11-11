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
 


 