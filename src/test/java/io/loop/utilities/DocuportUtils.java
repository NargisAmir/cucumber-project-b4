package io.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class DocuportUtils {

        /**
         * logins to docuport application
         * @param driver,which is initilazed in the test base
         * @param role,comes from docuport constants
         *  author nargiz
         */
        public static void login(WebDriver driver, String role) throws InterruptedException {
            driver.get(ConfigurationReader.getProperties("docuportBETA"));
            WebElement username = driver.findElement(By.xpath("//label[.='Username or email']/following-sibling::input"));
            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

            switch (role.toLowerCase()){
                case "client":
                    username.sendKeys(DocuportConstants.USERNAME_CLIENT_GROUP1);
                    password.sendKeys(DocuportConstants.PASSWORD_GROUP1);
                    break;
                case "supervisor":
                    username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                    password.sendKeys(DocuportConstants.PASSWORD_GROUP1);
                    break;
                case "advisor":
                    username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                    password.sendKeys(DocuportConstants.PASSWORD_GROUP1);
                    break;
                case "employee":
                    username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                    password.sendKeys(DocuportConstants.PASSWORD_GROUP1);
                    break;
                default: throw new InterruptedException("There is not such a role: " + role);

            }

            loginButton.click();

            if(role.toLowerCase().equals("client")){
                Thread.sleep(3000);
                WebElement cont = driver.findElement(By.xpath("//button[@type='submit']"));
                cont.click();
                Thread.sleep(3000);
            }
        }

    /**
     * logs out from Docuport application
     * @param driver
     * @author narg
     */

    public static void logout(WebDriver driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
        WebElement logoutButton = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logoutButton.click();





    }

}
