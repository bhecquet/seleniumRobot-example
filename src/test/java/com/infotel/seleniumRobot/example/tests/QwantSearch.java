package com.infotel.seleniumRobot.example.tests;

import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;

import com.infotel.seleniumRobot.example.webpage.QwantHomePage;
import com.seleniumtests.core.runner.SeleniumTestPlan;

public class QwantSearch extends SeleniumTestPlan {

	
	@Test(groups={"integration"}, attributes = {@CustomAttribute(name = "testId", values = "239")})
	public void testSearch() throws Exception {

		QwantHomePage hp =new QwantHomePage(true);
		hp._searchText("peanut")
						._search()
						._checkResultContains("peanut")
						._clickFirstResult();
						;
			
	}

}
