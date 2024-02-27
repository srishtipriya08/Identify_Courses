Feature: Enterprise Page

  Scenario: 3
    Given User scroll to the for Enterprise 
    And click the enterprise link
    When Go to solution button
    And select the course for campus
    And user fill the ready to transform form
    Then Submit the filled form
    And Capture the error message
