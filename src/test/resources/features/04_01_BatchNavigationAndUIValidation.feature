Feature: Batch Page Navigation and UI Validation
  As an Admin, I want to navigate to the Batch page and verify
  its menu bar and UI elements are displayed correctly

  Background:
    Given Admin is on home page after Login - Batch

	@batchNav01
  Scenario: Batch page navigation
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should be in the Manage Batch Page - Batch
    
	@batchNav02
  Scenario: Batch sub-menu displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see sub menu in menu bar as "Add New Batch" - Batch
	
	@batchNav03
  Scenario: Batch page heading is displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the "Manage Batch" Heading - Batch
    
	@batchNav04
  Scenario: Presence of disabled Delete Icon
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the disabled "Delete Icon" under the header - Batch
    
	@batchNav05
  Scenario: Pagination controls are displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the pagination controls under the data table - Batch
    
	@batchNav06
  Scenario: Edit icon is displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the edit icon in each row - Batch
	
	@batchNav07
  Scenario: Delete icon is displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the delete icon in each row - Batch
    
	@batchNav08
  Scenario: Checkbox is displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the checkbox in each row - Batch
    
	@batchNav09
  Scenario: Datatable headers are displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the datatable headers Batch name, Batch Description, Batch Status, No Of classes, Program Name, Edit/Delete - Batch
	
	@batchNav10
  Scenario: Checkbox is displayed in header row
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the checkbox in the datatable header row - Batch
	
	@batchNav11
  Scenario: Sort icon presence
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the sort icon next to all Datatable headers - Batch
	
	@batchNav12
  Scenario: Add New Batch dialog is displayed
    When Admin clicks on "Add New Batch" under the "batch" menu bar - Batch
    Then Admin should see the Batch Details dialog box - Batch