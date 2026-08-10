Feature: Sorting Program Module

   Background: Admin is logged in to LMS Portal
   Given Admin is in login Page to test Program module
   When Admin enter valid credentials and clicks login button through keyboard for Program module 


 @Program @SortProgramNameAsc
  Scenario: Sorting of Program name in Ascending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to program Name
    Then Admin should See the Program Name is sorted in Ascending order

  @Program @SortProgramNameDesc
  Scenario: Sorting of Program name in Descending order
    Given  Admin is on Program page
    When Admin clicks on Arrow next to program Name for Descending
    Then Admin should See the Program Name is sorted in Descending order
    
     @Program @SortProgramDescriptionAsc
    Scenario: Sorting of Program Description in Ascending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to Program Description
    Then Admin should See the program Description is sorted in Ascending order
  
  @Program @SortProgramDescriptionDesc
  Scenario: Sorting of Program Description in Descending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to Program Description for Descending
    Then Admin should See the program Description is sorted in Descending order
  
   @Program @SortProgramStatusAsc
  Scenario: Sorting of program status in Ascending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to Program status
    Then Admin should see the Program status sorted in Ascending order
 
 @Program @SortProgramStatusDesc
  Scenario: Sorting of Program status in Descending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to Program status for Descending
    Then Admin should see the Program status sorted in Descending order
