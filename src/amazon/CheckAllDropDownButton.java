package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static amazon.TestAmazonSearchBox.driver;

public class CheckAllDropDownButton {
    static WebDriver driver;
    String browserName = "chrome";
    //String url = "https://www.ebay.com/";
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
     * This method will verify successfully for all drop down link
     */
    @Test
    public static void checkfunctionalityOfAllDropDownButton() throws InterruptedException {
        //click All drop down button
        driver.findElement(By.cssSelector("#nav-hamburger-menu > span")).click();
        //click on Fire tables button
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[10]/a")).click();
        //click on Fire 7 kids pro
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[5]/li[11]/a")).click();
        //verify
        String actualText = driver.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText();
        System.out.println("Actual text :" + actualText);
        String expectedText = "Fire 7 Kids Pro tablet, 7\" display, ages 6+, 16 GB, Sky Blue";
        //verified the all drop down button work properly
        Assert.assertEquals(actualText, expectedText, "verified the drop down button working properly");
        Thread.sleep(3000);
        driver.close();


    }


}
