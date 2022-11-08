package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.DestinationsPage;
import pageobjects.HomePage;
import pageobjects.LogInPage;

public class DestinationTest extends BaseTest{
		
	@Test
	public void tc05_destinationTest() throws AWTException, InterruptedException {
		LogInPage lp = new LogInPage(driver);
		lp.login("mh18979@gmail.com", "M18h09#79");
		HomePage hp = new HomePage(driver);
		hp.clickOnDestinations();
		DestinationsPage dp = new DestinationsPage(driver);
		String actual = dp.getDestiHeader();
		String expected = "Travel anywhere";
		Assert.assertEquals(actual, expected, "Wrong page");
	}
	
	@Test
	public void tc06_destinationTest() {
		DestinationsPage dp = new DestinationsPage(driver);
		dp.popularDestinations("Amsterdam, Netherlands");
		String actual = dp.destination();
		String expected = "Explore Amsterdam";
		Assert.assertEquals(actual, expected, "Wrong page");
	}
	
	
}
