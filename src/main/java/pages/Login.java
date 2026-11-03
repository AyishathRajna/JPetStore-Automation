package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(@href,'signonForm')]")
    WebElement Login;

    @FindBy(name = "username")
    WebElement textInputUsername;

    @FindBy(name = "password")
    WebElement textInputPassword;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement buttonLogin;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // true if the "Sign In" link is shown (it is not shown when you are already signed in)
    public boolean signInShown() {
        return !driver.findElements(By.xpath("//a[contains(@href,'signonForm')]")).isEmpty();
    }

    public void loginclick() {
        Login.click();
    }

    // the login form already has a default name and password, so clear them first
    public void Lname(String user) {
        textInputUsername.clear();
        textInputUsername.sendKeys(user);
    }

    public void Pssword(String pwd) {
        textInputPassword.clear();
        textInputPassword.sendKeys(pwd);
    }

    public void clicklogin() {
        buttonLogin.click();
    }
}