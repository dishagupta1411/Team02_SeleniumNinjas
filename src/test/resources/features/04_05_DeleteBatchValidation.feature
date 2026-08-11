Feature: Delete Batch Validation
  As an Admin, I want to verify batch deletion works correctly
  with proper confirmation and cancellation behavior

  Background:
    Given Admin is on the Batch page for batch deletion- Batch
    
	@deleteBatch01
  Scenario: Display delete confirmation on Batch
    When Admin clicks the delete icon on a Batch row - Batch
    Then Admin should see the confirm alert box with yes and no button - Batch

	@deleteBatch02
  Scenario: Delete Batch successfully
    When Admin clicks yes button after clicking delete icon on a Batch row - Batch
    Then Admin should see the successful message and the Batch should be deleted - Batch
	
	@deleteBatch03
  Scenario: Cancel Batch deletion
    When Admin clicks no button after clicking delete icon on a Batch row - Batch
    Then Admin should see the alert box closed and the Batch is not deleted - Batch
	
	@deleteBatch04
  Scenario: Close icon functionality on Batch delete confirmation
    When Admin clicks on the close icon on the Batch confirm popup - Batch
    Then Admin should see the alert box closed - Batch