package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Browse {
    WebDriver driver;

    @FindBy(xpath = "(//a[@href='/categories/REPTILES'])[1]")
    WebElement reptiles;

    @FindBy(xpath = "(//a[@href='/products/RP-SN-01'])[1]")
    WebElement rattlesnake;

    @FindBy(xpath = "(//a[@href='/products/RP-SN-01/items/EST-11'])[1]")
    WebElement item;

    public Browse(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void category() {
        click(reptiles);
    }

    public void product() {
        click(rattlesnake);
    }

    public void itemdetails() {
        click(item);
    }
}