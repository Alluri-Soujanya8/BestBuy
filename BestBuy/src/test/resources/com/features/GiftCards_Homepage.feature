Feature: Navigate to BestBuy E-Gift Cards Page from Menu

  Scenario: Navigate to E-Gift Cards page via menu
    Given more functionality should be available
    When user clicks More
    And user clicks Gift Cards
    Then the Gift Cards page should be displayed


@ExcelData
Scenario: Validate required fields and navigate to design selection
    Given the user is on the Gift Cards page
    When the user clicks on E-Gift Cards,E-Gift Card page should be displayed
    And the user enters  recipient name and the user enters  sender name 
    And the user  clicks on Send a Digital Card
    Then the user should be navigated to the Choose E-Gift Card Design page



  @Tag

Scenario Outline: Verify navigation and name entry workflow using Excel data
    Given user is on E-Gift Cards personalization page
    When user loads Excel data
    And user enters recipient and sender names for all rows
    Then validate system response for all rows





   

      