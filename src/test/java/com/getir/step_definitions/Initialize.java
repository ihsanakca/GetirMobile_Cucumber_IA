package com.getir.step_definitions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Initialize {
    public static AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() {
        initializeDriver();
        driver.resetApp();
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        Thread.sleep(3000);

        driver.closeApp();
    }

    public void initializeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid", "3c7eb8");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xaomi Redmi Note 8");

        DesiredCapabilities capabilities2 = new DesiredCapabilities();
        capabilities2.setCapability("appium:udid", "emulator-5554");
        capabilities2.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities2.setCapability(MobileCapabilityType.VERSION, "11.0");
        capabilities2.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");

        //com.getir.casestudy.dev/com.getir.casestudy.modules.login.ui.LoginActivity
        //com.getir.casestudy.dev/com.getir.casestudy.modules.splash.ui.SplashActivity

        capabilities.setCapability("appPackage", "com.getir.casestudy.dev");
        capabilities.setCapability("appActivity", "com.getir.casestudy.modules.splash.ui.SplashActivity");

        capabilities2.setCapability("appPackage", "com.getir.casestudy.dev");
        capabilities2.setCapability("appActivity", "com.getir.casestudy.modules.splash.ui.SplashActivity");

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities2);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


}
