package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckFunctionalityOfFashionButton {
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
     * This method will work successfully for fashion link
     *
     * @throws InterruptedException
     */
    @Test
    public static void testFunctionalityOfFashionLink() throws InterruptedException {
        //click on fashion link
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[13]")).click();
        //click on kids link
        driver.findElement(By.xpath("//*[@id=\"nav-subnav\"]/a[4]/span[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"contentGrid_856889\"]/div/div[2]/div[2]/div/div/a/img")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[11]/div/div/div/div/div[2]/div[2]/h2/a/span")).click();
        String actualText = driver.findElement(By.className("a-size-large product-title-word-break")).getText();
        System.out.println("Actual text :" + actualText);
        String expectedText = "Lacoste Unisex-Child Jump Serve Sneaker";
        //verify the kids link properly

        Assert.assertEquals(actualText, expectedText, "Fashion link worked properly");
        Thread.sleep(4000);
        driver.close();


    }
}
