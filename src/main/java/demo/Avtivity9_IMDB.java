package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Avtivity9_IMDB {


    ChromeDriver driver;
    public Avtivity9_IMDB()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    public  void testCase01(){
        driver.get("https://www.imdb.com/chart/top");
        WebElement table = driver.findElement(By.className("lister"));
        java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

// highest rated movie on IMDb?
        String highestRatedMovie = rows.get(1).findElement(By.tagName("td")).getText();
        System.out.println("The highest-rated movie on IMDb is: " + highestRatedMovie);

       // How many movies are included in the table?
        int numberOfMovies = rows.size() - 1; 
        System.out.println("Number of movies in the table: " + numberOfMovies);

 //oldest movie on the list?
        String oldestMovie = rows.get(rows.size() - 1).findElement(By.tagName("td")).getText();
        System.out.println("The oldest movie on the list is: " + oldestMovie);

 //most recent movie on the list?
        String mostRecentMovie = rows.get(1).findElement(By.tagName("td")).getText();
        System.out.println("The most recent movie on the list is: " + mostRecentMovie);

        // most user ratings?
        WebElement mostUserRatingsElement = rows.get(1).findElement(By.xpath(".//td[5]/strong"));
        String mostUserRatingsMovie = mostUserRatingsElement.getText();
        System.out.println("The movie with the most user ratings is: " + mostUserRatingsMovie);

    }

    public void endTest()
    {
       
        driver.close();
        driver.quit();

    }


}

    




