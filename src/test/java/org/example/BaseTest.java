package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {


    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass    //  testNG will run this method before executing any class >>
    public void ConfigureAppium() throws URISyntaxException, MalformedURLException {
        // start appium server programitacally
        // you need to tell where is your main.js file stored >> It is used to invoje appium server

        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        // it is expecting file, so we adapt ny converting string into file.

        service.start();   // this is how you programitacally start your service without manually typing appium in terminal


        //AndroidDriver >> Create object in.jsfor Android Driver
        // Appium code>> Appium server>> Mobile
        // android driver taked 2 args, server location and phone capabilities

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel");
        options.setApp("//home//varun-pathak//IdeaProjects//Appium_New//src//test//java//org/example//resources//ApiDemos-debug.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //driver.quit();
        //service.stop();
        // stop server
        // Everything above is 1 time effort

        // Actual Automation

        // Locators>> xpath ,id, classname, androiduiautomator
        // using appium inspector get the locators
        // appium also supports accessbilityid and xpath
        // to use accessibilityid and indroiduiautomator locators , use AppiumBy. command instead of just By. command
        //driver.findElement(AppiumBy.accessibilityId("Preference")).click();
    }
    //@AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();

    }
}
