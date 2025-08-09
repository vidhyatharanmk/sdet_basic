Feature: WebDriverUniversity Page Validation

Scenario: Validate page title and carousel image

	Given I launch WebDriverUniversity homepage
	Then Page title should be "Automation & AI Testing Courses by Gianni Bruno | WebDriver University"
	When I click on iframe link
	Then New tab should be opened
	And I verify the image is present
	When I click on right side arrow
	Then Image should change