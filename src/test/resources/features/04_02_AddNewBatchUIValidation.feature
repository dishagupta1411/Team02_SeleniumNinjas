Feature: Add New Batch - UI Validation
  As an Admin, I want to verify all fields in the Add New Batch dialog
  are displayed correctly before entering batch details

  Background:
    Given Admin is on the Manage Batch page - Batch

  Scenario: Batch name field is displayed
    When Admin opens the Add New Batch dialog - Batch
    Then Admin should see the batch name field - Batch

  Scenario: Number of Classes field is displayed
    When Admin opens the Add New Batch dialog - Batch
    Then Admin should see the number of classes field - Batch

  Scenario: Description field is displayed
    When Admin opens the Add New Batch dialog - Batch
    Then Admin should see the description field - Batch

  Scenario: Program Name dropdown is displayed
    When Admin opens the Add New Batch dialog - Batch
    Then Admin should see the program name field with dropdown - Batch

  Scenario: Status radio buttons are displayed
    When Admin opens the Add New Batch dialog - Batch
    Then Admin should see the status radio button - Batch