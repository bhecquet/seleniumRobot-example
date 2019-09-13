package com.infotel.seleniumRobot.example.tests;

import org.testng.annotations.Test;

import com.infotel.seleniumRobot.example.webpage.QwantHomePage;
import com.seleniumtests.core.runner.SeleniumTestPlan;
import com.seleniumtests.reporter.logger.TestLogging;

public class QwantSearchManualSteps extends SeleniumTestPlan {

	@Test(groups={"integration"})
	public void testSearchManualSteps() throws Exception {
		addStep("Start");
		QwantHomePage page = new QwantHomePage(true);
		
		addStep("Search text");
		page._searchText("peanut");
		page._search();
		TestLogging.logTestValue("key", "search done", "peanut");
		
		addStep("display results");
		page._checkResultContains("peanut");
	}
}
