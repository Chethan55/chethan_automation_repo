@Sample
Feature: Prod DSP bundle validation 

  @DSP_bundles
  Scenario: Validate DSP prod bundles 
    Given I am in Karaf Tool page
    When I login with my credentials 
    And I select "dspwf" in App Name dropdown
    And I click on resolve bundles button
    Then I verify only activemq-blueprint bundles are in resolve state
    And I select "dsproute" in App Name dropdown
    And I click on resolve bundles button
    Then I verify only activemq-blueprint bundles are in resolve state
    And I select "dspsvc" in App Name dropdown
    And I click on resolve bundles button
    Then I verify only activemq-blueprint bundles are in resolve state