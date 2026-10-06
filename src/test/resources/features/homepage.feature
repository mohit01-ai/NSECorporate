@homepage @regression
Feature: Verify the home page scenarios

  @verifyIndexes
  Scenario: Verify all the indices are available on the home page
    Given the user launch the application
    When user click on home icon
    Then verify all the indexes are available on the home page

  @verifyIndexNames
  Scenario: Verify the name of index are matching correctly
    Given the user launch the application
    When user click on home icon
    When the user get all index names list
    Then Verify the index names are appearing correctly
      | NIFTY 50          |
      | NIFTY NEXT 50     |
      | NIFTY BANK        |
      | NIFTY FIN SERVICE |
      | NIFTY MID SELECT  |
      | NIFTY FPI 150     |
      | NIFTY 100         |
      | NIFTY MIDCAP 100  |
      | NIFTY SMLCAP 100  |
      | NIFTY AUTO        |
      | NIFTY FMCG        |
      | NIFTY IT          |
      | NIFTY ALPHA 50    |
      | NIFTY DIV OPPS 50 |
      | NIFTY GROWSECT 15 |

