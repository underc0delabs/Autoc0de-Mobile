package com.autoc0de.hooks;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Hook {
    private static RemoteWebDriver driver;
    File filePath = new File(System.getProperty("user.dir"));
    File appDir = new File(filePath, "src/test/resources/apps");
    File app = new File(appDir, "Autoc0de.apk");

    @Before
    public void setUp() throws MalformedURLException {
        //CAPABILITIES
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName", "Pixel3");
        caps.setCapability("app", app.getAbsolutePath());
        caps.setCapability("platformName", "Android");
        caps.setCapability("avd", "Pixel_3_API_29");
        caps.setCapability("resetKeyboard", "true");
        caps.setCapability("unicodeKeyboard", "true");
        caps.setCapability("appActivity", "");
        caps.setCapability("appPackage", "com.example.autoc0de_mobile");
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
