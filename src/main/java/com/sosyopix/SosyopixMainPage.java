package com.sosyopix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SosyopixMainPage extends BasePage {
    public SosyopixMainPage(WebDriver driver){
        super(driver);
    }
    public String SEARCH_WORD = "Takvim";
    private final By closePopupBtn=By.id("close-button-1543162318000");
    private final By clickSearchBtn = By.xpath("//a[@class='search search-button']");
    private final By sendSearchWord = By.id("searchTerms");
    private final By allProductTitles = By.xpath("//div[@class='search-results']//parent::span[@class='line-clamp-2']");
    private final By artBtn = By.xpath("//a[@href='/kendi-kutunu-yap-c-113']//parent::li");
    private final By basket = By.xpath("//a[@class='basket-button']");
    private final By deleteButton = By.xpath("button border-small delete");

    public void  closePopup(){
        var popup = findElement(closePopupBtn);
        if(popup != null && popup.isDisplayed()){
            popup.click();
        }
        waitSeconds(2);
    }
    public void clickSearchBox(){
        clickElement(clickSearchBtn);
    }
    public void enterSearchWord(){
        sendKeys(sendSearchWord,SEARCH_WORD);
        waitSeconds(5);
    }
    public void clickArt(){
        clickElement(artBtn);
    }
    public boolean productControl(){
        int controlCount = 0;
        List<WebElement> all_product_titles = findAllElements(allProductTitles);
        for (int i = 0; i < all_product_titles.size(); i++) {
            String title = all_product_titles.get(i).getText();
            if(title.contains(SEARCH_WORD)){
                ++controlCount;
            }
        }
        if(controlCount == all_product_titles.size())
            return true;
        else
            return false;
    }

    // sepet doluysa temizlemek icin
 /*
    public void cleanBasket(){
        clickElement(basket);
        List<WebElement> all_delete_buttons = findAllElements(deleteButton);
        for (int i = 0; i < all_delete_buttons.size(); i++) {
            all_delete_buttons.get(i).click();
            var okButton = findElement(By.xpath("//a[@class='okay']"));
            if(okButton.isDisplayed()) {
                okButton.click();
            }
        }
    }*/

}

