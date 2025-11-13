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
    Given user is on E-Gift Cards page
    When user enters recipient and sender names from sheet <sheet> and row <row>
    Then user clicks on Send a Digital Card and validate system response for all rows
Examples:
|sheet|row|
|1    |1  |
|1    |2  |
|1    |3  |


@Tag1
Scenario:Verify design selection, amount selection, and validate navigation
    Given user is on Design Selection page
    When user selects a design
    And user clicks on Continue and navigates to Amount page
    And user selects an amount
    And user clicks on Add a Message
    Then user should be navigated to Add Message page





   

      