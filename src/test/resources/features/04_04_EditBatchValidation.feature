Feature: Edit Batch Validation
  As an Admin, I want to verify batch editing functionality
  works correctly for both UI behavior and field validation

  Background:
    Given Admin is on the Batch page - Batch

  @EditBatchVal01
  Scenario: Edit icon functionality
    When Admin clicks the edit icon on a Batch row - Batch
    Then Admin should see the Batch Details dialog box appears - Batch
  
  @EditBatchVal02  
  Scenario: Batch name value is disabled for editing
    When Admin clicks the edit icon - Batch
    Then Admin should see the batch name field is disabled for editing - Batch

	@EditBatchVal03
  Scenario Outline: Validate editing <field> with invalid data
    When Admin updates the "<field>" field with invalid data and clicks save button - Batch
    Then Admin should see "<errorType>" for the "<field>" field - Batch

    Examples:
      | field             | errorType      |
      | Description       | toast error    |
      | Number of Classes | field error    |
      
	@EditBatchVal04
  Scenario: Successful batch update
    When Admin clicks save button after updating with valid data - Batch
    Then Admin should get a successful message for editing the batch - Batch

	@EditBatchVal05
  Scenario: Cancel button functionality
    When Admin clicks cancel button after updating with valid data - Batch
    Then Admin should see the batch details popup closes without editing the batch - Batch