Feature: Edit Batch Validation
  As an Admin, I want to verify batch editing functionality
  works correctly for both UI behavior and field validation

  Background:
    Given Admin is on the Batch page - Batch

  Scenario: Edit icon functionality
    When Admin clicks the edit icon on a Batch row - Batch
    Then Admin should see the Batch Details dialog box appears - Batch
    
  Scenario: Batch name value is disabled for editing
    When Admin clicks the edit icon - Batch
    Then Admin should see the batch name field is disabled for editing - Batch

  Scenario: Validate editing description and number of classes with invalid data
    When Admin updates fields with invalid data and clicks save button - Batch
    Then Admin should get an error message under the respective field - Batch

  Scenario: Successful batch update
    When Admin clicks save button after updating with valid data - Batch
    Then Admin should get a successful message for editing the batch - Batch

  Scenario: Cancel button functionality
    When Admin clicks cancel button after updating with valid data - Batch
    Then Admin should see the batch details popup closes without editing the batch - Batch