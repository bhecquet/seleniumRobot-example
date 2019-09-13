package com.infotel.seleniumRobot.example.tests;

import org.testng.annotations.Test;

import com.infotel.seleniumRobot.example.webpage.QwantHomePage;
import com.seleniumtests.core.runner.SeleniumTestPlan;

public class QwantSearch extends SeleniumTestPlan {

	@Test(groups={"integration"})
	public void testSearch() throws Exception {
		new QwantHomePage(true)
						._searchText("peanut")
						._search()
						._checkResultContains("peanut")
						._clickFirstResult();
						;
	}
}
