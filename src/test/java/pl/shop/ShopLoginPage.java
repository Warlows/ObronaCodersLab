package pl.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopLoginPage {
    private final WebDriver driver;

    @FindBy(name = "email")
    private WebElement loginInputElement;

    public ShopLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void loginAs(String email, String password) {
        loginInputElement.click();
        loginInputElement.clear();
        loginInputElement.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }
}
