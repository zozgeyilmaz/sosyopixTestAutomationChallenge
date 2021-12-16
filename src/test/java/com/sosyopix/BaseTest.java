package com.sosyopix;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    BasePage basePage;

    @BeforeAll
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.sosyopix.com");
    }

    @AfterAll
    public  void  tearDown(){
        driver.quit();
    }

}
