package com.itechart.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.itechart.driver.annotation.FindBy;
import com.itechart.driver.element.BrowserElement;
import com.itechart.driver.page.Page;

public class ResultsPage extends Page {

	protected WebDriver driver;

	@FindBy(locator = "//h1[@class='title ac']")
	private BrowserElement errorMessage;

	@FindBy(locator = "//div[@class='results']/div[contains(@class,'listing')]")
	private BrowserElement resultList;

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void checkPage() {
		if (errorMessage.isExists()) {
			throw new RuntimeException("Error message: "
					+ errorMessage.getText());
		}
	}

	public List<WebElement> getSearchedResults() {
		By by = By.xpath(resultList.getFoundBy());
		List<WebElement> list = driver.findElements(by);
		return list;
	}

}
