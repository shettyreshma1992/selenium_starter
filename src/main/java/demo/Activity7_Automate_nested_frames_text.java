package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7_Automate_nested_frames_text {


    ChromeDriver driver;
    public Activity7_Automate_nested_frames_text()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    

    
    public  void testCase01(){
        System.out.println("Start Test case: Nested Frames");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-middle");
        body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-right");
        body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());

        System.out.println("end Test case: Nested Frames");
    }

    public void endTest()
    {
       
        driver.close();
        driver.quit();

    }


}

    







