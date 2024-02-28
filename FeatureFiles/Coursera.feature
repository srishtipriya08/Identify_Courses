Feature: Coursera

  Scenario: 1
    Given the user enter the Web development course
    And user click on search button
    When user select beginner level
    And user select English language
    Then Display first two courses

  Scenario: 2
    Given the user again navigate back to the homepage
    When user enter the learning language course
    And Click on language See more link
    And Go to Level option
    Then User Navigate to the main page

  Scenario: 3
    Given User scroll to the for Enterprise
    And click the enterprise link
    When Go to solution button
    And select the course for campus
    And user fill the ready to transform form
    Then Submit the filled form
    And Capture the error message
