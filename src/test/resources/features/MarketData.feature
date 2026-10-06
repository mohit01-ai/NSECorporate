@Regression
Feature: Verify all link of market data

  @topgainers
  Scenario: Verify all top 20 gainers are available
    Given the user launch the application
    When the user go to market data
    When  the user go to Gainers losers
#    When the user select the index "NIFTY 50"
#    Then verify the top 20 gainers are available
    When the user select the index "Securities > Rs 20"
    Then verify the top 20 gainers are available
#    When the user select the index "Securities < Rs 20"
#    Then verify the top 20 gainers are available
#    When the user select the index "F&O Securities"
#    Then verify the top 20 gainers are available
#    When the user select the index "All Securities"
#    Then verify the top 20 gainers are available

  @topGainersFile
  Scenario: Verify top gainers data csv file is downloading properly
    Given the user launch the application
    When the user go to market data
    When  the user go to Gainers losers
    When  the user click on download file
    Then verify the file is downloaded

  @upperCircuit
  Scenario: Verify the top gainer has a upper circuit of 20 percent
    Given the user launch the application
    When the user go to market data
    When  the user go to Gainers losers
    When the user select the index "Securities > Rs 20"
    When  the user click on download file
    Then verify the top gainer has a twenty percent upper circuit


