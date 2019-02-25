Feature: Different Elements Page Test

  @DifferentElements
  Scenario: Interface testing
    Given I am on 'Home Page'
    Then 'HP_TITLE' page is opened
    When I login as 'PITER'
    Then Username should be 'PITER'
    Then Home Page should have 4 benefit icons
    Then Home Page should have 4 texts under icons
    Then Home Page should have title 'TEXT_HEADER_1' and description 'TEXT_HEADER_2'
    When I click on 'Service' button in Header
    Then Service dropdown menu contains options:
      |SUPPORT           |
      |DATES             |
      |COMPLEX_TABLE     |
      |SIMPLE_TABLE      |
      |TABLE_WITH_PAGES  |
      |DIFFERENT_ELEMENTS|
    When I click on Service menu in the left section
    Then Service dropdown in left section contains options:
      |SUPPORT           |
      |DATES             |
      |COMPLEX_TABLE     |
      |SIMPLE_TABLE      |
      |TABLE_WITH_PAGES  |
      |DIFFERENT_ELEMENTS|
    When I click on 'Service' button in Header
    And I click on 'DIFFERENT_ELEMENTS' button in Service dropdown
    Then Different elements page contains elements
    When I select 'CHECKBOX_WATER' checkbox
    Then Log row for enabling 'CHECKBOX_WATER' checkbox appears
    When I select 'CHECKBOX_WIND' checkbox
    Then Log row for enabling 'CHECKBOX_WIND' checkbox appears
    When I select 'RADIO_BUTTON_SELEN' radio button
    Then Log row for 'RADIO_BUTTON_SELEN' radiobutton appears
    When I select 'DROPDOWN_YELLOW' dropdown value
    Then Log row for 'DROPDOWN_YELLOW' value appears
    When I deselect checkbox 'CHECKBOX_WATER'
    Then The deselection of 'CHECKBOX_WATER' is logged
    When I deselect checkbox 'CHECKBOX_WIND'
    Then The deselection of 'CHECKBOX_WIND' is logged
