package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckFunctionalityOfTodaysDealLink {
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
     * This method will verify successfully for fashion link
     *
     * @throws InterruptedException
     */
    @Test
    public static void testfunctionalityOfTodaysDealLink() throws InterruptedException {
        //click on Todays link
        driver.findElement(By.id("nav_cs_gb")).click();

        driver.findElement(By.className("DealContent-module__truncate_sWbxETx42ZPStTc9jwySW")).click();

        String actualText = driver.findElement(By.className("a-size-large product-title-word-break")).getText();
        System.out.println("Actual text :" + actualText);
        String expectedText = "Wireless Earbuds Bluetooth Headphones with Wireless Charging Case, HI-FI Stereo in-Ear Headphones with Mic for Sports F9-36";
        //Verify todays deal link displayed the items properly
        Assert.assertEquals(actualText, expectedText, "Today's deal product displayed");
        Thread.sleep(4000);


    }
}
