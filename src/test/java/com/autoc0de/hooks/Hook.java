package com.autoc0de.hooks;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Hook {
    private static RemoteWebDriver driver;

    @Before("@ExampleTag")
    public void setUp() throws MalformedURLException {
        //CAPABILITIES
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "");
        caps.setCapability("app", "");
        caps.setCapability("platformName", "");
        caps.setCapability("avd", "");
        caps.setCapability("resetKeyboard", "");
        caps.setCapability("unicodeKeyboard", "");
        caps.setCapability("appActivity", "");
        caps.setCapability("appPackage", "");
        //URL APPIUM SERVER
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        //DRIVERS
        driver = new AndroidDriver<MobileElement>(url,caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario s){
        if (s.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            s.attach(screenshot, "image/png", "screenshot");
        }
        getDriver().quit();
    }

    public static RemoteWebDriver getDriver()
    {
        return driver;
    }

}
