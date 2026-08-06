Feature: Program Module

  Background:
    Given Admin is logged in to LMS Portal

  Scenario: Program page navigation
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should be navigated to Program page

  Scenario: Program-Sub menu displayed
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see sub menu in menu bar as "Add New Program"

  Scenario: Manage program heading presence
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the heading "Manage Program"

  Scenario: Manage program heading alignment
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see manage program heading aligned on the left side

  Scenario: Multiple Delete button state
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see a Delete button in left top is disabled

  Scenario: Search box is displayed
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Search bar

  Scenario: Search placeholder presence
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see search... placeholder text

  Scenario: Column header name of data table
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit/Delete

  Scenario: Checkbox default state - header
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see checkbox default state as unchecked beside Program Name column header

  Scenario: Checkbox default state - datatable each rows
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see check box default state as unchecked on the left side in all rows against program name

  Scenario: Sort icon presence
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete

  Scenario: Edit and delete icon presence
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the Edit and Delete buttons on each row of the data table

  Scenario: Pagination controls are displayed
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination controls below the table.
    And x- starting record number on that page
    And y-ending record number on that page
    And z-Total number of records

  Scenario: Footer message is displayed
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the footer as "In total there are z programs".
    And z- Total number of records

  