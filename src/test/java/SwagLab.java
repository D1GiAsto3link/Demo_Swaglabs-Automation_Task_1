import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

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


    }

}
