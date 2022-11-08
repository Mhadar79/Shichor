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
	// predefined way
	@FindBy(css = ".search-date-periods button")
	List<WebElement> date_periodsBtn;
	@FindBy(css = ".slider-wrapper ")
	WebElement slider_wrapper;
	// manually way
	@FindBy(css = ".flatpickr-months .flatpickr-month:nth-child(2) .numInputWrapper span.arrowUp")
	WebElement arrowUp;
	@FindBy(css = ".flatpickr-months .flatpickr-month .cur-month")
	List<WebElement> current_month;
	@FindBy(css = " .flatpickr-next-month")
	WebElement next_month;
	@FindBy(css = ".flatpickr-days > div:nth-child(1)")
	List<WebElement> left_dayContainer;
	@FindBy(css = ".flatpickr-days > div:nth-child(2)")
	List<WebElement> right_dayContainer;
	
	
	
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
		sleep(1000);
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
		Actions actions = new Actions(driver);
		actions.click(whoBtn).build().perform();
	}
	
	public void decreaseAge(String age) {
		sleep(5000);
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
		sleep(5000);
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
	
	
	
	public void set_flight_munually() {


		DateEngine date = new DateEngine();
	    int desireDay;
	    int desireMonth;
	    
	 
		do {
			desireDay=date.setDesireDay();
			desireMonth=date.setDesireMonth();
			System.out.println(desireDay);
			System.out.println(desireMonth);
		}while(desireDay<=date.getCurrentDay() || desireMonth<=date.getCurrentMonth());
		sleep(1000);
	    Actions actions = new Actions(driver);
	    actions.click(whenBtn).build().perform();
	    sleep(600);
	    
	    
	    boolean state=true;
	    int counter=0;
	    do {
	    	for (WebElement el : current_month) {
	    		
				if(el.getText().equalsIgnoreCase(date.getMonths()[desireMonth-1])) {
						state=false;
					}
				if(!el.getText().equalsIgnoreCase(date.getMonths()[desireMonth-1])) {
						counter++;
					}
				if(counter==2) {
					sleep(600);
					click(next_month);
					counter=0;
				}
			}
	    }while(state);
	    
		
		 counter=0; //find the desire month and click on the desire day
		 int to= 0;
		 List<WebElement> currentContainer= null,currentContainer1 =  null;
	    for (WebElement el : current_month) {
    		
			if(el.getText().equalsIgnoreCase(date.getMonths()[desireMonth-1])) {
					switch(counter) {
					case 0:
						currentContainer=left_dayContainer;
						break;
					case 1:
						currentContainer = right_dayContainer;
						break;
					}
					for (WebElement day : currentContainer) {
						if(day.getText().equalsIgnoreCase(String.valueOf(desireDay))) {
							actions.moveToElement(day).click(day).build().perform();
							sleep(1000);
							System.out.println("wow");
							break;
						}
					}
					if(desireDay+date.getVacation_length()<=date.getMonthSize()) {
						currentContainer=left_dayContainer; // because after click the right container pop to left(might be bug:functionality)
						 to =desireDay+date.getVacation_length();
					}
					else {
						currentContainer=right_dayContainer;
						to = date.getVacation_length()-(date.getMonthSize()-desireDay);
					}
					for (WebElement day : currentContainer) {
							if(day.getText().equalsIgnoreCase(String.valueOf(to))) {
								actions.moveToElement(day).click(day).build().perform();
								sleep(1000);
								System.out.println("wow");
								
								break;
							}
						}
					break;	
					}

	    	else {
	    		counter++;
	    	}
	  }
	}
	
	
}
