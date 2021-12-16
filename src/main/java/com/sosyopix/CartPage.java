package com.sosyopix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver){
        super(driver);
    }

    private final By productPrice=By.id("productPrice");
    private final By totalPrice = By.xpath("//div[@class='price-item']//parent::span");
    private final By productName = By.xpath("//*[@id='productName']");
    private final By productQuantity = By.id("number");

    public String getProductNameStr(){
        WebElement productWebElement = findElement(productName);
        String productName = productWebElement.getText().toLowerCase(Locale.ROOT);
        return productName;
    }
    public  String getProductQuantityStr(){
        WebElement quantityWebElement = findElement(productQuantity);
        String quantity = quantityWebElement.getAttribute("value");
        return quantity;
    }
    public String getProductPriceStr(){
        WebElement productPriceWebElement = findElement(productPrice);
        String productPrice = productPriceWebElement.getText().toLowerCase(Locale.ROOT);
        return productPrice;
    }
    public String getCartTotalPriceStr(){
        WebElement totalPriceWebElement = findElement(totalPrice);
        String totalPriceStr = totalPriceWebElement.getText().toLowerCase(Locale.ROOT);
        return totalPriceStr;
    }
}
