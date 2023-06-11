package com.getir.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//*[@text='username']")
    public AndroidElement loginBox;

    @FindBy(xpath = "//*[@text='password']")
    public AndroidElement passwordBox;

    @FindBy(xpath = "//*[@text='Submit']")
    public AndroidElement submitBtn;

    @FindBy(xpath = "//*[@text='Dondurma']")
    public AndroidElement categoryDondurma;

    @FindBy(id = "com.getir.casestudy.dev:id/ga_toolbar_getir10GABasketButton")
    public AndroidElement basketBtn;

    @FindBy(className = "android.widget.TextView")
    public List<AndroidElement> menuList;


    public void login(String userName,String password){
        loginBox.sendKeys(userName);
        passwordBox.sendKeys(password);
        submitBtn.click();
    }

    public void getCategory(String categoryName){
        driver.findElement(By.xpath("//*[@text='"+categoryName+"']")).click();

    }

}
