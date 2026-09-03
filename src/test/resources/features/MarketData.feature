@launch
Feature: Verify all link of market data

  Scenario: Verify al top 20 gainers are available
    Given the user launch the application
    When the user go to market data
#    Then verify the top 20 gainers are available