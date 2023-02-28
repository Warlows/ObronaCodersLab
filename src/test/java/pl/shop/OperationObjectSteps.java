package pl.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class OperationObjectSteps {
    private WebDriver driver;

    @Given("On the login page")
    public void loginPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @And("I login  (.+) and (.+)$")
    public void iLogIN(String email, String password) {
        ShopLoginPage loginPages = new ShopLoginPage(driver);
        loginPages.loginAs("jin4ster.pr1@gmail.com", "terakonia84");

    }

    @When("I user page i go clothes")
    public void iUserPageIGoClothes() {
        driver.findElement(By.id("category-3")).click();
    }

    @And("I click Hummingbird printed sweater")
    public void iClickHummingbirdPrintedSweater() {
        driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div[2]/article/div/div[1]/a/img")).click();
    }

    @Then("I chose the (.+) and (.+)$")
    public void iChoseTheSizeAndQuantity(String Size, String Quantity) {
        driver.findElement(By.name("group[1]")).sendKeys(Size);
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).sendKeys(Quantity);

    }

    @And("Add to cart")
    public void addToCart() {
        driver.findElement(By.name("submit")).click();
    }

    @Then("go steps on buy")
    public void goStepsOnBuy() {
        driver.findElement(By.name("btn btn-primary")).click();
        driver.findElement(By.name("btn btn-primary")).click();
        driver.findElement(By.name("confirm-addresses")).click();
        driver.findElement(By.name("confirmDeliveryOption")).click();
        driver.findElement(By.name("payment-option-1")).click();
        driver.findElement(By.name("conditions_to_approve")).click();
        driver.findElement(By.name("btn btn-primary center-block")).click();

    }
}