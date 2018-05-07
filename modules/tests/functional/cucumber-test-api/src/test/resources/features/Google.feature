Feature: Test the login functionality of Jarvis site

  Scenario: Use google search
	Given I go to google home
	Then I should see 'Google' as the page title