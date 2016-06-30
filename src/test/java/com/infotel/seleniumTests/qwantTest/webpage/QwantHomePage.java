package com.infotel.seleniumTests.qwantTest.webpage;


import org.openqa.selenium.By;

import com.seleniumtests.uipage.Locator;
import com.seleniumtests.uipage.PageObject;
import com.seleniumtests.uipage.htmlelements.ButtonElement;
import com.seleniumtests.uipage.htmlelements.TextFieldElement;

public class QwantHomePage extends PageObject{
	
	private static final TextFieldElement searchTextBox = new TextFieldElement("search Text Box", Locator.locateById("home__input"));
//	private static final ButtonElement searchButton = new ButtonElement("search Button", Locator.locateByCSSSelector("input.autocomplete__submit"));
	private static final ButtonElement searchButton = new ButtonElement("search Button", By.cssSelector("input.autocomplete__submit"));
	
	public QwantHomePage() throws Exception {
		super(searchTextBox);
	}
	
	public QwantHomePage(boolean openPageURL) throws Exception {
        super(searchTextBox, openPageURL ? param("appURL") : null);
    }
    
    public boolean isSearchBoxDisplayed() {
        return searchTextBox.isDisplayed();
    }
    
    public QwantHomePage search(String search) {
    	searchTextBox.sendKeys(search);
    	return this;
    }
    
    public QwantHomePage search() {
	    searchButton.click();
	    return this;
    }
    


}
