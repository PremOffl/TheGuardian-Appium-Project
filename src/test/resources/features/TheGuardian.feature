@TheGuardian 
Feature: Verify the news article is valid by checking other sources 

@ValidateFirstNews 
Scenario Outline: Validate the first news in the guardian.com is valid 
	Given I launch the url and navigate to <Path> section 
	When I select the first news in the guardians portal 
	And Search in <source> with the first news 
	Then I verify whether the first news article is valid or invalid 
	
	Examples: 
		| Path       | source |
		| /tone/news | google |
		
		
