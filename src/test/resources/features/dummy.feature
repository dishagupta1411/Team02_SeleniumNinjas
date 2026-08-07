Feature: Program Module

 
 Scenario: Program page navigation
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should be navigated to Program page
    
    Scenario: Program-Sub menu displayed
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see sub menu in menu bar as "Add New Program"
    
     Scenario: Manage program heading presence
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see the heading "Manage Program"
    
     Scenario: Manage program heading alignment
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see manage program heading aligned on the left side
    
    
  Scenario: Multiple Delete button state
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see a Delete button in left top is disabled
    
    Scenario: Search box is displayed
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see Search bar
    
    Scenario: Search placeholder presence
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see "Search..." placeholder text
    

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
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
    
      Given Admin navigates to program page after logged in

  Scenario: Add New Program dialog is displayed
    Given Admin is on Program page
    When Admin clicks on "Add New Program" under the "Program" menu bar
    Then Admin should see Program Details dialog

  Scenario: Program Details dialog title
    Given Admin is on Program page
    When Admin clicks on "Add New Program" under the "Program" menu bar
    Then Admin should see title as "Program Details"

  Scenario: Mandatory fields indicator
    Given Admin is on Program page
    When Admin clicks on "Add New Program" under the "Program" menu bar
    Then Admin should see red asterisk mark beside mandatory field "Name" and "status"

  Scenario: Name field is displayed
    Given Admin is on Program page
    When Admin clicks on "Add New Program" under the "Program" menu bar
    Then Admin should see the Name text box

  Scenario: Description field is displayed
    Given Admin is on Program page
    When Admin clicks on "Add New Program" under the "Program" menu bar
    Then Admin should see the Description text box

  Scenario: Status radio buttons are displayed
    Given Admin is on Program page
    When Admin clicks on "Add New Program" under the "Program" menu bar
    Then Admin should see Active and Inactive radio buttons

  

  Scenario Outline: Empty form submission
    Given Admin is on Program details dialog box
    When Admin clicks save button without entering mandatory
    Then Admin gets message '<field> is required'

    Examples:
      | field |

  Scenario: Cancel button functionality
    Given Admin is on Program details dialog box
    When Admin clicks Cancel button
    Then Admin can see Program Details form disappears

  Scenario: Close button (X) functionality
    Given Admin is on Program details dialog box
    When Admin clicks X button
    Then Admin can see Program Details form disappears

  Scenario: Add new program with valid details
    Given Admin is on Program details dialog box
    When Admin enter valid details for mandatory fields and Click on save button
    Then Admin gets message 'Successful Program created'

  Scenario: Add new program with numeric program name
    Given Admin is on Program details dialog box
    When Admin enters a numeric value as the Program Name
    Then Admin should see error message "This field should start with an alphabet, no special char other than a hyphen and have min 4 char"

 

  Scenario: Verify added Program is created
    Given Admin is on Program page
    When Admin searches with newly created "Program Name"
    Then Admin should see the Records of the newly created Program details

  Scenario: Edit icon functionality
    Given Admin is on Program page
    When Admin clicks on Edit option for particular program
    Then Admin should see Program Details dialog

  Scenario: Edit Program Name
    Given Admin is on Program details dialog box
    When Admin clicks save button after editing the program name
    Then Admin should see "Successful Program Updated" message

  Scenario: Edit Description
    Given Admin is on Program details dialog box
    When Admin clicks save button after editing the description
    Then Admin should see "Successful Program Updated" message

  Scenario: Edit Status
    Given Admin is on Program details dialog box
    When Admin clicks save button after changing the status of the program
    Then Admin should see "Successful Program Updated" message

  Scenario: Verify edited Program details
    Given Admin is on Program page
    When Admin searches with newly updated "Program Name"
    Then Admin verifies that the details are correctly updated.

  Scenario: Display Delete Confirmation
    Given Admin is on Program page
    When Admin clicks on delete icon for a program
    Then Admin will get confirm deletion dialog box

  Scenario: Delete Program Successfully
    Given Admin is on Confirm deletion form
    When Admin clicks on "Yes" button
    Then Admin can see 'Successful Program Deleted' message

  Scenario: Deleted Program visibility
    Given Admin is on Program page
    When Admin Searches for "Deleted Program name"
    Then There should be zero results.

  Scenario: Cancel Program Deletion
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin clicks on "No" button
    Then Admin can see Confirmation form disappears

  Scenario: Close Delete Confirmation
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin Click on "X" button
    Then Admin can see Confirm Deletion form disappear

  Scenario: Select multiple programs
    Given Admin is on Program page
    When Admin selects more than one program by clicking on the checkbox
    Then Mulitple delete box under manage program must be enabled

  Scenario: Delete Multiple programs
    Given Admin is on Program page
    When Admin clicks on the delete button on the left top of the program page
    Then Admin lands on Confirmation form

  Scenario: Delete selected program
    Given Admin is on Confirmation form
    When Admin clicks on "Yes" button
    Then Admin can see "Successful program deleted" message

  Scenario: Deleted program Visibility
    Given Admin is on Program page
    When Admin Searches for "Deleted Program names"
    Then There should be zero results.

  Scenario: Cancel Multiple Deletion
    Given Admin is on Confirmation form
    When Admin clicks on "No" button
    Then Admin can see Programs are still selected and not deleted

  Scenario: Close Multiple deletion confirmation
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin Click on "X" button
    Then Admin can see Confirm Deletion form disappear

  Scenario: Search by program name
    Given Admin is on Program page
    When Admin enters the program name in search box
    Then Admin should see Program name, description, and status for searched program name

  Scenario: Search by program description
    Given Admin is on Program page
    When Admin enters the program description in search box
    Then Admin should see Program name, description, and status for searched program description

  Scenario: Search by Non-Existent Program Name
    Given Admin is on Program page
    When Admin enters the program that does not exist in search box
    Then There should be zero results.

  Scenario: Search by partial program name
    Given Admin is on Program page
    When Admin enters the partial name of program in search box
    Then Admin should be able to see Program name, description, and status for searched program name

  Scenario: Sorting of Program name in Ascending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to program Name
    Then Admin should See the Program Name is sorted in Ascending order

  Scenario: Sorting of Program name in Descending order
    Given Admin is in program page where Program names are sorted in ascending order
    When Admin clicks on Arrow next to program Name
    Then Admin should See the Program Name is sorted in Descending order

  Scenario: Sorting of Program Description in Ascending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to Program Description
    Then Admin should See the program Description is sorted in Ascending order

  Scenario: Sorting of Program Description in Descending order
    Given Admin is in program page where Program description are sorted in ascending order
    When Admin clicks on Arrow next to Program Description
    Then Admin should See the program Description is sorted in Descending order

  Scenario: Sorting of program status in Ascending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to Program status
    Then Admin should see the Program status sorted in Ascending order

  Scenario: Sorting of Program status in Descending order
    Given Admin is in program page where Program status are sorted in ascending order
    When Admin clicks on Arrow next to Program status
    Then Admin should see the Program status sorted in Descending order

  Scenario: Next Page Navigation
    Given Admin is on Program page with multiple program records
    When Admin clicks the next page option (>) in the pagination control
    Then Admin should navigate to the next page and see the next set of program records

  Scenario: Last Page Navigation
    Given Admin is on any page except the last page of Program table
    When Admin clicks the last page option (>>) in the pagination control
    Then Admin should see the last page record on the table

  Scenario: Previous Page Navigation
    Given Admin is on the Program table on any page except the first page
    When Admin clicks the previous page option (<) in the pagination control
    Then Admin should see the previous page record on the table

  Scenario: First Page Navigation
    Given Admin is on any page except the first page of Program table
    When Admin clicks the first page option (<<) in the pagination control
    Then Admin should see the very first page record on the table

 

  Scenario: Pagination when there are no records
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then "Showing 0 to 0 of 0 entries" should be displayed

  

  Scenario: Pagination when there are less than 5 records
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see pagination icons disabled
