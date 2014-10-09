package com.itechart.ui.service;

import com.itechart.driver.page.PageFactory;
import com.itechart.driver.seleniumdriver.SeleniumDriver;
import com.itechart.ui.pages.MainPage;
import com.itechart.ui.pages.ResultsPage;

public class TestService {
	private SeleniumDriver driver;

	public TestService(SeleniumDriver driver) {
		this.driver = driver;
	}

	public int getSearchCountReturnsGreaterThanZero(String query) {
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.openScreen().typeQuery(query);
		ResultsPage resultsPage = mainPage.clickSearchButton();
		resultsPage.checkPage();
		return resultsPage.getSearchedResults().size();
	}

}
