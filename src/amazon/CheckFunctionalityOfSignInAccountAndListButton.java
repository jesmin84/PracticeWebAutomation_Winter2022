package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckFunctionalityOfSignInAccountAndListButton {
    static WebDriver driver;

    @BeforeTest
    public static void setUp() {
        String driverPath = "../PracticeWebAutomation_Winter2022/BrowserDriver/Windows/chromedriver_win32 (1)/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        //open browser
        // WebDriver driver= new ChromeDriver();
        driver = new ChromeDriver();

        //navigate to amazon.com
        driver.get("https://www.amazon.com/");

        driver.manage().window().maximize();

    }

    /**
     * This method will verify successful sign in using valid credential
     *
     * @throws InterruptedException
     */

    @Test
    public static void checkFunctionalityOfSignButton() throws InterruptedException {

        //click on Sign In
        driver.findElement(By.className("nav-line-1-container")).click();
        //enter email or mobile phone number
        driver.findElement(By.id("ap_email")).sendKeys("ahnaftazwar146@yahoo.com");
        //click on continue button
        driver.findElement(By.className("a-button-input")).click();
        //enter password
        driver.findElement(By.name("password")).sendKeys("Renegade12@");
        //click on sign in button
        driver.findElement(By.className("a-button-input")).click();
        //verify successful log in
        String actualText = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).getText();
        System.out.println("Actual text :" + actualText);
        String expectedText = "Hello, ahnaf";
        Thread.sleep(5000);
        //verification
        Assert.assertEquals(actualText, expectedText, "Sign in not successful");
        Thread.sleep(4000);
        driver.close();


    }


}
