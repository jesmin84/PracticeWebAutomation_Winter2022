package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBookButtonFunctionality {
    static WebDriver driver;
    String browserName = "chrome";
    // String url = "https://www.ebay.com/";
    String url = "https://www.amazon.com/";
    static String actualText;

    @BeforeTest
    public void setUpAutomation() {
        System.out.println("***************** Automation Started *******************");
    }

    @AfterTest
    public void tearDownAutomation() {
        //driver.close();
        System.out.println("***************** Automation End *******************");
    }


    @BeforeTest
    public void setUp() throws InterruptedException {
        if (this.browserName == "chrome") {
            setUpChromeBrowser();
        } else {
            System.out.println("Not found");
        }
        //  navigate to amazon.com
        driver.get(this.url);
        driver.manage().window().maximize();

    }


    public static void setUpChromeBrowser() {
        String chromeDriverPath = "../PracticeWebAutomation_Winter2022/BrowserDriver/Windows/chromedriver_win32 (1)/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }

    /**
     * This method will verify successfully for book link
     */
    @Test
    public static void testBookButtonFunctionality() throws InterruptedException {

        // click Books button from header section
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[9]")).click();
        //click best books of 2022 so far
        driver.findElement(By.cssSelector("#contentGrid_541084 > div > div > div:nth-child(1) > div > div > a > img")).click();
        //verify expected product
        String actualText = driver.findElement(By.xpath("//*[@id=\"contentGrid_199172\"]/div/div/div/div/div/img")).getText();
        System.out.println("Actual text : " + actualText);
        String expectedText = "TOP 20 BOOKS OF THE YEAR SO FAR";
        System.out.println("Expected text :" + expectedText);
        Assert.assertEquals(actualText, expectedText, "verify the expected product");
        Thread.sleep(3000);
        driver.close();


    }


}
