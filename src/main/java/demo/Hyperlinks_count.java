package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class Hyperlinks_count {
    ChromeDriver driver;
    public Hyperlinks_count()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    

    
    public  void testCase01(){
        System.out.println("Start Test case: BOOK MY SHOW Test case");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        int linkCount = driver.findElements(By.tagName("a")).size();
        System.out.println("Total hyperlinks on the page: " + linkCount);

        System.out.println("end Test case: BOOKMY SHOW Test case");
    }

    public void endTest()
    {
       // System.out.println("End Test: BookmyShow TestCases");
        driver.close();
        driver.quit();

    }


}
