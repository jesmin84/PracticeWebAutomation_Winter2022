package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonHomePage {
    public static void main(String[] args) throws InterruptedException {
        String driverPath= "../PracticeWebAutomation_Winter2022/BrowserDriver/Windows/chromedriver_win32 (1)/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);

        //open browser
        WebDriver driver= new ChromeDriver();

        //navigate to amazon.com
        driver.get("https://www.amazon.com/");

        driver.manage().window().maximize();

        //enter keyword in search box field
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Hand sanitizer");

        //click search button
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

        //verify search product
        String actualText =driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText();
        System.out.println("Actual text : "+actualText);
        String expectedText= "\"Hand sanitizer\"";
        System.out.println("Expected text :"+expectedText);
        if (actualText.equals(expectedText)){
            System.out.println("Test pass");
        }else{
            System.out.println("Test fail");
        }
        Thread.sleep(10000);
        driver.close();

    }

}
