package com.itechart.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.itechart.browser.Browser;
import com.itechart.service.cli.configs.BrowserConfig;
import com.itechart.ui.service.TestService;

public class BaseTest {

	protected Browser browser;
	protected TestService service;

	@BeforeClass(alwaysRun = true)
	public void suiteSetUp() {
		browser = Browser.getInstance(BrowserConfig.getBrowserType());
		service = new TestService(browser.getSeleniumDriver());
	}

	@AfterClass(alwaysRun = true)
	public void suiteTearDown() {
		browser.close();
	}
}
