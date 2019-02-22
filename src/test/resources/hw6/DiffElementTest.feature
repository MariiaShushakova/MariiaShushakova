@DifferentElements
Feature: Different Elements Page Test

  Scenario: Interface testing
    Given I open EPAM JDI site
    Then Browser title should be 'HP_TITLE'
    When I login as 'PETER'
    Then Username should be 'PETER'
    Then Home Page should have 4 benefit icons
    Then Home Page should have 4 texts under icons
    Then Home Page should have title 'Home Page' and description 'LOREM IPSUM..'
    When I click on Service menu in the header
    Then Service dropdown menu contains options
    When I click on Service menu in the left section
    Then Service dropdown in left section contains options
    When I click on 'Service' button in Header
    And I go to 'DIFFERENT ELEMENTS' Page
    Then Different elements page contains 4 checkboxes with forces of nature
    And Different elements page contains 4 radio buttons with metals
    And Different elements page contains color choice dropdown
    And Different elements page contains 2 buttons
    And Different elements page has a Right section
    And Different elements page has a Left section
    When I select 'WATER' checkbox
    Then Log row with status 'true' is displayed for 'WATER'
    When I select 'WIND' checkbox
    Then Log row with status 'true' is displayed for 'WIND'
    When I select 'SELEN' radio button and the selection is logged
    When I select 'YELLOW' from the color selection dropdown and the selection is logged
    When I deselect checkbox 'Water'
    Then The deselection of 'Water' is logged
    When I deselect checkbox 'Wind'
    Then The deselection of 'Wind' is logged