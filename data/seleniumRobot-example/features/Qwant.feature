Feature: Qwant

	Scenario: search
		Given access qwant
		When type 'peanut'
		And start search
		Then check result contains 'peanut'

	Scenario: search with failure
		Given access qwant
		When type 'pea@nut'
		And start search
		Then check result contains 'pnut'
		
	Scenario Outline: search <text>
		Given access qwant
		When type '<text>'
		And start search
		Then check result contains '<text>'
		
		Examples:
	    | text 	| 
	    |  toto |  
	    |  titi |  