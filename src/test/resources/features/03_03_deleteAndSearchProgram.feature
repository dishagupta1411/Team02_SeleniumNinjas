Feature: Delete Program Module

Background: Admin is logged in to LMS Portal
   Given Admin is in login Page to test Program module
   When Admin enter valid credentials and clicks login button through keyboard for Program module 
 
 
 @Program @ConfirmDeleteDialogBox
 Scenario: Display Delete Confirmation
    Given Admin is on Program page
    When Admin clicks on delete icon for a program
    Then Admin will get confirm deletion dialog box
    
  @Program @DeletionWindowDisappear
   Scenario: Close Delete Confirmation
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When  Admin clicks X button
    Then Admin can see Confirm Deletion form disappear
    
     @Program @ConfirmDeletion
  Scenario: Delete Program Successfully
    Given Admin is on Confirm deletion form
    When Admin clicks on Yes button
    Then Admin can see 'Program Deleted' message 
    
    @Program @MultipleDeleteButtonEnabled
     Scenario: Select multiple programs
    Given Admin is on Program page
    When Admin clicks on the multiple checkboxes on program module page
    Then Mulitple delete box under manage program must be enabled
    
    @Program @MultipleDeletionWIndowXButton
    Scenario: Close Multiple deletion confirmation
    Given Admin is on Program page
    When Admin clicks on the multiple checkboxes on program module page
    And Admin clicks  on the left delete button on program module page
    And Admin clicks X button    
    Then Admin can see Confirm Deletion form disappear
    
    
    @Program @MulpipleDeleteButton
    Scenario: Admin validate delete by deleting multiple programs
    Given Admin is on Program page
    When Admin clicks on the multiple checkboxes on program module page
    And Admin clicks  on the left delete button on program module page
    Then Admin able to delete multiple program by clicking yes to confirm
    
    @Program @SearchBoxValidation
   Scenario Outline: Search class by Program Name and Description
   Given Admin is on Program page
    When Admin enter the "<field>" "<value>" in search textbox
    Then Admin should see Program details are searched by given fields
    Examples: 
    |field|       |value|
    |Program Name||Java|
    |Description| |Java|

    @Program @InvalidSearchForProgramName
    Scenario: Search by Non-Existent Program Name
    Given Admin is on Program page
    When Admin enters the program that does not exist in search box
    Then There should see message 'Showing 0 to 0 of 0 entries' results.