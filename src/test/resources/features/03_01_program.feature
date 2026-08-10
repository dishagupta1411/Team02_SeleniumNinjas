Feature: Program Module

  Background: Admin is logged in to LMS Portal
    Given Admin is in login Page to test Program module
    When Admin enter valid credentials and clicks login button through keyboard for Program module


  @Program @Navigation
  Scenario: Program page navigation
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should be navigated to Program page


  @Program @SubMenu
  Scenario: Program-Sub menu displayed
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see sub menu in menu bar as "Add New Program"


  @Program @Heading
  Scenario: Manage program heading presence
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the heading "Manage Program"


  @Program @Alignment
  Scenario: Manage program heading alignment
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see manage program heading aligned on the left side


  @Program @DeleteButton
  Scenario: Multiple Delete button state
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see a Delete button in left top is disabled


  @Program @Search
  Scenario: Search box is displayed
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see Search bar


  @Program @Search @Placeholder
  Scenario: Search placeholder presence
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see "Search..." placeholder text


  @Program @DataTable
  Scenario: Column header name of data table
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit/Delete


  @Program @Checkbox
  Scenario: Checkbox default state - header
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see checkbox default state as unchecked beside Program Name column header


  @Program @Checkbox
  Scenario: Checkbox default state - datatable each rows
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see check box default state as unchecked on the left side in all rows against program name


  @Program @UISorting
  Scenario: Sort icon presence
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete


  @Program @EditDelete
  Scenario: Edit and delete icon presence
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the Edit and Delete buttons on each row of the data table


  @Program @UIPagination
  Scenario: Verify pagination icons below data table in manage program
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table.


  @Program @Footer
  Scenario: Verify footer message in manage program
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the footer as "In total there are z programs".
