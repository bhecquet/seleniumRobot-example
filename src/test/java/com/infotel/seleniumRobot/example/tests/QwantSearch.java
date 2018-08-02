package com.infotel.seleniumRobot.example.tests;

import org.testng.annotations.Test;

import com.infotel.seleniumRobot.example.webpage.QwantHomePage;
import com.seleniumtests.connectors.mails.EmailClient;
import com.seleniumtests.connectors.mails.EmailClientSelector;
import com.seleniumtests.connectors.mails.EmailServer;
import com.seleniumtests.connectors.mails.EmailServer.EmailServerTypes;
import com.seleniumtests.core.runner.SeleniumTestPlan;

public class QwantSearch extends SeleniumTestPlan {

	@Test(groups={"integration"})
	public void testSearch() throws Exception {
		new QwantHomePage(true)
						.searchText("peanut")
						.search()
						.checkResultContains("peanut")
						;
	}
}
