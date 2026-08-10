Feature: Delete Multiple Batches with Checkbox
  As an Admin, I want to select multiple batches using checkboxes
  and delete them in bulk

  Background:
    Given Admin is on the Batch page for bulk deletion - Batch

  Scenario: Select multiple batches
    When Admin selects more than one batch by clicking on the checkbox - Batch
    Then Admin should see the Multiple Delete button enabled under Manage Batch - Batch

  Scenario: Delete multiple batches
    When Admin clicks on the delete button on the top left of the Batch page - Batch
    Then Admin should land on the Confirmation form - Batch