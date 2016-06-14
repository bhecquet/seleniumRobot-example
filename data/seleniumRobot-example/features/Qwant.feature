Feature: Qwant

	Scenario: qwant
		When saisir cacahuète
		Then clique rechercher
		Then clique lien numéro 2
		Then clique mot graine
		Then rechercher présence mot cornichon