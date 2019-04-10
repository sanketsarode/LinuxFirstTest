package sampleTestLinux;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private WebDriver driver;

    @Test
    public void testEasy() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        System.out.println("****** " + driver.getTitle());
        WebElement ele = driver.findElement(By.xpath("//h2[contains(text(),'All')]"));
        System.out.println(ele.getText());
    }

    @Before
    public void beforeTest() {
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resources//drivers//chromedriver");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //options.addArguments("--no-sandbox");
        //driver = new ChromeDriver(options);

        try {
            Runtime.getRuntime().exec("mv /resources/drivers/phantomjs /usr/bin/phantomjs");
            Runtime.getRuntime().exec("chown root:root /usr/bin/phantomjs");
            Runtime.getRuntime().exec("chmod +x /usr/bin/phantomjs");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.setProperty("phantomjs.binary.path", "/usr/bin/phantomjs");
        driver = new PhantomJSDriver();
        driver.get("http://www.google.com");
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}