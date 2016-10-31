Feature: Qwant

	Scenario: qwant
		When saisir 'cacahuète'
		And clique rechercher
		And clique lien numéro 2
		#Then clique mot graine
		#Then rechercher présence mot 'cornichon'