//package io.loop.pages;
//
//import io.loop.utilities.BrowserUtils;
//
//import io.loop.utilities.DocuportConstants;
//import io.loop.utilities.Driver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import java.time.Duration;
//
//public class LoginPage {
//
//    public LoginPage(){
//        PageFactory.initElements(Driver.getDriver(), this);
//    }
//
//    @FindBy(xpath = "//input[@type='text']")
//    public static WebElement usernameInput;
//
//    @FindBy(xpath = "//input[@type='password']")
//    public static WebElement passwordInput;
//
//    @FindBy(xpath = "//button[@type='submit']")
//    public static WebElement loginButton;
//
//
//    @FindBy(xpath = "//span[.=' Continue ']")
//    public static WebElement continueButton;
//
//    public void insertField(String field,String input){
//        switch(field.toLowerCase().trim()){
//            case "username ":
//               // usernameInput.sendKeys(input);
//                BrowserUtils.waitForVisiblity(usernameInput,10).sendKeys(input);
//                break;
//
//                case "password ":
//                  //  passwordInput.sendKeys(input);
//                    BrowserUtils.waitForVisiblity(passwordInput,10).sendKeys(input);
//                        break;
//
//            default:// throw new IllegalArgumentException("No such a field"  + field);
//
//                }
//        }
//
//    public void clickButton(String button){
//        switch (button.toLowerCase().trim()){
//            case "login":
//                BrowserUtils.waitForClickable(loginButton, 10).click();
//                break;
//            case "continue":
//                try {
//                    BrowserUtils.waitForVisiblity(continueButton, 10).click();
//                    break;
//                }catch (Exception e){
//                    WebElement element= Driver.getDriver().findElement(By.xpath("//span[.='Continue']"));
//                    element.click();
//                }
//
//
//            default: throw new IllegalArgumentException("Not such a button: " + button);
//        }
//    }
//
//
//    /**
//     * logins to docuport application
//     * @param driver,which is initilazed in the test base
//     * @param role,comes from docuport constants
//     *  author nargiz
//     */
//    public void login(WebDriver driver, String role) throws InterruptedException {
//
//        switch (role.toLowerCase()) {
//            case "client":
//
//                usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT_GROUP1);
//                passwordInput.sendKeys(DocuportConstants.PASSWORD_GROUP1);
//                break;
//            case "supervisor":
//                usernameInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
//                passwordInput.sendKeys(DocuportConstants.PASSWORD_GROUP1);
//                break;
//            case "advisor":
//                usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
//                passwordInput.sendKeys(DocuportConstants.PASSWORD_GROUP1);
//                break;
//            case "employee":
//                usernameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
//                passwordInput.sendKeys(DocuportConstants.PASSWORD_GROUP1);
//                break;
//            default:
//                throw new InterruptedException("There is not such a role: " + role);
//
//        }
//
//        loginButton.click();
//
//        if (role.toLowerCase().equals("client")) {
//            Thread.sleep(3000);
//            WebElement cont = driver.findElement(By.xpath("//button[@type='submit']"));
//            cont.click();
//            Thread.sleep(3000);
//        }
//    }
//    public void login2(String username, String password){
//        BrowserUtils.waitForClickable(loginButton, 10);
//        usernameInput.clear();
//        usernameInput.sendKeys(username);
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
//        if (BrowserUtils.waitForVisiblity(continueButton, 10).isDisplayed()) {
//            continueButton.click();
//
//        }
//    }
//
//        }
package io.loop.pages;

import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.DocuportConstants;
import io.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.=' Continue ']")
    public WebElement continueButton;

    public void insertField(String field, String input){
        switch (field.toLowerCase().trim()){
            case "username":
                BrowserUtils.waitForVisiblity(usernameInput, 10).sendKeys(input);
                break;
            case "password":
                BrowserUtils.waitForVisiblity(passwordInput, 10).sendKeys(input);
                break;
            default: throw new IllegalArgumentException("No such a field: " + field );
        }
    }

    public void clickButton(String button){
        switch (button.toLowerCase().trim()){
            case "login":
                BrowserUtils.waitForClickable(loginButton, 10).click();
                break;
            case "continue":
                try {
                    BrowserUtils.waitForVisiblity(continueButton, 10).click();

                } catch (Exception e){
                    WebElement element = Driver.getDriver().findElement(By.xpath("//span[.=' Continue ']"));
                    element.click();
                }
                break;
            default: throw new IllegalArgumentException("Not such a button: " + button);
        }
    }

    /**
     *logins to docuport application
     * @param driver, which is initialized in the test base
     * @param role, comes from docuport constants
     * author nsh
     */
    public void login(WebDriver driver, String role) throws InterruptedException {
        switch (role.toLowerCase()){
            case "client":
                usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT_GROUP1);
                passwordInput.sendKeys(DocuportConstants.PASSWORD_GROUP1);
                break;
            case "supervisor":
                usernameInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                passwordInput.sendKeys(DocuportConstants.PASSWORD_GROUP1);
                break;
            case "advisor":
                usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                passwordInput.sendKeys(DocuportConstants.PASSWORD_GROUP1);
                break;
            case "employee":
                usernameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                passwordInput.sendKeys(DocuportConstants.PASSWORD_GROUP1);
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

    public void login2(String username, String password){
        BrowserUtils.waitForClickable(loginButton, 10);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        if (BrowserUtils.waitForVisiblity(continueButton, 10).isDisplayed()) {
            continueButton.click();
        }
    }

}



