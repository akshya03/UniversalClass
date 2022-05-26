@tag
Feature: Forgot password

	@tag1
	Scenario: Validate redirection to Forgot Password page
	Given The home page is loaded
	When the user clicks on Header menu
	And selects Sign In
	When the user clicks on Forgot Password
	Then the website is redirected to Forgot Password page
	
	@tag2
	Scenario: Validate Forgot Password functionality
	Given The home page is loaded
	When the user clicks on Header menu
	And selects Sign In
	When the user clicks on Forgot Password
	When the user enters EmailId and clicks on Recover Password
	Then password reset link is sent to email
	