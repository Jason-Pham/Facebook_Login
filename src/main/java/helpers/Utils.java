package helpers;

import com.vimalselvam.cucumber.listener.Reporter;
import helpers.ReportHelper.ScreenshotHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Utils {

    public static long waitTime = 15;
    private static String DataJson = "src/main/java/helpers/TestData/DataTest.json";

    public static void captureScreenshot() throws IOException {
        Reporter.addScreenCaptureFromPath(ScreenshotHelper.takeScreenshot(Hooks.driver,
                LocalDateTime.now().getHour()
                        + LocalDateTime.now().getMinute()
                        + String.valueOf(LocalDateTime.now().getSecond())));
    }

    private static void waitForElement(WebElement element, long time) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(Hooks.driver, time);
            wait.until(elementToBeClickable(element));
        } catch (NullPointerException | WebDriverException e) {
            captureScreenshot();
            Reporter.addStepLog("Waiting for this element is failed: " + element.getText());
            Assert.fail();
        }
    }

    public static void waitForElements(List<WebElement> elements, long time) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(Hooks.driver, time);
            for (WebElement element : elements)
                wait.until(elementToBeClickable(element));
        } catch (NullPointerException | WebDriverException e) {
            captureScreenshot();
            Reporter.addStepLog("Waiting for this element is failed: " + elements.get(0).getText());
            Assert.fail();
        }
    }

    public static void click(WebElement element) throws IOException {
        try {
//            waitForPageToLoad();
            waitForElement(element, waitTime);
            element.click();

            captureScreenshot();
        } catch (NullPointerException | WebDriverException e) {
            captureScreenshot();
            Reporter.addStepLog("Clicking in this element is failed: " + element.getText());
            Assert.fail("");
        }
    }

    private static void clear(WebElement element) throws IOException {
        try {
            waitForElement(element, waitTime);

            element.clear();
        } catch (NullPointerException | WebDriverException e) {
            captureScreenshot();
            Reporter.addStepLog("Clearing this element is failed: " + element.getText());
            Assert.fail();
        }
    }

    public static void sendKeys(WebElement element, String keys) throws IOException {
        try {
            waitForElement(element, waitTime);
//            clear(element);

            element.sendKeys(keys);
            captureScreenshot();
        } catch (NullPointerException | WebDriverException e) {
            captureScreenshot();
            Reporter.addStepLog("Send keys for this element is failed: " + element.getText());
            Assert.fail();
        }
    }

    public static void waitForPageToLoad() {
        while (true) {
            if (new WebDriverWait(Hooks.driver,
                    waitTime + 15).until(
                    new Function<WebDriver, Boolean>() {
                        @Override
                        public Boolean apply(WebDriver webDriver) {
                            return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
                        }
                    })) {
                break;
            }
        }
    }

    public static String getDataFromJson(String key) {
        String value = "";
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(DataJson));
            JSONObject jsonObject = (JSONObject) obj;
            value = (String) jsonObject.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static boolean elementExists(String e_xpath) throws IOException {
        try {
            return Hooks.driver.findElements(By.xpath(e_xpath)).isEmpty();
        } catch (NullPointerException | WebDriverException e) {
            captureScreenshot();
            Reporter.addStepLog("Element is exists: ");
            Assert.fail();
        }

        return false;
    }

    public static void reloadPage() throws IOException {
        try {
            Hooks.driver.navigate().refresh();
        } catch (NullPointerException | WebDriverException e) {
            captureScreenshot();
            Reporter.addStepLog("Reload page failed: ");
            Assert.fail();
        }
    }
}
