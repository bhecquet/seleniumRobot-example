package com.infotel.seleniumTests.qwantTest.cucumber;



import org.testng.Assert;

import com.infotel.seleniumTests.qwantTest.webpage.QwantHomePage;
import com.seleniumtests.uipage.Locator;
import com.seleniumtests.uipage.htmlelements.LinkElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Qwant {
	private QwantHomePage myHomePage;
	
	private LinkElement linkToClick;
	private LinkElement linkWordToFind;

	@When("saisir '(.*?)'")
	public void saisirChaineAChercher(String search) throws Exception {
		myHomePage = new QwantHomePage(true).search(search);
	}
	
	@When("clique rechercher")
	public void rechercher() throws Exception {
		myHomePage.search();	
	}
	
	@When("clique lien numéro (\\d+)")
	public void cliquerLienWikipedia(Integer num) throws Exception {
		linkToClick = new LinkElement("first Result", Locator.locateByXPath("(//span[@class='result--web--title'])["+num+"]"));
		linkToClick.click();
		myHomePage.selectNewWindow();
	}
	
	@When("clique mot (.*?)")
	public void cliquerLienLievre(String keyWord) throws Exception {
		linkWordToFind = new LinkElement("keyWord Link", Locator.locateByLinkText(keyWord));
		linkWordToFind.click();
	}
	
	@Then("rechercher présence mot '(.*?)'")
	public void rechercherMotGibier(String searchWord) throws Exception {	
		Assert.assertTrue(myHomePage.isTextPresent(searchWord));
	}
}


