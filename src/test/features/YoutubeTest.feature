Feature: Youtube Testing for eFishery

@TC0001
Scenario: Verify access to the Youtube music home page
    Given I am on the browser
    When I open Youtube Music URL
    Then I should be in Youtube Music home page

@TC0002
Scenario: Verify access to the Explore page
    Given I am on the browser
    When I open Youtube Music URL
    And I click the Explore button
    Then I should be in Youtube Music explore page

@TC0005
Scenario: Verify the Search button
    Given I am on the browser
    When I open Youtube Music URL
    And I click the search button
    And I add "Phoneme" on the search textbox
    And I click Enter on my keyboard
    Then I should get the correct result from searching "Phoneme"