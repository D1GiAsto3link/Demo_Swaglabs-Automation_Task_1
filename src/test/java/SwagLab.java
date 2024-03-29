import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

public class SwagLab {

    WebDriver driver;


/*
    // directory where output is to be printed
    ExtentEmailReporter email = new ExtentEmailReporter("user/build/name/");
    ExtentReporter extent = new ExtentReports();
extent.attachReporter(email);
*/

    @Test(priority = 1)
    //this will open the browser up (basically connecting to the web)
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test (priority = 2)
    public void openbrowsersite() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        Thread.sleep(2000);

    }


    @Test (priority = 3)
    public void Login() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]"))
                .sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]"))
                .sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();

/*// You'd typically have an assertion here to validate the error or some teardown action.
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        assert errorMessage.getText().contains("Epic sadface");*/

// Optional: Assert some behavior to verify login. Here, we're checking for a specific item's existence.
        WebElement itemLabel = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
        if (!itemLabel.isDisplayed()) throw new AssertionError();
    }

    @Test (priority = 4)
    public void addtocart() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"item_0_img_link\"]/img")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"item_1_img_link\"]/img")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
    }

    @Test (priority = 5)
public void Gotobasket() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Test (priority = 6)
    public void Checkout() throws InterruptedException {
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2500);
        driver.findElement(By.id("first-name")).sendKeys("Standard");

        driver.findElement(By.id("last-name")).sendKeys("Standard-User");

        driver.findElement(By.id("postal-code")).sendKeys("8001");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @Test(priority = 7)
    public void Finish() throws InterruptedException {
        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("back-to-products")).click();
        Thread.sleep(5000);
        // Logging out
        WebElement menuButton = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        menuButton.click();
        Thread.sleep(5000);
        WebElement logoutButton = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logoutButton.click();

        driver.quit();



    }


}
