package com.gebarowski.calcha;

import com.gebarowski.calcha.Divisor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


/**
 * Created by Michał Gębarowski on 06/04/2018
 */
public class CalchaTest {

    private static FirefoxOptions options;
    private static WebDriver driver;

    @BeforeClass
    public static void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
        options = new FirefoxOptions().setHeadless(true);
        driver = new FirefoxDriver(options);
        driver.get("http://quantbet.com/quiz/dev");
    }

    @Before
    public void refreshBrowser() {
        driver.get("http://quantbet.com/quiz/dev");
    }

    @Test
    public void breakCalcha() {
        var a = Integer.parseInt(driver.findElement(By.xpath("//strong[1]")).getText());
        var b = Integer.parseInt(driver.findElement(By.xpath("//strong[2]")).getText());
        driver.findElement(By.id("calchainput")).sendKeys(String.valueOf(Divisor.findGreatestCommonDivisor(a, b)));
        driver.findElement(By.xpath("//button")).click();
        Assert.assertEquals("Correct! Please send your solution along with a copy of your CV to careers@quantbet.com",
                driver.findElement(By.xpath("//div[@class='quiz-content']//div")).getText());
    }
}
