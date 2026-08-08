Feature: Manage Batch - Search Bar
  As an Admin, I want to search batches using the search bar
  by various fields and verify the filtered results

  Background:
    Given Admin is on the Batch page for search - Batch

  Scenario: Search by Batch name
    When Admin enters the batch name in the search box - Batch
    Then Admin should see the filtered batch details based on the batch name in the data table - Batch

  Scenario: Search by Batch description
    When Admin enters the batch description in the search box - Batch
    Then Admin should see the filtered batch details based on the batch description in the data table - Batch

  Scenario: Search by Program name
    When Admin enters the Program name in the search box - Batch
    Then Admin should see the filtered batch details based on the program name in the data table - Batch

  Scenario: Search by number of classes
    When Admin enters the number of classes in the search box - Batch
    Then Admin should see the filtered batch details based on the number of classes in the data table - Batch

  Scenario: Search by non-existing batch name
    When Admin enters a non-existing batch name in the search box - Batch
    Then Admin should see no results displayed - Batch

  Scenario: Search by batch status
    When Admin enters the batch status in the search box - Batch
    Then Admin should see the filtered batches by batch status in the data table - Batch