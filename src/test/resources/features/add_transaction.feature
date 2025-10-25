Feature: Add transaction

  Scenario: Add new transaction
    Given Pepito is logged into the application
    When Pepito enters the required information for the new transaction
    Then Pepito should see a new transaction in the transaction list with correct details