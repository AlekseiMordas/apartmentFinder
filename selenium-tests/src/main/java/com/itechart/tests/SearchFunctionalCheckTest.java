package com.itechart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itechart.ui.LocationEnum;

public class SearchFunctionalCheckTest extends BaseTest {

	@Test(dataProvider = "locations")
	public void SearchCountReturnsGreaterThanZeroTest(String location) {
		int count = service.getSearchCountReturnsGreaterThanZero(location);
		Assert.assertTrue(
				count > 0,
				"There are no results according your search criteria. Expected counts: >0, Actual: "
						+ count);
	}
	
	@DataProvider(name = "locations")
	private Object[][] provideLocations() {
		return new String[][] { { LocationEnum.AK.toString() },
				{ LocationEnum.FL.toString() }, { LocationEnum.GA.toString() },
				{ LocationEnum.IL.toString() }, { LocationEnum.TX.toString() } };
	}

}
