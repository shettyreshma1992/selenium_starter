package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity10Automate_window_handle {


    ChromeDriver driver;
    public Activity10Automate_window_handle()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    

    
    public  void testCase01(){
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.switchTo().frame("iframeResult");
        WebElement tryItButton = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryItButton.click();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        String newWindowURL = driver.getCurrentUrl();
        String newWindowTitle = driver.getTitle();

        ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        driver.close();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        System.out.println("end Test case: Nested Frames");
    }

    public void endTest()
    {
       
        
        driver.quit();

    }


}

    







