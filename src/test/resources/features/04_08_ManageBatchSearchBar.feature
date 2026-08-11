Feature: Manage Batch - Search Bar
  As an Admin, I want to search batches using the search bar
  by various fields and verify the filtered results
  
  @batchSearch01
  Scenario Outline: Search by "<searchType>"
    Given Admin is on the batch page - Batch
    When Admin enters the "<searchType>" in the search box - Batch
    Then Admin should see the filtered batch details based on "<searchType>" in the data table - Batch

    Examples:
      | searchType         |
      | batch name         |
      | batch description  |
      | program name       |
      | number of classes  |
      | batch status       |
   
  @batchSearch02   
	Scenario: Search by Non-existing batch name
    Given Admin is on the batch page - Batch
    When Admin enters the non existing batch name - Batch
    Then Admin should see no results displayed - Batch