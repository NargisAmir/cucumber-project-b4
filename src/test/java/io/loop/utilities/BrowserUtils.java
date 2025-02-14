package io.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.junit.Assert.assertTrue;


public class BrowserUtils {
    /**
     * validate if driver switched to expected url or title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author NSH
     * implement assertion
     */
    public static void switchWindowAndValidate(WebDriver driver,String expectedUrl,String expectedTitle) {
        //to lowercase the params in order to avoiw miss type
        expectedTitle=expectedTitle.toLowerCase();
        expectedUrl=expectedUrl.toLowerCase();

        //get all window handles,switch one by one and eachTime check if url matches expected to stop
        Set<String> windowHandles=driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }
        //after stopping on expected url ,validate the title
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));

    }

    /**
     * param driver
     * @param targerTitle
     * @author NA
     *
     */
    public static void switchToWindow(WebDriver driver,String targerTitle) {
        String origin= driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if(driver.getTitle().contains(targerTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    /**
     * click any lik from loopPractice
     * @param nameOfPage
     * @author nargi
     */
    public static void loopLinkClick(String nameOfPage) {
        WebElement element= Driver.getDriver().findElement(By.xpath("//a[.='"+nameOfPage+"']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    /**
     * waits for provided element to be clickable
     * @param element
     * @param timeout
     * @return
     * @author nargi
     */
    public static WebElement waitForClickable(WebElement element,int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    /**
     * waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @author nargi
     */
    public static void  waitForInvisiblity(WebElement element,int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
      wait.until(ExpectedConditions.invisibilityOf(element));
    }
    /**
     * waitsfor the provided element to be visible on the page
     * @param element
     * @param timeToWaitSec
     * @author nargi
     */
    public static WebElement waitForVisible(WebElement element,int timeToWaitSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
