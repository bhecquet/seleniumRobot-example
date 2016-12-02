Feature: Qwant

	Scenario: search
		Given access qwant
		When type 'peanut'
		And start search
		Then check result contains 'peanut'