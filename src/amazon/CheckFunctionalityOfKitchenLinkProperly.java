package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckFunctionalityOfKitchenLinkProperly {

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
     * This method will work successfully for kitchen link
     */
    @Test
    public static void testFunctionalityOfKitchenLink() throws InterruptedException {
        //click on kitchen link
        driver.findElement(By.xpath("//*[@id=\"VrT7lrEVeP7WiVaBVcPkPQ\"]/div[2]/div[2]/div[1]/a/div[2]/span")).click();
        //
        driver.findElement(By.xpath("//*[@id=\"contentGrid_647708\"]/div/div/div[1]/div/div/div[2]/a")).click();
        String actualText = driver.findElement(By.id("titleSection")).getText();
        System.out.println("Actual text :" + actualText);
        String expectedText = "HYTRIC Electric Hot Pot with Handle, 1.5L Mini Multifunction Electric Cooker for Shabu-Shabu, Stir Fry, Noodles, Pasta, Nonstick Frying Pan for Sauté, Dual Power Control Ramen Cooker for Dorm and Office";
        //verify the kitchen item displayed properly
        Assert.assertEquals(actualText, expectedText, "Kitchen item displayed properly");
        Thread.sleep(4000);
        driver.close();

    }


}
