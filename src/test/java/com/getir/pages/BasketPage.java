package com.getir.pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{

    @FindBy (xpath = "//*[@text='There is no result']")
    public AndroidElement emptyBasketText;

    @FindBy (id = "com.getir.casestudy.dev:id/ga_toolbar_leftIconImageView")
    public AndroidElement backBtn;

    @FindBy(id = "com.getir.casestudy.dev:id/btnAdd")
    public AndroidElement addBtn;

    @FindBy(id = "com.getir.casestudy.dev:id/tvTotalTitle")
    public AndroidElement totalAmount;

    public void addItem(String itemName){
        driver.findElement(By.xpath("//*[@text='"+itemName+"']/..//*[@resource-id='com.getir.casestudy.dev:id/btnAdd']")).click();
    }
}
