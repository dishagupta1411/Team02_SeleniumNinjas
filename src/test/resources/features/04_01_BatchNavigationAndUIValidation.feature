Feature: Batch Page Navigation and UI Validation
  As an Admin, I want to navigate to the Batch page and verify
  its menu bar and UI elements are displayed correctly

  Background:
    Given Admin is on home page after Login - Batch

  Scenario: Batch page navigation
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should be in the Manage Batch Page - Batch

  Scenario: Batch sub-menu displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see sub menu in menu bar as "Add New Batch" - Batch

  Scenario: Batch page heading is displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the "Manage Batch" Heading - Batch

  Scenario: Presence of disabled Delete Icon
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the disabled "Delete Icon" under the header - Batch

  Scenario: Pagination controls are displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the pagination controls under the data table - Batch

  Scenario: Edit icon is displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the edit icon in each row - Batch

  Scenario: Delete icon is displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the delete icon in each row - Batch

  Scenario: Checkbox is displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the checkbox in each row - Batch

  Scenario: Datatable headers are displayed
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the datatable headers Batch name, Batch Description, Batch Status, No Of classes, Program Name, Edit/Delete - Batch

  Scenario: Checkbox is displayed in header row
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the checkbox in the datatable header row - Batch

  Scenario: Sort icon presence
    When Admin clicks "Batch" on the navigation bar - Batch
    Then Admin should see the sort icon next to all Datatable headers - Batch

  Scenario: Add New Batch dialog is displayed
    When Admin clicks on "Add New Batch" under the "batch" menu bar - Batch
    Then Admin should see the Batch Details dialog box - Batch