package pl.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.buffer.ByteBufUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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


    @And("I login using (.+) and (.+)$")
    public void iLoginUsingAnd(String email, String password) {
        ShopLoginPage loginPage = new ShopLoginPage(driver);
        loginPage.loginAs("jin4ster.pr1@gmail.com", "terakonia84");
    }

    @And("I open my address page")
    public void iOpenMyAddressPage() {

        driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span/i")).click();
        driver.findElement(By.xpath("//*[@id=\"address-32322\"]/div[2]/a[1]/span")).click();
    }

    @And("I enter new address (.+),(.+),(.+),(.+),(.+),(.+)$")
    public void iEnterNewAddress(String Alias, String Address, String City, String Postal_code, String Country, String Phone) {
        driver.findElement(By.name("alias")).clear();
        driver.findElement(By.name("alias")).sendKeys(Alias);
        driver.findElement(By.name("address1")).clear();
        driver.findElement(By.name("address1")).sendKeys(Address);
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys(City);
        driver.findElement(By.name("postcode")).clear();
        driver.findElement(By.name("postcode")).sendKeys(Postal_code);
        driver.findElement(By.name("id_country")).sendKeys(Country);
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(Phone);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();

    }


    @Then("I can see success message whit text {string}")
    public void iCanSeeSuccessMessageWhitText(String msgText) {
        WebElement alert = driver.findElement(By.cssSelector(".alert.alert-success"));
        assertTrue(alert.isDisplayed());
        assertEquals(msgText, alert.getText());
    }

    @And("I delete new address")
    public void iDeleteNewAddress() {
        driver.findElement(By.xpath("//*[@id=\"address-32322\"]/div[2]/a[2]/span")).click();
    }

    @And("I can see new address delete*")
    public void iCanSeeNewAddressDelete() {
        driver.findElement(By.xpath("//*[@id=\"content\"]"));
    }
}


