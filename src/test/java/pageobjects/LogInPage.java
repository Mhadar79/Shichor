package pageobjects;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{

	@FindBy(css="[class=\"btn-dark-blue btn\"]")
	private WebElement logInBtn;
	@FindBy(css="#email")
	private WebElement emailField;
	@FindBy(css="[name=\"password\"]")
	private WebElement passwordField;
	@FindBy(css="[class=\"sign-in-form__footer\"] [class=\"btn btn-link\"]")
	private WebElement forgotPassword;
	@FindBy(css="[class=\"btn-blue btn-fluid btn\"]")
	private WebElement loginButton;
	@FindBy(css="[class=\"form-error-message\"]")
	private WebElement formErrMsg;
	@FindBy(css="[class=\"modal-v2__close-button\"]")
	private WebElement closeBtn;
	@FindBy(css="[class=\"form-error\"]")
	private WebElement errorDetailsMsg;
	@FindBy(css="[class=\"vector-icon hanukkah-popup__exit-icon\"]")
	private WebElement closeWindow;
	
	
	
	
	public LogInPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void login(String user, String password) throws AWTException, InterruptedException{
		Robot robot = new Robot();
		for (int i = 0; i < 4; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		sleep(12000);
		waitForLoad(closeWindow);
		click(closeWindow);
		waitForLoad(logInBtn);
		click(logInBtn);
		fillText(emailField, user);
		fillText(passwordField, password);
		click(loginButton);
	}
	
	public String requiredMsg() {
		return getText(formErrMsg);
	}
	
	public void clearEmailField(String user) {
		fillText(emailField, user);
		clearText(emailField);
		click(passwordField);
	}
	public void clickOnLogin() {
		waitForLoad(logInBtn);
		click(logInBtn);
	}
	public void closeLogIn() {
		click(closeBtn);
	}
	
	public String errorDetails() {
		sleep(1500);;
		return getText(errorDetailsMsg);
	}

}
