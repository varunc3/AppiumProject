package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AppiumBasics extends BaseTest{     // inherit all methods and variables in parent class
    @Test
    public void WifiSettingsName() throws URISyntaxException, MalformedURLException {


        // Actual Automation

        // Locators>> xpath ,id, classname, androiduiautomator
        // using appium inspector get the locators
        // appium also supports accessbilityid and xpath
        // to use accessibilityid and indroiduiautomator locators , use AppiumBy. command instead of just By. command

        //ConfigureAppium(); // Call this method from parent method to start server and initialize drivers >> OR >> user BeforeClass Anotation above ths method in base class to
        // if you have to run it everytime

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        // driver is inherited from parent class (BaseTest)

        // xpath syntax //tagname[@attribute="value"]

        WebElement xyz= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"));
        System.out.println("Element Found");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();

        Assert.assertEquals(alertTitle, "WiFi settings");   // If matches, it will pass and script will stop.
        driver.findElement((By.id("android:id/edit"))).sendKeys("Varun Wifi");
        driver.findElement(By.id("android:id/button1")).click();





        //tearDown(); >> AfterClass



    }

}
