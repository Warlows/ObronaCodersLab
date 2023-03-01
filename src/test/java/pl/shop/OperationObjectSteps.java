package pl.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.io.File;
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
    public void iChoseTheSizeAndQuantity(String size, String quantity) {
        WebElement sizeElement = driver.findElement(By.id("group_1"));
        Select sizeDrop = new Select(sizeElement);
        sizeDrop.selectByVisibleText(size);    // Ustawienie elementu rozmiar
        WebElement quantityInput = driver.findElement(By.id("quantity_wanted"));
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
//        driver.findElement(By.name("value")).clear();
//        driver.findElement(By.name("value")).sendKeys(Quantity);


    }

    @And("Add to cart")
    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("add")));
        driver.findElement(By.className("add")).click(); // dodajemy do koszyka
    }

    @Then("go steps on buy")
    public void goStepsOnBuy() {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(4));  //czekam na dogranie
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"))).click();
        // klikam checkout
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"))).click();
        // klikam checkot pomownie
        driver.findElement(By.name("confirm-addresses")).click();
        // potwierddzam adrress
        driver.findElement(By.name("confirmDeliveryOption")).click();
        // potwierdzam typ dostawy
        driver.findElement(By.id("payment-option-1")).click();
        // wybieram forme płatności


    }

    @And("I doing a screenshot")
    public void iDoingAScreenshot() throws Exception{
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //wykonuje printa
        ImageIO.write(ImageIO.read(screenshot), "PNG", new File("D:\\Programy Java\\Coders Lab\\ObronaCodersLab\\Screen"));
    }

    @And("Confirm buy")
    public void confirmBuy() {
        driver.findElement(By.id("conditions_to_approve")).click();  //potwierdzenie umowy
        driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();
        // potwierdzenie kupna
    }
}