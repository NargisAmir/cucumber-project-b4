package io.loop.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
     * Creating the private constructor so this classes object is not reachable from outside
     */
    private Driver() {}

    /*
    making driver instance private
    static-run before everything else and user in static method
     */
   // private static WebDriver driver;
    //implement threadLocal to achieve multi thread local
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    reusable method that will return same driver instance everytime called
     */
    /**
     * singleton pattern
     * @return
     */
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browserType = ConfigurationReader.getProperties("browser");
            switch (browserType.toLowerCase()) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    driverPool.get().manage().window().maximize();
                    break;

                case "firefox":
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    driverPool.get().manage().window().maximize();
                    break;

                case "safari":
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    driverPool.get().manage().window().maximize();
                    break;

                case "headless":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    driverPool.get().manage().window().maximize();
                    break;
            }
           // driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driverPool.get();
    }

    /**
     * closing driver
     * @author nargi
     */

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
           // driver = null;
            driverPool.remove();
        }
    }
}
