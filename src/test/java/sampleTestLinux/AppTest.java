package sampleTestLinux;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private WebDriver driver;
    private static Logger log = Logger.getLogger("com.gargoylesoftware");

    @Test
    public void testEasy() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        System.out.println("****** " + driver.getTitle());
        WebElement ele = driver.findElement(By.xpath("//h2[contains(text(),'All')]"));
        System.out.println(ele.getText());
        //Assert.assertTrue(title.contains("Demo Guru99 Page"));

        /*try {
            ele = driver.findElement(By.id("philadelphia-field-email"));
            ele.sendKeys("test@test.com");
            ele = driver.findElement(By.id("philadelphia-field-submit"));
            ele.click();

            System.out.println("Message says: " + driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }*/
    }

    @Before
    public void beforeTest() {
        log.setLevel(Level.OFF);
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//resources//drivers//chromedriver");
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resources//drivers//chromedriver.exe");
        //driver = new HtmlUnitDriver(true);
        //((HtmlUnitDriver) driver).setJavascriptEnabled(true);
        //driver = new ChromeDriver();

        //File file = new File("D:/Softwares/Drivers/Phantomjs/phantomjs.exe");
        //System.setProperty("phantomjs.binary.path", file.getAbsolutePath());

        //System.setProperty("phantomjs.binary.path", System.getProperty("user.dir") + "//resources//drivers//phantomjs.exe");
        System.setProperty("phantomjs.binary.path", System.getProperty("user.dir") + "//resources//drivers//phantomjs");
        driver = new PhantomJSDriver();
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}