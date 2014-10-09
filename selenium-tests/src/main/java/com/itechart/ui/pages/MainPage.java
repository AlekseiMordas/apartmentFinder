package com.itechart.ui.pages;

import org.openqa.selenium.WebDriver;

import com.itechart.driver.annotation.FindBy;
import com.itechart.driver.element.BrowserElement;
import com.itechart.driver.page.Page;
import com.itechart.driver.page.PageFactory;

public class MainPage extends Page {

	private static final String URL_PAGE = "http://www.apartmentfinder.com/";

	protected WebDriver driver;

	@FindBy(locator = "//input[@id='SearchText']")
	private BrowserElement searchInput;

	@FindBy(locator = "//input[@class='btn-search']")
	private BrowserElement searchButton;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public MainPage openScreen() {
		driver.get(URL_PAGE);
		return PageFactory.initElements(driver, MainPage.class);
	}

	@Override
	public void checkPage() {
		throw new RuntimeException("Need to implement");
	}

	public void typeQuery(String query) {
		searchInput.clear();
		searchInput.type(query);
	}

	public ResultsPage clickSearchButton() {
		searchButton.click();
		return PageFactory.initElements(driver, ResultsPage.class);
	}

}
