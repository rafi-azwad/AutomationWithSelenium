import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class WebAutomation {
    public static WebDriver driver;
    public static void main(String[] args) {

        Map<String, Integer> contentSettings = new HashMap<String, Integer>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Object> prefs = new HashMap<String, Object>();

        // options : default - 0, allow - 1, block - 2
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://chaldal.com/");
        driver.manage().window().maximize();


        // item 1 - Maggi noodles
        WebElement searchBox = driver.findElement(By.name("search_term_string"));
        searchBox.sendKeys("Maggi noodles");
        searchBox.sendKeys(Keys.ENTER);

        // add to cart - using mouseHover
        WebElement noodlesCart = driver.findElement(By.xpath("(//div[@class=\"productPane\"]//descendant::div)[36]"));
        Actions action = new Actions(driver);
        action.moveToElement(noodlesCart).perform(); // hover on the element
        action.click(noodlesCart).perform(); // click on the element
        driver.navigate().back();

        // item 2 - Egg deshi
        WebElement searchBox1 = driver.findElement(By.name("search_term_string"));
        searchBox1.sendKeys("Egg deshi");
        searchBox1.sendKeys(Keys.ENTER);

        // add to cart
        WebElement eggCart = driver.findElement(By.xpath("(//div[@class=\"productPane\"]//descendant::div)[6]"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(eggCart).perform();
        action1.click(eggCart).perform();
        driver.navigate().back();

        // item 2 - Soyabean oil
        WebElement searchBox2 = driver.findElement(By.name("search_term_string"));
        searchBox2.sendKeys("Soyabean oil");
        searchBox2.sendKeys(Keys.ENTER);

        // add to cart
        WebElement oilCart = driver.findElement(By.xpath("(//div[@class=\"productPane\"]//descendant::div)[48]"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(oilCart).perform();
        action2.click(oilCart).perform();
        driver.navigate().back();

        // item 2 - Pran sauce
        WebElement searchBox3 = driver.findElement(By.name("search_term_string"));
        searchBox3.sendKeys("Pran sauce");
        searchBox3.sendKeys(Keys.ENTER);

        // add to cart
        WebElement sauceCart = driver.findElement(By.xpath("(//div[@class=\"productPane\"]//descendant::div)[6]"));
        Actions action3 = new Actions(driver);
        action3.moveToElement(sauceCart).perform();
        action3.click(sauceCart).perform();
        driver.quit();


    }
}
