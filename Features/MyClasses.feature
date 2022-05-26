@tag
Feature: My Classes

	@tag1
	Scenario: Verification of display of all categories under Course Catalog
	Given The home page is loaded
	When the user clicks on Header menu
	And selects Sign In
	And Email and Password textboxes are accessible
	When the user enters emailID in Email textbox
	And enters a password for the emailID in Password textbox
	And clicks SignIn
	When the user clicks on My Classes tab on home page
	Then all the enrolled classes for the loggin-in account are displayed