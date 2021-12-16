package com.sosyopix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

public class ArtPage extends BasePage {
    public ArtPage(WebDriver driver){
        super(driver);
    }
    Random rand = new Random();
    private final By selectRandomProduct = By.cssSelector(".swiper-wrapper>a");

    public void selectRandomProduct() {
        List<WebElement> productList = findAllElements(selectRandomProduct);
        int randNum = rand.nextInt(4); //0 - productList.size()
        waitSeconds(2);
        productList.get(randNum).click();

    }
}
