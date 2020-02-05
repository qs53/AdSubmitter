package ad_forums;

import ads.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static ad_forums.City.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class FreeAdForum {

    static String publishURL = "http://www.thefreeadforum.com/postclassifieds/item/new";

    static String workFromHomeCat = "100";
    static String businessOppsCat = "96";
    static String workAtHomeCat = "106";
    static String affMarkCat = "126";

    static String radioButtonPath = "//input[@value='001']";

    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", FreeGlobalClassified.chromeDriverLocationLinux);
            WebDriver driver = new ChromeDriver();
            initialize(driver);

            driver.get(publishURL);
            driver.findElement(By.name("email")).sendKeys("keihagi72@gmail.com");
            driver.findElement(By.id("password")).sendKeys("freeadforumisgood123");
            driver.findElement(By.xpath("//button[@type='submit']")).submit();

            String[] categories = new String[] { workFromHomeCat, workAtHomeCat, affMarkCat, businessOppsCat };
            AffiliateProgram[] programs = new AffiliateProgram[] { MinuteAffiliate.getInstance(), SAS.getInstance(),
                    ClickBank.getInstance(), MillionareSociety.getInstance() };

            postAdsIndia(programs, driver, categories);
            postAdsAus(programs, driver, categories);
            postAdsCanada(programs, driver, categories);
            postAdsUSA(programs, driver, categories);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void postAdsUSA(AffiliateProgram[] programs, WebDriver driver, String[] cats) {
        for (int i = 0; i < top30CitiesUSA.length; i++) {
            for (int k = 0; k < cats.length; k++) {
                for (int j = 0; j < programs.length; j++) {
                    AffiliateProgram program = programs[j];
                    Select categories = new Select(driver.findElement(By.id(FreeGlobalClassified.categoryId)));
                    categories.selectByValue(cats[k]);
                    driver.findElement(By.id(FreeGlobalClassified.titleId))
                            .sendKeys(program.title + " (" + UUID.randomUUID().toString().replace("-", "") + ")");
                    driver.switchTo().frame(0);
                    WebElement desc = driver.findElement(By.id(FreeGlobalClassified.descId));
                    desc.click();
                    desc.sendKeys(program.description);
                    driver.switchTo().defaultContent();
                    driver.findElement(By.name(FreeGlobalClassified.imageId)).sendKeys(program.imagePath);
                    Select countries = new Select(driver.findElement(By.id(FreeGlobalClassified.countryId)));
                    Select regions = new Select(driver.findElement(By.id(FreeGlobalClassified.regionId)));
                    Select cities = new Select(driver.findElement(By.id(FreeGlobalClassified.cityId)));
                    countries.selectByVisibleText("United States");
                    regions.selectByVisibleText(top30StatesUSA[i]);
                    cities.selectByVisibleText(top30CitiesUSA[i]);
                    driver.findElement(By.id(FreeGlobalClassified.websiteId)).sendKeys(program.url);
                    driver.findElement(By.id(FreeGlobalClassified.keywordsId)).sendKeys(program.keywords);
                    if (program.youtubeVideo != null)
                        driver.findElement(By.name(FreeGlobalClassified.youtubeId)).sendKeys(program.youtubeVideo);
                    driver.findElement(By.xpath(radioButtonPath)).click();
                    driver.findElement(By.xpath("//button[@type='submit']")).submit();
                    driver.get(publishURL);
                    if (!driver.getCurrentUrl().equals(publishURL))
                        driver.get(publishURL);
                }
            }
        }
    }

    private static void postAdsIndia(AffiliateProgram[] programs, WebDriver driver, String[] cats) {
        for (int i = 0; i < top2CitiesIndia.length; i++) {
            for (int k = 0; k < cats.length; k++) {
                for (int j = 0; j < programs.length; j++) {
                    AffiliateProgram program = programs[j];
                    Select categories = new Select(driver.findElement(By.id(FreeGlobalClassified.categoryId)));
                    categories.selectByValue(cats[k]);
                    driver.findElement(By.id(FreeGlobalClassified.titleId))
                            .sendKeys(program.title + " (" + UUID.randomUUID().toString().replace("-", "") + ")");
                    driver.switchTo().frame(0);
                    WebElement desc = driver.findElement(By.id(FreeGlobalClassified.descId));
                    desc.click();
                    desc.sendKeys(program.description);
                    driver.switchTo().defaultContent();
                    driver.findElement(By.name(FreeGlobalClassified.imageId)).sendKeys(program.imagePath);
                    Select countries = new Select(driver.findElement(By.id(FreeGlobalClassified.countryId)));
                    Select regions = new Select(driver.findElement(By.id(FreeGlobalClassified.regionId)));
                    Select cities = new Select(driver.findElement(By.id(FreeGlobalClassified.cityId)));
                    countries.selectByVisibleText("India");
                    regions.selectByVisibleText(top2StatesIndia[i]);
                    cities.selectByVisibleText(top2CitiesIndia[i]);
                    driver.findElement(By.id(FreeGlobalClassified.websiteId)).sendKeys(program.url);
                    driver.findElement(By.id(FreeGlobalClassified.keywordsId)).sendKeys(program.keywords);
                    if (program.youtubeVideo != null)
                        driver.findElement(By.name(FreeGlobalClassified.youtubeId)).sendKeys(program.youtubeVideo);
                    driver.findElement(By.xpath(radioButtonPath)).click();
                    driver.findElement(By.xpath("//button[@type='submit']")).submit();
                    driver.get(publishURL);
                    if (!driver.getCurrentUrl().equals(publishURL))
                        driver.get(publishURL);
                }
            }
        }
    }

    private static void postAdsAus(AffiliateProgram[] programs, WebDriver driver, String[] cats) {
        for (int i = 0; i < top5CitiesAus.length; i++) {
            for (int k = 0; k < cats.length; k++) {
                for (int j = 0; j < programs.length; j++) {
                    AffiliateProgram program = programs[j];
                    Select categories = new Select(driver.findElement(By.id(FreeGlobalClassified.categoryId)));
                    categories.selectByValue(cats[k]);
                    driver.findElement(By.id(FreeGlobalClassified.titleId))
                            .sendKeys(program.title + " (" + UUID.randomUUID().toString().replace("-", "") + ")");
                    driver.switchTo().frame(0);
                    WebElement desc = driver.findElement(By.id(FreeGlobalClassified.descId));
                    desc.click();
                    desc.sendKeys(program.description);
                    driver.switchTo().defaultContent();
                    driver.findElement(By.name(FreeGlobalClassified.imageId)).sendKeys(program.imagePath);
                    Select countries = new Select(driver.findElement(By.id(FreeGlobalClassified.countryId)));
                    countries.selectByVisibleText("Australia");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                    Select regions = new Select(driver.findElement(By.id(FreeGlobalClassified.regionId)));
                    regions.selectByVisibleText(top5StatesAus[i]);
                    if (i == 4)
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                        }
                    Select cities = new Select(driver.findElement(By.id(FreeGlobalClassified.cityId)));
                    cities.selectByVisibleText(top5CitiesAus[i]);
                    driver.findElement(By.id(FreeGlobalClassified.websiteId)).sendKeys(program.url);
                    driver.findElement(By.id(FreeGlobalClassified.keywordsId)).sendKeys(program.keywords);
                    if (program.youtubeVideo != null)
                        driver.findElement(By.name(FreeGlobalClassified.youtubeId)).sendKeys(program.youtubeVideo);
                    driver.findElement(By.xpath(radioButtonPath)).click();
                    driver.findElement(By.xpath("//button[@type='submit']")).submit();
                    driver.get(publishURL);
                    if (!driver.getCurrentUrl().equals(publishURL))
                        driver.get(publishURL);
                }
            }
        }
    }

    private static void postAdsCanada(AffiliateProgram[] programs, WebDriver driver, String[] cats) {
        for (int i = 0; i < top5CitiesCanada.length; i++) {
            for (int k = 0; k < cats.length; k++) {
                for (int j = 0; j < programs.length; j++) {
                    AffiliateProgram program = programs[j];
                    Select categories = new Select(driver.findElement(By.id(FreeGlobalClassified.categoryId)));
                    categories.selectByValue(cats[k]);
                    driver.findElement(By.id(FreeGlobalClassified.titleId))
                            .sendKeys(program.title + " (" + UUID.randomUUID().toString().replace("-", "") + ")");
                    driver.switchTo().frame(0);
                    WebElement desc = driver.findElement(By.id(FreeGlobalClassified.descId));
                    desc.click();
                    desc.sendKeys(program.description);
                    driver.switchTo().defaultContent();
                    driver.findElement(By.name(FreeGlobalClassified.imageId)).sendKeys(program.imagePath);
                    Select countries = new Select(driver.findElement(By.id(FreeGlobalClassified.countryId)));
                    Select regions = new Select(driver.findElement(By.id(FreeGlobalClassified.regionId)));
                    Select cities = new Select(driver.findElement(By.id(FreeGlobalClassified.cityId)));
                    countries.selectByVisibleText("Canada");
                    regions.selectByVisibleText(top5StatesCanada[i]);
                    cities.selectByVisibleText(top5CitiesCanada[i]);
                    driver.findElement(By.id(FreeGlobalClassified.websiteId)).sendKeys(program.url);
                    driver.findElement(By.id(FreeGlobalClassified.keywordsId)).sendKeys(program.keywords);
                    if (program.youtubeVideo != null)
                        driver.findElement(By.name(FreeGlobalClassified.youtubeId)).sendKeys(program.youtubeVideo);
                    driver.findElement(By.xpath(radioButtonPath)).click();
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

