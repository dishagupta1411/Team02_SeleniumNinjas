Feature: Manage Batch - Sorting
  As an Admin, I want to sort batch records by different columns
  in ascending and descending order

  Scenario: Sorting of batch name in ascending order
    Given Admin is on the Batch page - Batch
    When Admin clicks the sort arrow next to batch name - Batch
    Then Admin should see the batch details sorted by batch name in ascending order - Batch

  Scenario: Sorting of batch name in descending order
    Given Admin is on the Batch page where batch names are sorted in ascending order - Batch
    When Admin clicks the sort arrow next to batch name - Batch
    Then Admin should see the batch name sorted in descending order - Batch

  Scenario: Sorting of batch description in ascending order
    Given Admin is on the Batch page - Batch
    When Admin clicks the sort arrow next to batch description - Batch
    Then Admin should see the batch description sorted in ascending order - Batch

  Scenario: Sorting of batch description in descending order
    Given Admin is on the Batch page where batch descriptions are sorted in ascending order - Batch
    When Admin clicks the sort arrow next to batch description - Batch
    Then Admin should see the batch description sorted in descending order - Batch

  Scenario: Sorting of number of classes in ascending order
    Given Admin is on the Batch page - Batch
    When Admin clicks the sort arrow next to number of classes - Batch
    Then Admin should see the batch details sorted by number of classes in ascending order - Batch

  Scenario: Sorting of number of classes in descending order
    Given Admin is on the Batch page where number of classes are sorted in ascending order - Batch
    When Admin clicks the sort arrow next to number of classes - Batch
    Then Admin should see the batch details sorted by number of classes in descending order - Batch

  Scenario: Sorting of batch status in ascending order
    Given Admin is on the Batch page - Batch
    When Admin clicks the sort arrow next to batch status - Batch
    Then Admin should see the batch status sorted in ascending order - Batch

  Scenario: Sorting of batch status in descending order
    Given Admin is on the Batch page where batch statuses are sorted in ascending order - Batch
    When Admin clicks the sort arrow next to batch status - Batch
    Then Admin should see the batch status sorted in descending order - Batch