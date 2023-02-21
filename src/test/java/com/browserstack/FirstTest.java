package com.browserstack;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class FirstTest extends BaseTest {

    @Test
    public void test() throws Exception {
        WebElement alertButtonElement = driver.findElement(AppiumBy.accessibilityId("alert-btn-acc-id"));

        alertButtonElement.click();

        String alertDialogMessageText = driver.findElement(AppiumBy.id("android:id/message")).getText();
        Assert.assertEquals(alertDialogMessageText, "Show Alert page");

        WebElement alertDialogNoButtonElement = driver.findElement(AppiumBy.id("android:id/button2"));
        alertDialogNoButtonElement.click();

        Assert.assertTrue(alertButtonElement.isDisplayed());

        alertButtonElement.click();

        WebElement alertDialogYesButtonElement = driver.findElement(AppiumBy.id("android:id/button1"));
        alertDialogYesButtonElement.click();

        Thread.sleep(5000);

        WebElement alertPageGoBackButtonElement = driver.findElement(AppiumBy.accessibilityId("alert-page-go-back-acc-id"));
        Assert.assertTrue(alertPageGoBackButtonElement.isDisplayed());


    }
}
