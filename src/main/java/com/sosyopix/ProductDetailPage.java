package com.sosyopix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class ProductDetailPage extends BasePage {
    public  ProductDetailPage(WebDriver driver){
        super(driver);
    }

    private final By addToCartBtn = By.xpath("//div[@class='basket']//parent::button");
    private final By goToCartBtn = By.xpath("//a[@class='basket  ']");
    private final By selectCargo = By.xpath("//*[contains(text(),'Standart Teslimat')]");
    private final By productName = By.xpath("//div[@class='title flex']//parent::h1");
    private final By productPrice = By.xpath("//div[@id='custom-discount-price']//parent::span");

    public void addToCart(){

        clickElement(addToCartBtn);
        //waitSeconds(3);
    }
    public void selectCargoPopup(){
        clickElement(selectCargo);
        //waitSeconds(3);
    }
    public void goToCart(){
        clickElement(goToCartBtn);
        waitSeconds(3);
    }

    public String getProductNameStr(){
        WebElement productWebElement = findElement(productName);
        String productName = productWebElement.getText().toLowerCase(Locale.ROOT);
        return productName;
    }
    public String getProductPriceStr(){
        WebElement productPriceWebElement = findElement(productPrice);
        String productPrice = productPriceWebElement.getText().toLowerCase(Locale.ROOT);
        return productPrice;
    }

}
