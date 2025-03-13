package io.loop.utilities;

import io.cucumber.java.Scenario;
import io.cucumber.java.lv.Ja;
import io.loop.pages.LeftNavigatePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;


public class BrowserUtils {
    private static final Logger LOG = LogManager.getLogger();
    public static Scenario myScenario;

    /**
     * takes screenchot
     *
     * @author nrg
     */
    public static void takeScreenShot() {
        try {
            myScenario.log("Current url is: " + Driver.getDriver().getCurrentUrl());
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot, "image/png", myScenario.getName());
        } catch (WebDriverException wbd) {
            wbd.getMessage();
        } catch (ClassCastException cce) {
            cce.getMessage();
        }
    }

    /**
     * validate if driver switched to expected url or title
     *
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author NSH
     * implement assertion
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        //to lowercase the params in order to avoiw miss type
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        //get all window handles,switch one by one and eachTime check if url matches expected to stop
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }
        //after stopping on expected url ,validate the title
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));

    }

    /**
     * param driver
     *
     * @param targerTitle
     * @author NA
     */
    public static void switchToWindow(WebDriver driver, String targerTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targerTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    /**
     * click any lik from loopPractice
     *
     * @param nameOfPage
     * @author nargi
     */
    public static void loopLinkClick(String nameOfPage) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfPage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     * @author nargi
     */
    public static WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    /**
     * waits for the provided element to be invisible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @author nargi
     */
    public static void waitForInvisiblity(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * waitsfor the provided element to be visible on the page
     *
     * @param element
     * @param timeToWaitSec
     * @author nargi
     */
    public static WebElement waitForVisiblity(WebElement element, int timeToWaitSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

//    /**
//     * Performs double click action on an element
//     *
//     * @param milliSeconds
//     * @author nrg
//     */
//    public static void justWait(int milliSeconds) {
//        try {
//            Thread.sleep(milliSeconds);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }


    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void uploadFileForWindows(String filePath) throws AWTException {
        //copy the file path
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        //
        Robot robot = new Robot();
        robot.delay(1000);

        //pres ctrl+v
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //press enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public static void uploadFileForMac(String filePath, String fileName) throws AWTException {
        Robot robot = new Robot();

        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);

        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);


        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public static void uploadFileUsingAppleScript(String filePath) throws Exception {
        String script = "tell application \"System Events\"\n"
                + "delay 1\n"
                + "keystroke \"G\" using {command down, shift down}\n"
                + "delay 1\n"
                + "keystroke \"" + filePath + "\"\n"
                + "keystroke return\n"
                + "delay 1\n"
                + "keystroke return\n"
                + "end tell";

        String[] command = {"osascript", "-e", script};
        Runtime.getRuntime().exec(command);
    }

    /**
     * Moves the mouse to given element
     *
     * @param element on which to hover
     * @author nrg
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element);
    }

    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     * @author nrg
     */

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Performs double click action on an element
     *
     * @param element author nrg
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).perform();

    }

    /**
     * performs a pause
     *
     * @param milliSeconds
     * @author nadir
     */
    public static void justWait(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
    }
    public static List<String> getElementsText(List<WebElement> elements){
        List<String> elementsText = new ArrayList<>();
        for (WebElement element : elements) {
            elementsText.add(element.getText());
        }
        return elementsText;
    }



    public static List<String> getElementsTextWithStream2(List<WebElement> elements) {
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public static void waitForPageLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectedConditions = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            LOG.info("Waiting for page load");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectedConditions);
        } catch (Throwable error) {
            LOG.error("Timeout waiting for the Page Load Request completed after: " + timeOutInSeconds + " seconds");
        }
    }

    public static void waitForStaleElement(WebElement element) {
        int y = 0;

        while (y <= 15) {
            try {
                element.isDisplayed();
                break;
            } catch (StaleElementReferenceException st) {
                y++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            } catch (WebDriverException we) {
                y++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            }
        }
    }

    public static void waitUntilPageLoad() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
        wait.until((WebDriver d) -> {
            Boolean isPageLoaded = (Boolean) ((JavascriptExecutor) Driver.getDriver())
                    .executeScript("return document.readyState").equals("complete");
            if (!isPageLoaded)
                LOG.info("Document is loading");
            return isPageLoaded;
        });
    }

    public static void createFileWithContent(String filePath, String content){
        File file = new File(filePath);

        try{
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            try{
                fw.write(content);
            } catch (Exception e) {
                LOG.error("Error during FileWriter append. " + e.getMessage(), e.getCause());
            } finally {
                try{
                    fw.close();
                } catch (Exception e){
                    LOG.error("Error during FileWriter close. " + e.getMessage(), e.getCause());
                }
            }
        } catch (IOException e){
            LOG.error(e.getMessage(), e.getCause());
        }

    }

}