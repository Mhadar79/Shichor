package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import groovy.lang.Buildable;

public class CreateTripPage extends BasePage{
	
	
	@FindBy(css="div:nth-child(1) > div.flows__item-btn.hide-xs.show-md > button")
	private WebElement startPlanBtn;
	@FindBy(css="[class=\"create-trip-back\"]")
	private WebElement backtohomepageBtn;
	@FindBy(css="[class=\"create-trip__title\"]")
	private WebElement createTripTitle;
	@FindBy(css="[class=\"destination-form__field\"]")
	private WebElement destinationFormField;
	@FindBy(css="#react-select-search-bar\\.to-option-0 > div > span")
	private WebElement elementFromList;
	@FindBy(css="[class=\"btn-blue btn\"]")
	private WebElement nextStepBtn;
	@FindBy(css="[class=\"rs-select2__indicators css-1wy0on6\"]")
	private WebElement cancelDestinaionBtn;
	@FindBy(css="[class=\"hero-destination__select css-2b097c-container\"]")
	private WebElement destinationField;
	@FindBy(xpath="//*[@id=\"__next\"]/main/div/div/div/form/div/div/div/div[3]/div/div/div/div/div")
	private WebElement destinationField2;
	@FindBy(css="[class=\"vector-icon hanukkah-popup__exit-icon\"]")
	private WebElement closeWindow;
	@FindBy(css="div.search-dates-menu > div.search-dates-menu__controls > button")
	private WebElement flexibleDatesBtn;
	@FindBy(css="div:nth-child(1) > div:nth-child(2) > div > div:nth-child(1) > div.parties-input__field-input > button:nth-child(3)")
	private WebElement y18_30Up;
	@FindBy(css="div:nth-child(1) > div:nth-child(2) > div > div:nth-child(1) > div.parties-input__field-input > button:nth-child(1)")
	private WebElement y18_30Down;
	@FindBy(css=".sb-desktop__bar-items :nth-child(3)")
	private WebElement whoBtn;
	@FindBy(css = ".sb-desktop__bar-items > div:nth-child(2)")
	WebElement whenBtn;
	@FindBy(css = ".flatpickr-months .flatpickr-month .cur-month")
	List<WebElement> current_month;
	@FindBy(css = " .flatpickr-next-month")
	private WebElement next_month;
	@FindBy(css = ".flatpickr-days > div:nth-child(1)")
	List<WebElement> left_dayContainer;
	@FindBy(css = ".flatpickr-days > div:nth-child(2)")
	List<WebElement> right_dayContainer;
	@FindBy(css="[class=\"flatpickr-days\"] :nth-child(1) > [class=\"flatpickr-day \"]")
	List<WebElement> leftDaysContainer;
	@FindBy(css="[class=\"flatpickr-days\"] :nth-child(2) > [class=\"flatpickr-day \"]")
	List<WebElement> rightDaysContainer;
	@FindBy(css="[class=\"flatpickr-days\"] :nth-child(2) > [class=\"flatpickr-day inRange\"]")
	List<WebElement> dayInRange;
	@FindBy(css=".flatpickr-days > div:nth-child(2)")
	private WebElement rightDays;
	@FindBy(css="[class=\"btn-blue btn\"]")
	private WebElement planTripBtn;
	@FindBy(css=".sb-desktop__bar-items > div:nth-child(4)")
	private WebElement howMuchBtn;
	@FindBy(css=".sb-desktop__bar-items > div:nth-child(5)")
	private WebElement whatBtn;
	@FindBy(css="[class=\"btn-blue apply-filters-button btn\"]")
	private WebElement showResultsBtn;
	@FindBy(css="div.flatpickr-months > div:nth-child(2) > div")
	private WebElement leftMonth;
	@FindBy(css="div.flatpickr-months > div:nth-child(3) > div")
	private WebElement rightMonth;
	@FindBy(css="div.flatpickr-months > div:nth-child(2) > div > div > input")
	private WebElement leftYear;
	@FindBy(css="div.flatpickr-months > div:nth-child(3) > div > div > input")
	private WebElement rightYear;
	
	
	public CreateTripPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickOnStart(String name) {
		waitForLoad(startPlanBtn);
		click(startPlanBtn);
	}
	public void chooseDestination(String name) {
		waitForLoad(destinationFormField);
		sleep(1500);
		Actions actions = new Actions(driver); 
		actions.clickAndHold(destinationField).moveToElement(destinationField2).sendKeys("a")
		.sendKeys("m").sendKeys("s").build().perform();
		sleep(2000);
		actions.moveToElement(elementFromList).click(elementFromList).build().perform();
		
		
	}
	public void clickOnNextStep() {
		sleep(800);
		click(nextStepBtn);
	}
	
	public void chooseFlexible() {
		try {
			click(closeWindow);
		} catch (Exception e) {
			// TODO: handle exception
		}
		sleep(1500);
		click(flexibleDatesBtn);
	}
	
	public void whoCome() {
		sleep(3000);
		waitForLoad(whoBtn);
		Actions actions = new Actions(driver);
		actions.click(whoBtn).build().perform();
	}
	
	public void decreaseAge(String age) {
		sleep(2000);
		List<WebElement> list = driver.findElements(By.cssSelector(".parties-input__field"));
			for (WebElement el : list) {
				WebElement group = el.findElement(By.cssSelector(".parties-input__field-label"));
				if (getText(group).equalsIgnoreCase(age)) {
					WebElement minus = el.findElement(By.cssSelector(".parties-input__field-input > button:nth-child(1)"));
					click(minus);
					break;
				}
				
			}
		
	}
	public void increaseAge(String age) {
		sleep(2000);
		List<WebElement> list = driver.findElements(By.cssSelector(".parties-input__field"));
			for (WebElement el : list) {
				WebElement group = el.findElement(By.cssSelector(".parties-input__field-label"));
				if (getText(group).equalsIgnoreCase(age)) {
					WebElement plus = el.findElement(By.cssSelector(".parties-input__field-input > button:nth-child(3)"));
					click(plus);
					break;
				}
				
			}
		
	}
	
	public void clickOnWhen() {
		sleep(1500);
		Actions actions = new Actions(driver);
		actions.click(whenBtn).build().perform();
		
	}
	
	public void setStart(String day) {
		sleep(1500);
		click(next_month);
		List<WebElement> list = leftDaysContainer;
		for (WebElement el : list) {
			//	System.out.println(el.getText());
				if (getText(el).equalsIgnoreCase(day)) {
					Actions actions = new Actions(driver); 
					actions.moveToElement(el).clickAndHold(el).build().perform();
					break;
				}
			}
	}
	public void setEnd(String day) {
		sleep(3000);
		List<WebElement> list = driver.findElements(By.cssSelector("[class=\"flatpickr-days\"] :nth-child(2) > [class=\"flatpickr-day endRange\"]"));
		for (WebElement el : list) {
			//	System.out.println(el.getText());
				if (getText(el).equalsIgnoreCase(day)) {
					Actions actions = new Actions(driver); 
					actions.moveToElement(el).build().perform();
					sleep(1000);
					click(el);
					break;
				}
			}
		
		
		
	}
	
	public void chooseDates( String day, String day2) {
		click(next_month);
		String month = getText(leftMonth); 
		String month2 = getText(rightMonth);
		String year = leftYear.getAttribute("value");
		String year2 = rightYear.getAttribute("value");
		String date = "[aria-label='" + month + " " + day + ", " + year + "']";
		driver.findElement(By.cssSelector(date)).click();
		String date2 = "[aria-label='" + month2 + " " + day2 + ", " + year2 + "']";
		driver.findElement(By.cssSelector(date2)).click();
		sleep(1500);
		click(planTripBtn);
	}
	
	public void chooseHowMuch(String name) {
		sleep(1500);
		click(howMuchBtn);
		sleep(800);
		List<WebElement> list = driver.findElements(By.cssSelector("div.search-budget-standards > button"));
			for (WebElement el : list) {
				if (getText(el).equalsIgnoreCase(name)) {
					click(el);
					break;
				}
			}
		
	}
	
	public void chooseWhat(String name) {
		sleep(1500);
		click(whatBtn);
		sleep(800);
		List<WebElement> list = driver.findElements(By.cssSelector("div.search-purpose > ul > li button > img"));
		for (WebElement el : list) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
		click(showResultsBtn);
	}
	
	
	
	
}
