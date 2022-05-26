@tag
Feature: Course Catalog

	@tag1
	Scenario: Verification of display of all categories under Course Catalog
	Given The home page is loaded
	When the user clicks on Course Catalog tab on home page
	Then all the course categories are displayed on the screen
	
	@tag2
	Scenario: Verification of display of all courses under a course category
	Given The home page is loaded
	When the user clicks on Course Catalog tab on home page
	And selects a category from displayed results
	Then all the available courses under the category are displayed on the screen