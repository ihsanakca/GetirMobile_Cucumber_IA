package com.getir.step_definitions;

import com.getir.pages.BasketPage;
import com.getir.pages.LoginPage;
import com.getir.utilities.ScrollHelper;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GetirE2E_StepDefs {
    LoginPage loginPage = new LoginPage();
    BasketPage basketPage = new BasketPage();

    @Given("The user open the getir app and enters {string} and {string}")
    public void the_user_open_the_getir_app_and_enters_and(String userName, String password) {
        loginPage.waitUntil(loginPage.loginBox);
        loginPage.login(userName, password);
    }

    @Then("The user verify successfull login with {string}")
    public void the_user_verify_successfull_login_with(String expectedText) {
        loginPage.waitUntil(loginPage.categoryDondurma);
        String actualText = loginPage.categoryDondurma.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Then("The user clicks basket button")
    public void the_user_clicks_basket_button() {
        loginPage.basketBtn.click();
    }

    @Then("The user verify that basket is empty and able to see {string}")
    public void the_user_verify_that_basket_is_empty_and_able_to_see(String expectedText) {
        basketPage.waitUntil(basketPage.emptyBasketText);
        String actualText = basketPage.emptyBasketText.getText();
        Assert.assertEquals(expectedText, actualText);
        basketPage.backBtn.click();
        //Initialize.driver.navigate().back();
    }

    @Then("The user able to see all menu list in console and verify that size is {int}")
    public void the_user_able_to_see_all_menu_list_in_console_and_verify_that_size_is(int expectedSize) {
        loginPage.waitUntil(loginPage.categoryDondurma);

        int actualSize = loginPage.menuList.size();

//        for (AndroidElement androidElement : loginPage.menuList) {
//            System.out.println(androidElement.getText());
//        }

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Then("The user clicks second category which is {string}")
    public void the_user_clicks_second_category_which_is(String categoryName) {
        loginPage.getCategory(categoryName);
    }

    @Then("The user adds two different items")
    public void the_user_adds_two_different_items() {
        basketPage.waitUntil(basketPage.addBtn);
        basketPage.addBtn.click();
        basketPage.addBtn.click();
    }

    @Then("The user adds item with name: {string}")
    public void the_user_adds_item_with_name(String itemName) {
        basketPage.addItem(itemName);
    }

    @Then("The user scroll down to {string}")
    public void the_user_scroll_down_to(String itemName) {
        new ScrollHelper().scrollVerticalHelper(itemName);

    }

    @Then("The user verify that {string}")
    public void the_user_verify_that(String expectedAmount) {
        basketPage.waitUntil(basketPage.totalAmount);
        String actualAmount = basketPage.totalAmount.getText();
        Assert.assertEquals(expectedAmount,actualAmount);

    }

}
