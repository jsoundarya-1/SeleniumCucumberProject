Feature: Loading Premier Inn Page
  Scenario: Loading Premier Inn Page Cancelling the Booking


    Given user opens premier Inn booking website
    When User clicks on Manage Booking Button
    And Filling the details of the Manage Booking Pop up Menu
      |AKTR278839        | Tester    | 21-May-21  |
   # Then User clicks on Cancel Booking button
    #And Cancel your booking pop up appears
    #And User clicks on  Cancel booking button on the pop up
    Then Verify whether the booking got cancelled
