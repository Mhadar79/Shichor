package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyTripPage extends BasePage{
	
	@FindBy(css="[class=\"trip-item\"]")
	private WebElement tripItem;
	@FindBy(css="[class=\"trip-item__control\"]")
	private WebElement editTripName;
	@FindBy(css="[class=\"trip-item__control trip-item__control--delete\"]")
	private WebElement deleteTrip;
	@FindBy(css="[class=\"btn btn-link\"]")
	private WebElement tripInfo;
	@FindBy(css="[class=\"input__input\"]")
	private WebElement nameField;
	@FindBy(css="[class=\"input__input input__input--error\"]")
	private WebElement emptyNameField;
	@FindBy(css="[class=\"btn btn-dark-blue-outlined btn-fluid trip-title-form__control-cancel btn\"]")
	private WebElement cancelBtn;
	@FindBy(css="[class=\"btn-blue btn-fluid trip-title-form__control-save btn\"]")
	private WebElement saveBtn;
	@FindBy(css="[class=\"trip-title-form__title\"]")
	private WebElement renameTitle;
	

	public MyTripPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void editName(String name) {
		sleep(5000);
		click(editTripName);
		deleteKeys(nameField);
		sleep(800);
		fillTextNoClear(emptyNameField, name);
		click(saveBtn);
	}

}
