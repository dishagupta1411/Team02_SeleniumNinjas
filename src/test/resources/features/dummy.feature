Feature: Program Module

  Given Admin navigates to program page after logged in
 
     
    
    

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
    
    @Program @Pagination
Scenario: Validate Next Page Navigation
    Given Admin is on Program page with multiple program records
    When Admin clicks the Next page option (>) in the pagination control
    Then Admin should navigate to the next page and see the next set of program records
    
    @Program @Pagination
Scenario: Validate Last Page Navigation
    Given Admin is on any page except the last page of Program table
    When Admin clicks the Last page option (>>) in the pagination control
    Then Admin should see the last page record on the table
    
    @Program @Pagination
Scenario: Validate Previous Page Navigation
    Given Admin is on the Program table on any page except the first page
    When Admin clicks the Previous page option (<) in the pagination control
    Then Admin should see the previous page record on the table
    
    @Program @Pagination
Scenario: Validate First Page Navigation
    Given Admin is on any page except the first page of Program table
    When Admin clicks the First page option (<<) in the pagination control
    Then Admin should see the very first page record on the table
    
    @Program @Pagination
Scenario: Validate Pagination When There Are No Program Records
    Given Admin is logged in to LMS Portal with no records in program list
    When Admin clicks "Program" on the navigation bar
    Then Admin should see "Showing 0 to 0 of 0 entries"
    
    @Program @Pagination
Scenario: Validate Pagination With Less Than 5 Program Records
    Given Admin is logged in to LMS Portal with less than 5 records in program list
    When Admin clicks "Program" on the navigation bar
    Then Admin should see pagination icons disabled

 
  
    
   @Program @n
  Scenario Outline: Validate pagination links 
      When Admin clicks the <pageLink> link on the data table
    Then Admin should see the <results> on the data table

  Examples:
    | pageLink  | results                            |
    | Next      | previous button enabled                 |
    | Last      | next button disabled               |
    | Previous  | first button enabled                 |
    | First     | previous button disabled            |
    
    

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
