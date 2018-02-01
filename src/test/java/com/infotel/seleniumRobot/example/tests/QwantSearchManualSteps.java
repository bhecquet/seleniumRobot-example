package com.infotel.seleniumRobot.example.tests;

import org.testng.annotations.Test;

import com.infotel.seleniumRobot.example.webpage.QwantHomePage;
import com.seleniumtests.core.runner.SeleniumTestPlan;

public class QwantSearchManualSteps extends SeleniumTestPlan {

	@Test(groups={"integration"})
	public void testSearchManualSteps() throws Exception {
		addStep("Start");
		QwantHomePage page = new QwantHomePage(true);
		
		addStep("Search text");
		page.searchText("peanut");
		page.search();
		
		addStep("display results");
		page.checkResultContains("peanut");
	}
}
