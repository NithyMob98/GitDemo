
Feature: Login ino Application Login

  Scenario Outline: Posititve Login validations
    Given Initialize browser with chrome
    	And Navigate to "http://www.qaclickacademy.com/" site
    	And Click on login and land on signin page
    When User login with <Username> and <Password> and logs in
    Then Verify user is succesfully logged in
    And Close browser


Examples:
|Username				|Password				|
|user1					|pass1					|
|user2					|pass2					|

