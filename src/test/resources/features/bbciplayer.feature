Feature: Verify the Tube Status functionality
  As a user, I would like the verify the status of any line shows Good Service

  Scenario Outline: Verify that the status of any line shows Good Service
    Given I have the line name "<name>"
    When I retrieve the line id using the TFL API
    Then the line id should be "<line_id>"
    When I check the status of the line using the TFL API
    Then the line status should be "Good service"
    Examples:

      | name | line_id  |
      | Bakerloo  | bakerloo |
      | Central   | central  |
      | Victoria  | victoria |
    # Add more lines as needed
