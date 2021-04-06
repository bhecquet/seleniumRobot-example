package com.infotel.seleniumRobot.example.webpage;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumtests.driver.BrowserType;
import com.seleniumtests.driver.CustomEventFiringWebDriver;
import com.seleniumtests.driver.screenshots.SnapshotCheckType;
import com.seleniumtests.uipage.ByC;
import com.seleniumtests.uipage.PageObject;
import com.seleniumtests.uipage.htmlelements.ButtonElement;
import com.seleniumtests.uipage.htmlelements.HtmlElement;
import com.seleniumtests.uipage.htmlelements.TextFieldElement;
import com.seleniumtests.util.logging.SeleniumRobotLogger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QwantHomePage extends PageObject{
	
	private static Logger logger = SeleniumRobotLogger.getLogger(QwantHomePage.class);
	private static final TextFieldElement searchTextBox = new TextFieldElement("search Text Box", By.name("q"));
	private static final ButtonElement searchButton = new ButtonElement("search Button", ByC.attribute("aria-label", "Rechercher sur le web"));
 	private static final HtmlElement resultPane = new HtmlElement("results", ByC.attribute("data-testid", "containerWeb"));
 	private static final HtmlElement result = new HtmlElement("result", ByC.attribute("data-testid", "webResult"));
 	private static final HtmlElement news = new HtmlElement("news", By.className("v4_news_block"));
	
	public QwantHomePage() throws Exception {
		super(searchTextBox);
	}
	public QwantHomePage(boolean openPageURL, BrowserType browserType) throws Exception {
		super(searchTextBox, param("appURL"), browserType, "other", null);
	}
	
	public QwantHomePage(boolean openPageURL) throws Exception {
        super(searchTextBox, openPageURL ? param("appURL") : null);
    }
    
    public boolean isSearchBoxDisplayed() {
        return searchTextBox.isDisplayed();
    }
    
    @Then("check result contains '(.*?)'")
    public QwantHomePage _checkResultContains(String word) {
    	logger.debug("checkResultContains");
    	new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElement(resultPane, word));
    	return this;
    }
    
    @When("type '(.*?)'")
    public QwantHomePage _searchText(String search) {
    	logger.debug("searchText");

    	capturePageSnapshot("before_search", SnapshotCheckType.TRUE);
    	searchTextBox.sendKeys(true, false, search);
    	return this;
    }
    
    @When("start search")
    public QwantHomePage _search() {
    
    	logger.debug("search");
    	if (((CustomEventFiringWebDriver)driver).getBrowserInfo().getBrowser() == BrowserType.INTERNET_EXPLORER) {
    		searchTextBox.sendKeys(false, false, Keys.ENTER, Keys.ENTER);
    	} else {
    		searchTextBox.sendKeys(false, false, Keys.ENTER);
    	}
	    return this;
    }
    
    @When("start search")
    public QwantHomePage _clickFirstResult() {
    	captureElementSnapshot("result",  result, SnapshotCheckType.TRUE.withThreshold(1.5));
    	new Actions(driver).moveToElement(result).click().perform();
    	return this;
    }
    


}
