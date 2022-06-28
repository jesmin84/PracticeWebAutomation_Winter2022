package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckFunctionalityOfGiftCardsLink {
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
     * This method will verify successfully for gift cards link
     *
     * @throws InterruptedException
     */
    @Test
    public static void testFunctionalityOfGiftCardsButton() throws InterruptedException {
        //click on gift cards link
        driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(16)")).click();
        //click on Amazon.com eGift Card
        driver.findElement(By.xpath("//*[@id=\"acs-product-block-3\"]/a/span/span[2]")).click();

        String actualText = driver.findElement(By.id("gc-asin-title")).getText();
        System.out.println("Actual text :" + actualText);
        String expectedText = "Amazon.com eGift Card";
        //
        Assert.assertEquals(actualText, expectedText, "Verify gift cards button displayed properly");
        Thread.sleep(3000);
        driver.close();

    }

}