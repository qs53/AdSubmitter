package ad_forums;

import ads.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static ad_forums.City.*;

public class USAClassified {

    public static String chromeDriverLocationLinux = "/home/qusai/Documents/Videos/selenium/chromedriver_linux64/chromedriver";
    public static String chromeDriverLocationWindows = "C:\\Users\\ASUS\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe";

    static String publishURL = "http://www.usafreeclassifieds.org/classifieds/item/new";

    static String workFromHomeCat = "106";
    static String affMarkCat = "130";

    public static String categoryId = "catId";
    public static String titleId = "titleen_US";
    public static String descId = "tinymce";
    public static String imageId = "qqfile";
    public static String regionId = "regionId";
    public static String cityId = "cityId";
    public static String websiteId = "meta_website-link";
    public static String keywordsId = "meta_keywords";
    public static String youtubeId = "s_youtube";

    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", chromeDriverLocationLinux);
            WebDriver driver = new ChromeDriver();
            initialize(driver);

            driver.get(publishURL);
            driver.findElement(By.name("email")).sendKeys("keihagi72@gmail.com");
            driver.findElement(By.id("password")).sendKeys("usafreeisgood123");
            driver.findElement(By.xpath("//button[@type='submit']")).submit();

            String[] categories = new String[] { workFromHomeCat, affMarkCat };
            AffiliateProgram[] programs = new AffiliateProgram[] { MinuteAffiliate.getInstance(), SAS.getInstance(),
                    ClickBank.getInstance(), MillionareSociety.getInstance() };
            postAdsUSA(programs, driver, categories);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void postAdsUSA(AffiliateProgram[] programs, WebDriver driver, String[] cats) {
        for (int i = 0; i < allCitiesUSA.length; i++) {
            for (int k = 0; k < cats.length; k++) {
                for (int j = 0; j < programs.length; j++) {
                    AffiliateProgram program = programs[j];
                    Select categories = new Select(driver.findElement(By.id(categoryId)));
                    categories.selectByValue(cats[k]);
                    driver.findElement(By.id(titleId))
                            .sendKeys(program.title + " (" + UUID.randomUUID().toString().replace("-", "") + ")");
                    driver.switchTo().frame(0);
                    WebElement desc = driver.findElement(By.id(descId));
                    desc.click();
                    desc.sendKeys(program.description);
                    driver.switchTo().defaultContent();
                    driver.findElement(By.name(imageId)).sendKeys(program.imagePath);
                    Select regions = new Select(driver.findElement(By.id(regionId)));
                    regions.selectByVisibleText(allStatesUSA[i]);
                    if (i == 0)
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                        }
                    Select cities = new Select(driver.findElement(By.id(cityId)));
                    cities.selectByVisibleText(allCitiesUSA[i]);
                    driver.findElement(By.id(websiteId)).sendKeys(program.url);
                    driver.findElement(By.id(keywordsId)).sendKeys(program.keywords);
                    if (program.youtubeVideo != null)
                        driver.findElement(By.name(youtubeId)).sendKeys(program.youtubeVideo);
                    driver.findElement(By.xpath("//button[@type='submit']")).submit();
                    driver.get(publishURL);
                    if (!driver.getCurrentUrl().equals(publishURL))
                        driver.get(publishURL);
                }
            }
        }
    }

    private static void initialize(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(660, TimeUnit.SECONDS);
    }
}
