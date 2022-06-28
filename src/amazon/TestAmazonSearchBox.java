package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAmazonSearchBox {

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
     * This method will verify successful signIn using valid credential
     *
     * @throws InterruptedException
     */


    @Test
    public static void testSearchBox() throws InterruptedException {
        // setUp("chrome", "https://www.amazon.com/");
        //enter keyword in search box field
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Hand sanitizer");

        //click search button
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

        //verify search product
        String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText();
        System.out.println("Actual text : " + actualText);
        String expectedText = "\"Hand sanitizer\"";
        System.out.println("Expected text :" + expectedText);
        Assert.assertEquals(actualText, expectedText, "Verify search product");
        Thread.sleep(5000);
        driver.close();

    }


}
