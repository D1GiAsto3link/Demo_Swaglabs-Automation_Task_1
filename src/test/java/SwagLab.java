import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

public class SwagLab {

    WebDriver driver;



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
    public void Login(){
        driver.findElement(By.xpath("//*[@id=\"user-name\"]"))
                .sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

/*// You'd typically have an assertion here to validate the error or some teardown action.
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        assert errorMessage.getText().contains("Epic sadface");*/


    }

    @Test (priority = 4)
    public void addtocart() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"item_0_img_link\"]/img")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"item_1_img_link\"]/img")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
    }

    @Test (priority = 5)
public void Gotobasket(){
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Test (priority = 6)
    public void Checkout() throws InterruptedException {
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2500);
        driver.findElement(By.id("first-name")).sendKeys("Standard");

        driver.findElement(By.id("last-name")).sendKeys("Standard-User");

        driver.findElement(By.id("postal-code")).sendKeys("8001");

        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @Test(priority = 7)
    public void Finish() throws InterruptedException {
        /*driver.findElement(By.id("finish")).click();

        driver.findElement(By.id("back-to-products")).click();

        Thread.sleep(5000);
        driver.quit();*/

        // Logging in
        WebElement usernameField = driver.findElement(By.xpath("//input[@data-test='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@data-test='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@data-test='login-button']"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Optional: Assert some behavior to verify login. Here, we're checking for a specific item's existence.
        WebElement itemLabel = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
        assert itemLabel.isDisplayed();

        // Logging out
        WebElement menuButton = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        menuButton.click();

        WebElement logoutButton = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logoutButton.click();

        // Assert you've been logged out by checking if the login button is displayed
        assert loginButton.isDisplayed();
    }


}
