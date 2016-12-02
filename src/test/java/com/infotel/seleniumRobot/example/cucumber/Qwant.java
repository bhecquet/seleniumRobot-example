package com.infotel.seleniumRobot.example.cucumber;



import com.infotel.seleniumRobot.example.webpage.QwantHomePage;

import cucumber.api.java.en.Given;

public class Qwant {
	
	@Given("access qwant")
	public void access() throws Exception {
		new QwantHomePage(true);
	}
}


