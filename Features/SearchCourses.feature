@tag
Feature: Search Courses
	
	@tag1
	Scenario: Verification of results when valid string is entered in Search for courses textbox
	Given The home page is loaded
	And textbox is available on the home page
	When the user enters a string in textbox
	And clicks on Search icon
	Then the page is redirected to results page with multiple related available courses
	
	@tag2
	Scenario: Verification of results when invalid string is entered in Search for courses textbox
	Given The home page is loaded
	And textbox is available on the home page
	When the user enters an invalid string in textbox
	And clicks on Search icon
	Then error message is returned informing No courses available
	
	@tag4
	Scenario: Verification of course info when a particular course is selected
	Given The home page is loaded
	And textbox is available on the home page
	When the user enters a string in textbox
	And clicks on Search icon
	And selects a course
	Then all the course details are displayed on the screen