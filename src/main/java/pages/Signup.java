package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup {
	WebDriver driver;

	@FindBy(xpath = "//a[contains(@href,'signonForm')]")
	WebElement Signin;

	@FindBy(xpath = "//a[contains(@href,'newAccountForm')]")
	WebElement Register;

	@FindBy(name = "username")
	WebElement inputUsername;

	@FindBy(name = "password")
	WebElement inputPassword;

	@FindBy(name = "repeatedPassword")
	WebElement inputRepeat;

	@FindBy(name = "firstName")
	WebElement inputFirstName;

	@FindBy(name = "lastName")
	WebElement inputLastName;

	@FindBy(name = "email")
	WebElement inputEmail;

	@FindBy(name = "phone")
	WebElement inputPhone;

	@FindBy(name = "address1")
	WebElement inputAddress;
	
	@FindBy(name = "address2")
	WebElement inputAddress2;

	@FindBy(name = "city")
	WebElement inputCity;

	@FindBy(name = "state")
	WebElement inputState;

	@FindBy(name = "zip")
	WebElement inputZip;

	@FindBy(name = "country")
	WebElement inputCountry;

	@FindBy(xpath = "//button[text()='Save Account Information']")
	WebElement buttonSave;

	public Signup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void signin() {
		Signin.click();
	}

	public void register() {
		Register.click();
	}

	public void uname(String user) {
		inputUsername.sendKeys(user);
	}

	public void password(String pwd) {
		inputPassword.sendKeys(pwd);
		inputRepeat.sendKeys(pwd);
	}

	public void fname(String first) {
		inputFirstName.sendKeys(first);
	}

	public void lname(String last) {
		inputLastName.sendKeys(last);
	}

	public void email(String mail) {
		inputEmail.sendKeys(mail);
	}

	public void phone(String ph) {
		inputPhone.sendKeys(ph);
	}

	public void address(String add) {
		inputAddress.sendKeys(add);
	}
	public void address2(String address) {
		inputAddress2.sendKeys(address);
	}

	public void city(String c) {
		inputCity.sendKeys(c);
	}

	public void state(String s) {
		inputState.sendKeys(s);
	}

	public void zip(String z) {
		inputZip.sendKeys(z);
	}

	public void country(String c) {
		inputCountry.sendKeys(c);
	}
	public void save() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    wait.until(ExpectedConditions.elementToBeClickable(buttonSave));

	    Actions act = new Actions(driver);
	    act.moveToElement(buttonSave).click().perform();
	}

	}
