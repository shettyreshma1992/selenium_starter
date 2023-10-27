package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class Activity5_Automate_image_urls {
    ChromeDriver driver;

    public Activity5_Automate_image_urls() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        // System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: BMS IMAGE URL TEST CASE");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        System.out.println("Recommended Movies Image URLs:");
        WebElement recommendedMoviesSection = driver.findElement(By.xpath("//div[@class='sc-133848s-2 sc-1t5vwh0-0 ktUzoz']"));
        List<WebElement> recommendedMovieImages = recommendedMoviesSection.findElements(By.tagName("img"));
        for (WebElement image : recommendedMovieImages) {
            String imageUrl = image.getAttribute("src");
            System.out.println(imageUrl);
        }

        // Find the 2nd item in the "Premiere" list and print its name and language
        System.out.println("\n2nd item in Premiere List:");
        WebElement premiereSection = driver.findElement(By.xpath("//div[@class='sc-eykeme-0 inImWF']"));
        List<WebElement> premiereItems = premiereSection.findElements(By.cssSelector(".language-label"));
        if (premiereItems.size() >= 2) {
            WebElement secondItem = premiereItems.get(1);
            String movieName = secondItem.findElement(By.cssSelector(".name")).getText();
            String language = secondItem.getText();
            System.out.println("Name: " + movieName);
            System.out.println("Language: " + language);
        } else {
            System.out.println("No 2nd item found in Premiere List.");
        }



System.out.println("end Test case: BMS IMAGE URL TEST CASE");
    }

}