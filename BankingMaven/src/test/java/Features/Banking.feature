#Author: Swapna
@PrimusBankFeature
Feature: Primus Bank Features

  @CreateBranchTC1
  Scenario: Create a Branch
    Given Admin logs in to Primus Bank Application
    When Click on Branches button
    And Click on New Branch button
    Then Enter Branch details
    Then Click on Submit button
    Then Close The Browser

  #@CreateBranch_TC2
  #Scenario Outline: Create Branch testcase 2
    #Given Admin logs in to Primus Bank Application
    #When Click on Branches button
    #And Click on New Branch button
    #Then Enter Branch details as "<BranchName>","<Branch_Add1>","<Branch_Add2>","<Area>","<Branch_Zipcode>","<Branch_Country>","<Branch_State>","<Branch_City>"
    #Then Click on Submit button
    #Then Close The Browser
#
    #Examples: 
    #	|user name|Password| BranchName    | Branch_Add1 | Branch_Add2 | Area  | Branch_Zipcode | Branch_Country | Branch_State   | Branch_City |
      #| AmeerpetBank1 | Ameerpet1   | ABCABC      | ETEYY |         999496 | INDIA          | Andhra Pradesh | Hyderabad   |
#			