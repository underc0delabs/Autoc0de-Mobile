package tests;

import com.autoc0de.utility.Utils;
import io.appium.java_client.MobileBy;
import com.autoc0de.hooks.Hook;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MasterPage extends Hook {


    protected WebDriverWait wait;
    protected FluentWait<RemoteWebDriver> fluentWait;
    protected RemoteWebDriver driver;

    public MasterPage() {
        this.driver = Hook.getDriver();
        this.wait = new WebDriverWait(getDriver(), 30);
        this.fluentWait = new FluentWait<RemoteWebDriver>(this.driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(10)).ignoring(Exception.class);
    }


    public WebDriverWait getWait() {
        return this.wait = new WebDriverWait(driver, 30);
    }

    public Wait<RemoteWebDriver> getFluentWait() {
        return this.fluentWait;
    }

    public WebElement getWebElement(By locator) {
        return (WebElement) this.getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> getWebElements(By locator) {
        return (List) this.getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void genericScroll(int startX, int startY, int endX, int endY){
        TouchAction ts = new TouchAction((PerformsTouchActions) getDriver());
        ts.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
    }

    public void setTapElement(By locator) {
        WebElement element = this.getWebElement(locator);
        this.setTapElement(element);
    }

    public void setTapElement(WebElement element) {
        element.click();
    }

    public void setTextToInput(By locator, String value) {
        WebElement element = this.getWebElement(locator);
        this.setTextToInput(element, value);
    }

    public void setTextToInput(WebElement element, String value) {
        this.setTapElement(element);
        element.clear();
        this.setTextToInputWithoutClick(element, value);
    }

    public void setTextToInputWithoutClear(By locator, String value) {
        WebElement element = this.getWebElement(locator);
        this.setTapElement(element);
        this.setTextToInputWithoutClick(element, value);
    }

    public void setTextToInputWithoutClick(By locator, String value) {
        WebElement element = this.getWebElement(locator);
        this.setTextToInputWithoutClick(element, value);
    }

    public void setTextToInputWithoutClear(WebElement element, String value) {
        this.setTapElement(element);
        element.sendKeys(new CharSequence[]{value});
    }

    public void setTextToInputWithoutClick(WebElement element, String value) {
        element.clear();
        element.sendKeys(new CharSequence[]{value});
    }

    public String getElementText(By locator) {
        WebElement element = this.getWebElement(locator);
        return this.getElementText(element);
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public String getInputValue(By locator) {
        WebElement element = this.getWebElement(locator);
        return this.getInputValue(element);
    }

    public String getInputValue(WebElement element) {
        return element.getAttribute("value");
    }

    public void selectCheckbox(By locator) {
        WebElement checkbox = this.driver.findElement(locator);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

    }

    public void deselectCheckbox(By locator) {
        WebElement checkbox = this.driver.findElement(locator);
        if (checkbox.isSelected()) {
            checkbox.click();
        }

    }

    public boolean isElementPresent(By locator) {
        this.driver.manage().timeouts().implicitlyWait(0L, SECONDS);

        boolean var3;
        try {
            this.getDriver().findElement(locator);
            boolean var2 = true;
            return var2;
        } catch (NoSuchElementException var7) {
            var3 = false;
        } finally {
            this.driver.manage().timeouts().implicitlyWait(2L, SECONDS);
        }

        return var3;
    }

    public boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isElementVisible(By locator) {
        return this.isElementVisible(this.getWebElement(locator));
    }

    public boolean waitAndCheckElementPresent(By locator) {
        try {
            this.getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException var3) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element, By locator) {
        this.driver.manage().timeouts().implicitlyWait(0L, SECONDS);

        boolean var4;
        try {
            element.findElement(locator);
            boolean var3 = true;
            return var3;
        } catch (NoSuchElementException var8) {
            var4 = false;
        } finally {
            this.driver.manage().timeouts().implicitlyWait(2L, SECONDS);
        }

        return var4;
    }

    public boolean isInputElementEmpty(By inputLocator) {
        return this.isInputElementEmpty(this.getWebElement(inputLocator));
    }

    public boolean isInputElementEmpty(WebElement element) {
        return element.getAttribute("value").isEmpty();
    }

    public boolean isElementEmpty(By locator) {
        return this.isElementEmpty(this.getWebElement(locator));
    }

    public boolean isElementEmpty(WebElement element) {
        return element.getText().isEmpty();
    }

    public void dragAndDrop(WebElement elementToDrag, WebElement elementToReplace) {
        JavascriptExecutor jse = this.driver;
        jse.executeScript("arguments[0].scrollIntoView()", new Object[]{elementToReplace});
        (new Actions(this.driver)).dragAndDrop(elementToDrag, elementToReplace).perform();
    }

    public void waitForElementDisappears(By locator) {
        this.getFluentWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementVisibility(By locator) {
        this.getFluentWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementInvisibility(By locator) {
        this.getFluentWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementPresence(By locator) {
        this.getFluentWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void setTextToClipboard(String value) {
        StringSelection stringSelection = new StringSelection(value);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, (ClipboardOwner)null);
    }

    public void waitUntilElementDissappear(By locator) {
        if (this.isElementPresent(locator)) {
            this.getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }

    }

    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException var4) {
            System.out.println("Error in sleep: ".concat(var4.getMessage()));
            var4.printStackTrace();
        }

    }

    public void scrollToElementByResourceId(String id) {
        String uiSelector = "new UiSelector().resourceId(\"" + id + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
        this.driver.findElement(MobileBy.AndroidUIAutomator(command));
    }

    public void scrollToElementByAccessibilityId(String accessibilityId) {
        String uiSelector = "new UiSelector().description(\"" + accessibilityId + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
        this.driver.findElement(MobileBy.AndroidUIAutomator(command));
    }

    public void setTextToInput(WebElement element, String value, String placeholder) {
        if (!Utils.isTextFieldEmpty(element, placeholder)) {
            element.clear();
        }

        this.setTextToInputWithoutClear(element, value);
    }

    public void setTextToInput(By locator, String value, String placeholder) {
        WebElement element = this.getWebElement(locator);
        this.setTextToInput(element, value, placeholder);
    }

    public void selectOptionSpinner(String option) {
        String uiSelector = "new UiSelector().textContains(\"" + option + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
        WebElement element = this.driver.findElement(MobileBy.AndroidUIAutomator(command));
        this.setTapElement(element);
    }

}
