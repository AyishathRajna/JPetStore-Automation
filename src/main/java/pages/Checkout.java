package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Checkout {
    WebDriver driver;
    WebDriverWait wait;

    // finds the Continue button by its text (button, link or input)
    @FindBy(xpath = "//button[contains(normalize-space(.),'Continue')] | //input[@value='Continue'] | //a[contains(normalize-space(.),'Continue')]")
    WebElement buttonContinue;

    // finds the Confirm button by its text (button, link or input)
    @FindBy(xpath = "//button[contains(normalize-space(.),'Confirm')] | //input[@value='Confirm'] | //a[contains(normalize-space(.),'Confirm')]")
    WebElement buttonConfirm;

    public Checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // payment and billing details are already filled from the account, so just continue
    public void continuee() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonContinue));
        click(buttonContinue);
    }

    public void confirm() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonConfirm));
        click(buttonConfirm);
    }
}