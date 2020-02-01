package ad_forums;

import ads.*;
import keyboard.Keyboard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FreeAdForum {
    static String publishURL = "http://www.thefreeadforum.com/postclassifieds/item/new";
    public static void main(String[] args) {
        String[] top10States = new String[]{"New York", "California", "Illinois", "Texas", "Arizona", "Texas", "Pennsylvania", "California", "Texas", "California"};
        String[] top10Cities = new String[]{"New York City", "Los Angeles", "Chicago", "Houston", "Phoenix", "San Antonio", "Philadelphia", "San Diego", "Dallas", "San Jose"};
        String keywords = "work from home, work from home jobs, make money online, money online, jobs online, online jobs, work at home jobs, digital marketing, affiliate marketing, internet marketing, make money at home, digital marketing course, affiliate marketing training, digital marketing training, affiliate marketing course";
        String clickBankKeywords = "work from home, work from home jobs, make money online, money online, jobs online, online jobs, work at home jobs, digital marketing, affiliate marketing, internet marketing, make money at home, digital marketing course, affiliate marketing training, digital marketing training, affiliate marketing course, how to sell ebooks, sell ebooks online";
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

            driver.navigate().to(publishURL);
            driver.findElement(By.name("email")).sendKeys("homenet142@gmail.com");
            driver.findElement(By.id("password")).sendKeys("freeadforumisgood123");
            driver.findElement(By.xpath("//button[@type='submit']")).submit();
            for (int i = 0; i < top10Cities.length; i++) {
                AffiliateProgram program = MillionareSociety.getInstance();
                Select categories = new Select(driver.findElement(By.id("catId")));
                categories.selectByValue("100");
                driver.findElement(By.id("titleen_US")).sendKeys(program.title);
                Keyboard keyboard = new Keyboard();
                keyboard.type("\t\t" + program.description);
                driver.findElement(By.name("qqfile")).sendKeys(program.imagePath);
                Select countries = new Select(driver.findElement(By.id("countryId")));
                Select regions = new Select(driver.findElement(By.id("regionId")));
                Select cities = new Select(driver.findElement(By.id("cityId")));
                countries.selectByVisibleText("United States");
                regions.selectByVisibleText(top10States[i]);
                cities.selectByVisibleText(top10Cities[i]);
                driver.findElement(By.id("meta_website-link")).sendKeys(program.url);
                driver.findElement(By.id("meta_keywords")).sendKeys(keywords);
                if (program.youtubeVideo != null) driver.findElement(By.name("s_youtube")).sendKeys(program.youtubeVideo);
                driver.findElement(By.xpath("//input[@value='001']")).click();
                keyboard.type("\t\n");
                if (i >= top10Cities.length-1) {
                    driver.navigate().to("http://www.thefreeadforum.com");
                } else {
                    driver.navigate().to(publishURL);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

