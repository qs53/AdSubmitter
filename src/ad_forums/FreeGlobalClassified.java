package ad_forums;

import ads.*;
import keyboard.Keyboard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static ad_forums.City.*;

public class FreeGlobalClassified {

    public static String chromeDriverLocationLinux = "/home/qusai/Documents/Videos/selenium/chromedriver_linux64/chromedriver";
    public static String chromeDriverLocationWindows = "C:\\Users\\ASUS\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe";

    public static void main(String[] args) {
        String publishURL = "http://www.freeglobalclassifiedads.com/item/new";
        String workFromHomeCat = "100";
        String businessOppsCat = "96";
        String workAtHomeCat = "106";
        String affMarkCat = "126";

        try {
            System.setProperty("webdriver.chrome.driver", chromeDriverLocationLinux);
            WebDriver driver = new ChromeDriver();
            initialize(driver);

            driver.navigate().to(publishURL);
            driver.findElement(By.name("email")).sendKeys("homenet142@gmail.com");
            driver.findElement(By.id("password")).sendKeys("globaladsisgood123");
            driver.findElement(By.xpath("//button[@type='submit']")).submit();
            for (int i = 0; i < top200Cities.length; i++) {
                AffiliateProgram program = MinuteAffiliate.getInstance();
                Select categories = new Select(driver.findElement(By.id("catId")));
                categories.selectByValue(workFromHomeCat);
                driver.findElement(By.id("titleen_US")).sendKeys(program.title + " (" + UUID.randomUUID().toString().replace("-", "") + ")");
                Keyboard keyboard = new Keyboard();
                keyboard.type("\t\t" + program.description);
                driver.findElement(By.name("qqfile")).sendKeys(program.imagePath);
                Select countries = new Select(driver.findElement(By.id("countryId")));
                Select regions = new Select(driver.findElement(By.id("regionId")));
                Select cities = new Select(driver.findElement(By.id("cityId")));
                countries.selectByVisibleText("United States");
                regions.selectByVisibleText(top200States[i]);
                cities.selectByVisibleText(top200Cities[i]);
                driver.findElement(By.id("meta_website-link")).sendKeys(program.url);
                driver.findElement(By.id("meta_keywords")).sendKeys(program.keywords);
                if (program.youtubeVideo != null) {
                    driver.findElement(By.name("s_youtube")).sendKeys(program.youtubeVideo);
                    keyboard.type("\t\n");
                } else {
                    keyboard.type("\t\t\t\t\n");
                }
                if (i >= top200Cities.length-1) {
                    driver.navigate().to("http://www.freeglobalclassifiedads.com/");
                } else {
                    driver.navigate().to(publishURL);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initialize(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }
}
