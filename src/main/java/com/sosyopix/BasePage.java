package com.sosyopix;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
    }
    public  static void waitSeconds(int seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public WebElement findElement(By locator){
        return  driver.findElement(locator);
    }

    public List<WebElement> findAllElements(By locator){
        return driver.findElements(locator);
    }

    public void clickElement(By by){
        waitUntilPresence(by);
        WebElement element;
        element = findElement(by);
        if (!element.isDisplayed()){
            scrollTo(element.getLocation().getX(),element.getLocation().getY());
        }
        try{
            waitUntilElementClickable(by);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        element.click();
    }
    public void waitUntilPresence(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    public void waitUntilElementClickable(By by) {
        System.out.println(by.toString()+" --> elementin tıklanabilir olması bekleniyor");
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public void sendKeys(By by, String text) {
        waitUntilPresence(by);
        WebElement element;
        element = findElement(by);
        if (!element.isDisplayed()) {
            scrollTo(element.getLocation().getX(), element.getLocation().getY());
        }
        waitUntilElementClickable(by);
        element.sendKeys(text);
    }

    protected  void scrollTo(int x, int y){
        String jsStmt = String.format("window.scrollTo(%d, %d);", x, y);
        getJSExecutor().executeScript(jsStmt, true);
    }
    protected JavascriptExecutor getJSExecutor(){
        return (JavascriptExecutor) driver;
    }


}
