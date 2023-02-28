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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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

        driver.get("https://mystore-testlab.coderslab.pl");  //wchodzę na stronę my store


    }

    @And("I sign in")
    public void signIn() {
        driver.findElement(By.className("user-info")).click();
    }  // klikam w signIN


    @When("I login using (.+) and (.+)$")
    public void iLoginUsingAnd(String email, String password) {      // logowanie za pomocą emaila i hasła
        ShopLoginPage loginPage = new ShopLoginPage(driver);
        loginPage.loginAs("jin4ster.pr1@gmail.com", "terakonia84");
    }

    @And("I open my address page")
    public void iOpenMyAddressPage() {

        driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span/i")).click(); //klik w adres
        // driver.findElement(By.xpath("//*[@id=\"address-32322\"]/div[2]/a[1]/span")).click(); // klik w zmiana adresu
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span")).click(); // klik nowy adres
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
        // wypelnienie formulaza z wczesnijeszym czyszczeniem pol

    }


    @Then("success message with text {string}")
    public void successMessageWithText(String msgText) {
        WebElement alert = driver.findElement(By.cssSelector("alert.alert-success"));
        assertTrue(alert.isDisplayed());
        assertEquals(msgText, alert.getText());  //sprawdzanie porpawnosci danych asercjami

    }

//    @And("I delete new address")
//    public void iDeleteNewAddress() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("fog")));
//        WebElement deleteButton = driver.findElement(By.cssSelector("Delete"));
//        deleteButton.click();
//    }
//
//
//        @And("New adress is delete")
//        public void newAdressIsDelete (String msgText1){
//            WebElement alert = driver.findElement(By.cssSelector(".alert.alert-success"));
//            assertTrue(alert.isDisplayed());
//            assertEquals(msgText1, alert.getText());
//            // Asercja sprawdzająca, czy adres został usunięty
//        boolean isAddressDeleted = driver.findElements(By.cssSelector("Alias02")).isEmpty();
//        assertTrue(isAddressDeleted);
//        }
//
//        @And("I close Shop browser")
//        public void iCloseShopBrowser () {
//            driver.close();
//        }
    }




