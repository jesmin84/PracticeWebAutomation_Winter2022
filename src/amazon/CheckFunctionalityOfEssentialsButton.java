package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckFunctionalityOfEssentialsButton {
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
     * This method will work successfully for essential button link
     */
    @Test
    public static void testFunctionalityOfEssentialButton() throws InterruptedException {
        //click essential button
        driver.findElement(By.xpath("//*[@id=\"r4LJiJLIW891qKuRLv1dBA\"]/div[2]/div[1]/div[2]/a/div[2]/span")).click();
        //click on School Backpack Dinosaurs Colored Bookbag for Boys Girls Travel Bag
        driver.findElement(By.xpath("//*[@id=\"gcx-gf-section-0\"]/div/section/div[2]/figure/div/a/div[2]/div/div[1]/div[1]/span")).click();
        String actualText = driver.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText();
        System.out.println("Actual text :" + actualText);
        String expectedText = "School Backpack Dinosaurs Colored Bookbag for Boys Girls Travel Bag";
        System.out.println("Expected text :" + expectedText);
        //verify the essential button works properly
        Assert.assertEquals(actualText, expectedText, "verified essential item school bag pack displayed");
        Thread.sleep(4000);
        driver.close();
    }


}
