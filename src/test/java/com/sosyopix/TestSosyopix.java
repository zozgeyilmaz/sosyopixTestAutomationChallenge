package com.sosyopix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSosyopix extends BaseTest{

    SosyopixMainPage sosyopixMainPage;
    ArtPage artPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;


    @Test
    public void searchWord(){
        sosyopixMainPage = new SosyopixMainPage(driver);
        //sosyopixMainPage.closePopup();
        sosyopixMainPage.clickSearchBox();
        sosyopixMainPage.enterSearchWord();
        Assertions.assertTrue(sosyopixMainPage.productControl(),
                "Tüm sonuclar aranilan kelime ile eslesmiyor");
        sosyopixMainPage.closePopup();

    }

    @Test
    public void createDesiredArt(){
        sosyopixMainPage = new SosyopixMainPage(driver);
        artPage = new ArtPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);

        //sosyopixMainPage.closePopup();
        sosyopixMainPage.clickArt();
        artPage.selectRandomProduct();
        productDetailPage.addToCart();
        //standart teslimat popunda seçim yap   // popup içeriği değişebiliyor

        // product detail page product bilgileri
        String productNamePP = productDetailPage.getProductNameStr(); //productDetailPage ProductName
        //String productPricePP = productDetailPage.getProductPriceStr();  
        productDetailPage.selectCargoPopup();
        productDetailPage.goToCart();
        // cart page product bilgileri
        String productNameCP = cartPage.getProductNameStr(); // cartPagedeki ProductName
        String productPriceCP = cartPage.getProductPriceStr();
        String cartTotalPrice = cartPage.getCartTotalPriceStr();
        String cartProductQuantity = cartPage.getProductQuantityStr();
        Assertions.assertEquals(cartProductQuantity,"1",   //tek urun eklenmesi bekleniyor
                "Urun 1 den fazla kez sepete atilmistir");
        Assertions.assertEquals(productNamePP,productNamePP,    //dogru urun mu eklendi
                "sepette yanlis urun eklendi..");
        Assertions.assertEquals(cartTotalPrice,productPriceCP,   //urun fiyati ve sepet toplami esit mi
                "urun fiyati ve sepet toplami eslesmiyor..");

    }



}
