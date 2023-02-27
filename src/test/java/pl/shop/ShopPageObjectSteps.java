package pl.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.netty.buffer.ByteBufUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class ShopPageObjectSteps {
    private WebDriver driver;

    @Given("I'm on the shop main page") // konfiguracja przeglondarki 1 krok gerkina
    public void openShopMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl");


    }

   @When("I sign in")
    public void signIn() {
        driver.findElement(By.className("user-info")).click();
   }


    @And("I login using \"(.+)\" and \"(.+)\"$")
    public void iLoginUsingAnd(String email, String password) {
        ShopLoginPage loginPage = new ShopLoginPage(driver);
        loginPage.loginAs("jin4ster.pr1@gmail.com", "terakonia84");
    }

    @And("I open my address page")
    public void iOpenMyAddressPage() {
        driver.findElement(By.className("link-item")).click();
    }
}


