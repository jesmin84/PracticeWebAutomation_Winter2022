package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static amazon.TestAmazonSearchBox.driver;

public class CheckFunctionalityOfShoppingCart {
    //    static WebDriver driver;
//    String browserName = "chrome";
//    String url = "https://www.amazon.com/";
//
//    @BeforeTest
//    public void setUpAutomation() {
//        System.out.println("************Automation start************");
//    }
//
//    @AfterTest
//    public void tearDownAutomation() {
//        System.out.println("************Automation end************");
//    }
//
//    @Test
//    public void setUp() {
//        if (this.browserName == "chrome") {
//            setUpChromeBrowser();
//        }
//        //navigate to amazon.com
//        driver.get(this.url);
//        driver.manage().window().maximize();
//    }
//
//    @Test
//    public static void setUpChromeBrowser() {
//        String driverPath = "../PracticeWebAutomation_Winter2022/BrowserDriver/Windows/chromedriver_win32 (1)/chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", driverPath);
//        //open browser
//        // WebDriver driver= new ChromeDriver();
//        driver = new ChromeDriver();
    //  }
    static WebDriver driver;
    String browserName = "chrome";
    //  String url = "https://www.ebay.com/";
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
     * This method will verify successfully for shopping cart logo
     */

    @Test
    public static void testFunctionalityOfShoppingCartLogo() throws InterruptedException {
        //click shopping cart button
        driver.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]/span[2]")).click();
        String actualText = driver.findElement(By.id("nav-cart-count-container")).getText();
        System.out.println("Actual text :" + actualText);
        String expectedText = "Amazon Basic Care - Aloe Hand Sanitizer 62%, 12 Fluid Ounce (Pack of 6)";
        System.out.println("Expected text :" + expectedText);
        //verify the shopping cart is empty
        Assert.assertEquals(actualText, expectedText, "");
        Thread.sleep(5000);


    }


}
