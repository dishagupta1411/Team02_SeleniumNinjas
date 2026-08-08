Feature: Batch Page - Pagination
  As an Admin, I want to navigate through the Batch data table
  using pagination controls and verify their enabled/disabled states

  Scenario: Next page navigation
    Given Admin is on the Batch page with multiple batch records - Batch
    When Admin clicks the next page option (>) in the pagination control - Batch
    Then Admin should see the Next page enabled link - Batch

  Scenario: Last page navigation
    Given Admin is on the Batch page except the last page - Batch
    When Admin clicks the last page option (>>) in the pagination control - Batch
    Then Admin should see the last page with Next page link disabled on the table - Batch

  Scenario: Previous page navigation
    Given Admin is on the Batch table on any page except the first page - Batch
    When Admin clicks the previous page option (<) in the pagination control - Batch
    Then Admin should see the previous page on the table - Batch

  Scenario: First page navigation
    Given Admin is on any page except the first page of Batch table - Batch
    When Admin clicks the first page option (<<) in the pagination control - Batch
    Then Admin should see the very first page on the data table - Batch

  Scenario: Previous page arrow disabled on first page
    Given Admin is on the Batch page with multiple pages of batch records - Batch
    When Admin clicks the first page link on the Batch data table - Batch
    Then Admin should see the Previous arrow (<) disabled - Batch

  Scenario: First page arrow disabled on first page
    Given Admin is on the Batch page with multiple pages of batch records - Batch
    When Admin clicks the first page link on the Batch data table - Batch
    Then Admin should see the First page arrow (<<) disabled - Batch

  Scenario: Next page arrow enabled on first page
    Given Admin is on the Batch page with multiple pages of batch records - Batch
    When Admin clicks the first page link on the Batch data table - Batch
    Then Admin should see the Next arrow (>) enabled - Batch

  Scenario: Last page arrow enabled on first page
    Given Admin is on the Batch page with multiple pages of batch records - Batch
    When Admin clicks the first page link on the Batch data table - Batch
    Then Admin should see the Last page arrow (>>) enabled - Batch