package tests;

import java.awt.AWTException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import pageobjects.CreateTripPage;
import pageobjects.HomePage;
import pageobjects.LogInPage;

public class PlaningFlowTest extends BaseTest{
	
	
	@Test
	public void tc07_PlaningTest() throws AWTException, InterruptedException {
	LogInPage lp = new LogInPage(driver);
	lp.login("mh18979@gmail.com", "M18h09#79");
	HomePage hp = new HomePage(driver);
	hp.StartPlanBtn();
	CreateTripPage ctp = new CreateTripPage(driver);
	ctp.clickOnStart("Start planning");
	ctp.chooseDestination("amste");
	ctp.clickOnNextStep();
	ctp.chooseFlexible();
	ctp.whoCome();
	ctp.whoCome();
	ctp.decreaseAge("18 - 30 y.o.");
	ctp.increaseAge("31 - 45 y.o.");
	ctp.increaseAge("31 - 45 y.o.");
	ctp.increaseAge("4 - 8 y.o.");
	ctp.increaseAge("9 - 13 y.o.");
	ctp.set_flight_munually();
	}
}
