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

/**
 * Unit test for simple App.
 */
public class AppTest {
    private WebDriver driver;

    @Test
    public void testEasy() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        String title = driver.getTitle();
        System.out.println("****** " + driver.getTitle());
        WebElement ele = driver.findElement(By.xpath("//h2[contains(text(),'All')]"));
        System.out.println(ele.getText());
        Assert.assertTrue(title.contains("Demo Guru99 Page"));

        try {
            ele = driver.findElement(By.id("philadelphia-field-email"));
            ele.sendKeys("asdfasdfadsfadsf");
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//resources//drivers//chromedriver");
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resources//drivers//chromedriver.exe");
        driver = new HtmlUnitDriver(true);
        ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
        //driver = new ChromeDriver();
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
