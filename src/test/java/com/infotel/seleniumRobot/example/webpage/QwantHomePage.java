package com.infotel.seleniumRobot.example.webpage;


import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.seleniumtests.driver.BrowserType;
import com.seleniumtests.driver.CustomEventFiringWebDriver;
import com.seleniumtests.uipage.PageObject;
import com.seleniumtests.uipage.htmlelements.ButtonElement;
import com.seleniumtests.uipage.htmlelements.HtmlElement;
import com.seleniumtests.uipage.htmlelements.ScreenZone;
import com.seleniumtests.uipage.htmlelements.TextFieldElement;
import com.seleniumtests.util.logging.SeleniumRobotLogger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QwantHomePage extends PageObject{
	
	private static Logger logger = SeleniumRobotLogger.getLogger(QwantHomePage.class);
	private static final TextFieldElement searchTextBox = new TextFieldElement("search Text Box", By.className("search_bar__form__input"));
	private static final ButtonElement searchButton = new ButtonElement("search Button", By.className("search_bar__form__search"));
 	private static final HtmlElement resultPane = new HtmlElement("results", By.className("results-column--web"));
 	private static final HtmlElement result = new HtmlElement("result", By.className("result--web--link"));
	
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
    	searchTextBox.sendKeys(search);
    	return this;
    }
    
    @When("start search")
    public QwantHomePage _search() {
    	logger.debug("search");
    	if (((CustomEventFiringWebDriver)driver).getBrowserInfo().getBrowser() == BrowserType.INTERNET_EXPLORER) {
    		searchTextBox.sendKeys(false, false, Keys.ENTER, Keys.ENTER);
    	} else {
    		searchButton.click();
    	}
	    return this;
    }
    
    @When("start search")
    public QwantHomePage _clickFirstResult() {
    	new Actions(driver).moveToElement(result).click().perform();
    	return this;
    }
    


}
