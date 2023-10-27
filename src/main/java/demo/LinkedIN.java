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

public class LinkedIN {
    ChromeDriver driver;

    public LinkedIN() {
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
        System.out.println("Start Test case: LinkedIN TEST CASE");
        driver.get("https://in.linkedin.com/");
        Thread.sleep(5000);

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("shettyreshma@gmail.com");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("****");

        WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign in']"));
        signInButton.click();

        // Print the count of `Who's viewed your profile` and `Impressions of your post`
        WebElement countElement = driver.findElement(By.cssSelector("div[class='num-views-tab']"));
        String count = countElement.getText();
        System.out.println("Who's viewed your profile count: " + count);

        // Create a post , sharing with `Connections only` and confirm if it gets
        // posted.
        WebElement startPostButton = driver.findElement(By.cssSelector("button[data-control-name='create_post']"));
        startPostButton.click();

        WebElement postTextArea = driver
                .findElement(By.cssSelector("div[aria-label='What do you want to talk about?']"));
        postTextArea.sendKeys("This is a test post shared with Connections only. #LinkedInAutomation");

        WebElement connectionsOnlyButton = driver
                .findElement(By.cssSelector("button[aria-label='Share with connections']"));
        connectionsOnlyButton.click();

        WebElement postButton = driver.findElement(By.cssSelector("button[data-control-name='post']"));
        postButton.click();

        String confirmationMessage = "Your post has been shared with your connections.";
        if (driver.getPageSource().contains(confirmationMessage)) {
            System.out.println("Post successfully shared with Connections only.");
        } else {
            System.out.println("Post was not shared as expected.");
        }

        System.out.println("end Test case: LinkedIN TEST CASE");
    }

}
