package ad_forums;

import ads.*;
import keyboard.Keyboard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static ad_forums.City.*;

public class FreeGlobalClassified {

    public static String chromeDriverLocationLinux = "/home/qusai/Documents/Videos/selenium/chromedriver_linux64/chromedriver";
    public static String chromeDriverLocationWindows = "C:\\Users\\ASUS\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe";

    static String publishURL = "http://www.freeglobalclassifiedads.com/item/new";

    static String workFromHomeCat = "100";
    static String businessOppsCat = "96";
    static String workAtHomeCat = "106";
    static String affMarkCat = "126";

    public static String categoryId = "catId";
    public static String titleId = "titleen_US";
    public static String descId = "tinymce";
    public static String imageId = "qqfile";
    public static String countryId = "countryId";
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
            driver.findElement(By.id("password")).sendKeys("globaladsisgood123");
            driver.findElement(By.xpath("//button[@type='submit']")).submit();

            Keyboard keyboard = new Keyboard();
            String[] categories = new String[]{workFromHomeCat, workAtHomeCat, affMarkCat, businessOppsCat};
            AffiliateProgram[] programs = new AffiliateProgram[] { MinuteAffiliate.getInstance(), SAS.getInstance(),
                    ClickBank.getInstance(), MillionareSociety.getInstance() };

            postAdsIndia(programs, driver, keyboard, categories);
            postAdsAus(programs, driver, keyboard, categories);
            postAdsCanada(programs, driver, keyboard, categories);
            postAdsUSA(programs, driver, keyboard, categories);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void postAdsUSA(AffiliateProgram[] programs, WebDriver driver, Keyboard keyboard, String[] cats) {
        for (int k = 0; k < cats.length; k++) {
            for (int i = 0; i < top30CitiesUSA.length; i++) {
                for (int j = 0; j < programs.length; j++) {
                    AffiliateProgram program = programs[j];
                    Select categories = new Select(driver.findElement(By.id(categoryId)));
                    categories.selectByValue(cats[k]);
                    driver.findElement(By.id(titleId)).sendKeys(program.title + " (" + UUID.randomUUID().toString().replace("-", "") + ")");
                    driver.switchTo().frame(0);
                    WebElement desc = driver.findElement(By.id(descId));
                    desc.click();
                    desc.sendKeys(program.description);
                    driver.switchTo().defaultContent();
                    driver.findElement(By.name(imageId)).sendKeys(program.imagePath);
                    Select countries = new Select(driver.findElement(By.id(countryId)));
                    Select regions = new Select(driver.findElement(By.id(regionId)));
                    Select cities = new Select(driver.findElement(By.id(cityId)));
                    countries.selectByVisibleText("United States");
                    regions.selectByVisibleText(top30StatesUSA[i]);
                    cities.selectByVisibleText(top30CitiesUSA[i]);
                    driver.findElement(By.id(websiteId)).sendKeys(program.url);
                    driver.findElement(By.id(keywordsId)).sendKeys(program.keywords);
                    if (program.youtubeVideo != null) {
                        driver.findElement(By.name(youtubeId)).sendKeys(program.youtubeVideo);
                        keyboard.type("\t\n");
                    } else {
                        keyboard.type("\t\t\t\t\n");
                    }
                    driver.get(publishURL);
                    if (!driver.getCurrentUrl().equals(publishURL))
                        driver.get(publishURL);
                }
            }
        }
    }

    private static void postAdsIndia(AffiliateProgram[] programs, WebDriver driver, Keyboard keyboard, String[] cats) {
        for (int k = 0; k < cats.length; k++) {
            for (int i = 0; i < top2CitiesIndia.length; i++) {
                for (int j = 0; j < programs.length; j++) {
                    AffiliateProgram program = programs[j];
                    Select categories = new Select(driver.findElement(By.id(categoryId)));
                    categories.selectByValue(cats[k]);
                    driver.findElement(By.id(titleId)).sendKeys(program.title + " (" + UUID.randomUUID().toString().replace("-", "") + ")");
                    driver.switchTo().frame(0);
                    WebElement desc = driver.findElement(By.id(descId));
                    desc.click();
                    desc.sendKeys(program.description);
                    driver.switchTo().defaultContent();
                    driver.findElement(By.name(imageId)).sendKeys(program.imagePath);
                    Select countries = new Select(driver.findElement(By.id(countryId)));
                    Select regions = new Select(driver.findElement(By.id(regionId)));
                    Select cities = new Select(driver.findElement(By.id(cityId)));
                    countries.selectByVisibleText("India");
                    regions.selectByVisibleText(top2StatesIndia[i]);
                    cities.selectByVisibleText(top2CitiesIndia[i]);
                    driver.findElement(By.id(websiteId)).sendKeys(program.url);
                    driver.findElement(By.id(keywordsId)).sendKeys(program.keywords);
                    if (program.youtubeVideo != null) {
                        driver.findElement(By.name(youtubeId)).sendKeys(program.youtubeVideo);
                        keyboard.type("\t\n");
                    } else {
                        keyboard.type("\t\t\t\t\n");
                    }
                    driver.get(publishURL);
                    if (!driver.getCurrentUrl().equals(publishURL)) {
                        driver.get(publishURL);
                    }
                }
            }
        }
    }

    private static void postAdsAus(AffiliateProgram[] programs, WebDriver driver, Keyboard keyboard, String[] cats) {
        for (int k = 0; k < cats.length; k++) {
            for (int i = 0; i < top5CitiesAus.length; i++) {
                for (int j = 0; j < programs.length; j++) {
                    AffiliateProgram program = programs[j];
                    Select categories = new Select(driver.findElement(By.id(categoryId)));
                    categories.selectByValue(cats[k]);
                    driver.findElement(By.id(titleId)).sendKeys(program.title + " (" + UUID.randomUUID().toString().replace("-", "") + ")");
                    driver.switchTo().frame(0);
                    WebElement desc = driver.findElement(By.id(descId));
                    desc.click();
                    desc.sendKeys(program.description);
                    driver.switchTo().defaultContent();
                    driver.findElement(By.name(imageId)).sendKeys(program.imagePath);
                    Select countries = new Select(driver.findElement(By.id(countryId)));
                    Select regions = new Select(driver.findElement(By.id(regionId)));
                    Select cities = new Select(driver.findElement(By.id(cityId)));
                    countries.selectByVisibleText("Australia");
                    regions.selectByVisibleText(top5StatesAus[i]);
                    cities.selectByVisibleText(top5CitiesAus[i]);
                    driver.findElement(By.id(websiteId)).sendKeys(program.url);
                    driver.findElement(By.id(keywordsId)).sendKeys(program.keywords);
                    if (program.youtubeVideo != null) {
                        driver.findElement(By.name(youtubeId)).sendKeys(program.youtubeVideo);
                        keyboard.type("\t\n");
                    } else {
                        keyboard.type("\t\t\t\t\n");
                    }
                    driver.get(publishURL);
                    if (!driver.getCurrentUrl().equals(publishURL))
                        driver.get(publishURL);
                }
            }
        }
    }

    private static void postAdsCanada(AffiliateProgram[] programs, WebDriver driver, Keyboard keyboard, String[] cats) {
        for (int k = 0; k < cats.length; k++) {
            for (int i = 0; i < top5CitiesCanada.length; i++) {
                for (int j = 0; j < programs.length; j++) {
                    AffiliateProgram program = programs[j];
                    Select categories = new Select(driver.findElement(By.id(categoryId)));
                    categories.selectByValue(cats[k]);
                    driver.findElement(By.id(titleId)).sendKeys(program.title + " (" + UUID.randomUUID().toString().replace("-", "") + ")");
                    driver.switchTo().frame(0);
                    WebElement desc = driver.findElement(By.id(descId));
                    desc.click();
                    desc.sendKeys(program.description);
                    driver.switchTo().defaultContent();
                    driver.findElement(By.name(imageId)).sendKeys(program.imagePath);
                    Select countries = new Select(driver.findElement(By.id(countryId)));
                    Select regions = new Select(driver.findElement(By.id(regionId)));
                    Select cities = new Select(driver.findElement(By.id(cityId)));
                    countries.selectByVisibleText("Canada");
                    regions.selectByVisibleText(top5StatesCanada[i]);
                    cities.selectByVisibleText(top5CitiesCanada[i]);
                    driver.findElement(By.id(websiteId)).sendKeys(program.url);
                    driver.findElement(By.id(keywordsId)).sendKeys(program.keywords);
                    if (program.youtubeVideo != null) {
                        driver.findElement(By.name(youtubeId)).sendKeys(program.youtubeVideo);
                        keyboard.type("\t\n");
                    } else {
                        keyboard.type("\t\t\t\t\n");
                    }
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
