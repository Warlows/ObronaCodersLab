package pl.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShopOperation {
    private WebDriver driver;

    @Given("I'm on the main page")
    public void openShopMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.manage().window().maximize();
        this.driver.get("https://mystore-testlab.coderslab.pl");
    }

    @When("I sign in to account")
    public void iSignInToAccount() {
        driver.findElement(By.className("user-info")).click();
    }

    @And("I login (.+) and (.+)$")
    public void iLoginAnd(String email, String password) {
        ShopLoginPage loginPage = new ShopLoginPage(driver);
        loginPage.loginAs("jin4ster.pr1@gmail.com", "terakonia84");
    }
//
//    @And("On the site i search Hummingbird Printed Sweater")
//    public void onTheSiteISearchHummingbirdPrintedSweater() {
//    }
//
//    @And("I check if the discount is active")
//    public void iCheckIfTheDiscountIsActive() {
//    }
//
//    @Then("I chose the size and quantity")
//    public void iChoseTheSizeAndQuantity() {
//    }
//
//    @And("Add to cart")
//    public void addToCart() {
//    }
//
//    @Then("I go to checkout and confirm the address")
//    public void iGoToCheckoutAndConfirmTheAddress() {
//    }
//
//    @And("I chose the payment method and option")
//    public void iChoseThePaymentMethodAndOption() {
//    }
//
//    @And("I click order whit and doing a print screen")
//    public void iClickOrderWhitAndDoingAPrintScreen() {
//    }
}
