package com.infotel.seleniumRobot.example.webpage;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumtests.uipage.PageObject;
import com.seleniumtests.uipage.htmlelements.ButtonElement;
import com.seleniumtests.uipage.htmlelements.HtmlElement;
import com.seleniumtests.uipage.htmlelements.TextFieldElement;
import com.seleniumtests.util.logging.SeleniumRobotLogger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QwantHomePage extends PageObject{
	
	private static Logger logger = SeleniumRobotLogger.getLogger(QwantHomePage.class);
	private static final TextFieldElement searchTextBox = new TextFieldElement("search Text Box", By.className("search_bar__form__input"));
	private static final ButtonElement searchButton = new ButtonElement("search Button", By.className("search_bar__form__search"));
 	private static final HtmlElement resultPane = new HtmlElement("results", By.className("results-column--web"));
	
	public QwantHomePage() throws Exception {
		super(searchTextBox);
	}
	
	public QwantHomePage(boolean openPageURL) throws Exception {
        super(searchTextBox, openPageURL ? param("appURL") : null);
    }
    
    public boolean isSearchBoxDisplayed() {
        return searchTextBox.isDisplayed();
    }
    
    @Then("check result contains '(.*?)'")
    public QwantHomePage checkResultContains(String word) {
    	logger.debug("checkResultContains");
    	new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElement(resultPane, word));
    	return this;
    }
    
    @When("type '(.*?)'")
    public QwantHomePage searchText(String search) {
    	logger.debug("searchText");
    	searchTextBox.sendKeys(search);
    	return this;
    }
    
    @When("start search")
    public QwantHomePage search() {
    	logger.debug("search");
	    searchButton.click();
	    return this;
    }
    


}
