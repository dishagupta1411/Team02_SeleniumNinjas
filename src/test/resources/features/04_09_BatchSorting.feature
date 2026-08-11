Feature: Manage Batch - Sorting
  As an Admin, I want to sort batch records by different columns
  in ascending and descending order
	
	@batchSort01
  Scenario Outline: Sorting of "<column>" in ascending order
    Given Admin is on the Batch page to sort - Batch
    When Admin clicks the sort arrow next to "<column>" for sorting - Batch
    Then Admin should see the batch details sorted by "<column>" in ascending order - Batch

    Examples:
      | column            |
      | batch name        |
      | batch description |
      | no of classes 		|
      | batch status      |
	
	@batchSort02
  Scenario Outline: Sorting of "<column>" in descending order
    Given Admin is on the Batch page where "<column>" is sorted in ascending order - Batch
    When Admin clicks the sort arrow next to "<column>" for sorting - Batch
    Then Admin should see the "<column>" sorted in descending order - Batch

    Examples:
      | column            |
      | batch name        |
      | batch description |
      | no of classes 		|
      | batch status      |