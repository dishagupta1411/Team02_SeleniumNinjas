Feature: Add New Batch - Functional Validation
  As an Admin, I want to verify batch creation behaves correctly
  with valid, invalid, and edge-case inputs

  Background:
    Given Admin is on the Batch Details dialog box - Batch

  Scenario: Program name appears as batch prefix
    When Admin selects a program name from the dropdown - Batch
    Then Admin should see the selected program name in the batch name prefix box - Batch

  Scenario: Batch name suffix accepts only numbers
    When Admin enters alphabets in the batch name suffix box - Batch
    Then Admin should get an error message below the respective field - Batch

  Scenario: Batch name prefix cannot be edited
    When Admin enters alphabets in the batch name prefix box - Batch
    Then Admin should see the prefix box remains empty - Batch

  Scenario: Add new batch with only mandatory fields
    When Admin enters data only in the mandatory fields and clicks save - Batch
    Then Admin should get a successful message - Batch

  Scenario: Add new batch with a mandatory field left blank
    When Admin leaves one mandatory field blank and clicks save - Batch
    Then Admin should get an error message on the respective mandatory field - Batch

  Scenario: Cancel button functionality
    When Admin enters valid data in all mandatory fields and clicks cancel - Batch
    Then the batch details popup should close without creating any batch - Batch

  Scenario: Close icon functionality
    When Admin clicks the close icon on the batch details popup - Batch
    Then the batch details popup should close - Batch