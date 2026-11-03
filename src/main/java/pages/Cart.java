package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
    WebDriver driver;

    @FindBy(xpath = "(//a[@href='/categories/DOGS'])[1]")
    WebElement dogs;

    @FindBy(xpath = "//a[@href='/products/K9-PO-02']")
    WebElement bulldog;

    @FindBy(xpath = "//a[@href='/cart/addItemToCart?itemId=EST-31']")
    WebElement addtocart;

    @FindBy(xpath = "//input[@name='EST-31']")
    WebElement quantity;

    @FindBy(xpath = "//button[text()='Update Cart']")
    WebElement update;

    @FindBy(xpath = "//a[@href='/order/newOrderForm']")
    WebElement proceed;

    public Cart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // scrolls to the element and clicks it with JavaScript,
    // so a banner or footer cannot block the click
    void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void category() {
        click(dogs);
    }

    public void sproduct() {
        click(bulldog);
    }

    public void addtocartt() {
        click(addtocart);
    }

    public void qty(String number) {
        quantity.clear();
        quantity.sendKeys(number);
    }

    public void updatee() {
        click(update);
    }

    public void checkout() {
        click(proceed);
    }
}