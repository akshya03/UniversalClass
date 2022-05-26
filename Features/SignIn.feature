@tag
Feature: SignIn user
	
	@tag1
	Scenario: Validate redirection to SignIn page
	Given The home page is loaded
	When the user clicks on Header menu
	And selects Sign In
	Then SignIn page is loaded
	
	@tag2
	Scenario: Validate SignUp functionality
	Given The home page is loaded
	When the user clicks on Header menu
	And selects Sign In
	And Email and Password textboxes are accessible
	When the user enters new emailID in Email textbox
	And enters a password for the emailID in Password textbox
	And clicks SignIn
	Then a new account is created with given emailID
	
	@tag3
	Scenario: Validate SignIn functionality
	Given The home page is loaded
	When the user clicks on Header menu
	And selects Sign In
	And Email and Password textboxes are accessible
	When the user enters emailID in Email textbox
	And enters a password for the emailID in Password textbox
	And clicks SignIn
	Then user is logged-in and page is redirected to home page
	
	@tag4
	Scenario: Validate error message in case of incorrect password
	Given The home page is loaded
	When the user clicks on Header menu
	And selects Sign In
	And Email and Password textboxes are accessible
	When the user enters emailID in Email textbox
	And enters an invalid password for the emailID in Password textbox
	And clicks SignIn
	Then error message is displayed