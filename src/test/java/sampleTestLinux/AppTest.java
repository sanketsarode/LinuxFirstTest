package sampleTestLinux;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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
        Assert.assertTrue(title.contains("Demo Guru99 Page"));
    }

    @Before
    public void beforeTest() {
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//resources//drivers//chromedriver");
        driver = new HtmlUnitDriver();
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
