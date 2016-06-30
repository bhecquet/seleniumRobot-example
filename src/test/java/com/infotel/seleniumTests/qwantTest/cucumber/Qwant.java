package com.infotel.seleniumTests.qwantTest.cucumber;



import com.infotel.seleniumTests.qwantTest.webpage.QwantHomePage;
import com.seleniumtests.uipage.Locator;
import com.seleniumtests.uipage.htmlelements.LinkElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Qwant {
	private QwantHomePage myHomePage;
	
	private LinkElement linkToClick;
	private LinkElement linkWordToFind;

	@When("saisir ([\\p{L}\\s]+)")
	public void saisirToto(String search) throws Exception {
		myHomePage = new QwantHomePage(true).search(search);
	}
	@Then("clique rechercher")
	public void rechercher() throws Exception {
		myHomePage.search();	
	}
	@Then("clique lien numéro (\\d+)")
	public void cliquerLienWikipedia(int num) throws Exception {
		linkToClick = new LinkElement("first Result", Locator.locateByXPath("(//span[@class='result--web--title'])["+num+"]"));
		linkToClick.click();
		myHomePage.selectNewWindow();
	}
	@Then("clique mot (\\p{L}+)")
	public void cliquerLienLievre(String keyWord) throws Exception {
		if(myHomePage.isElementPresent(Locator.locateByLinkText(keyWord))){
		linkWordToFind = new LinkElement("keyWord Link", Locator.locateByLinkText(keyWord));
		linkWordToFind.click();
		}
		else{
			System.out.println("\nle mot : "+keyWord+" ne fait pas partie de la page ou n'est pas un lien.");
		}
	}
	@Then("rechercher présence mot (\\p{L}+)")
	public void rechercherMotGibier(String searchWord) throws Exception {	
		
		if(myHomePage.isTextPresent(searchWord)){
			System.out.println("\nle mot : "+searchWord+" fait parti de la page");
		}
		else{
			System.out.println("\nle mot : "+searchWord+" ne fait pas parti de la page");
		}
	}
}


