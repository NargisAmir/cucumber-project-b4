//package io.loop.step_definitions;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.loop.pages.LoginPage;
//import io.loop.utilities.BrowserUtils;
//import io.loop.utilities.ConfigurationReader;
//import io.loop.utilities.DocuportConstants;
//import io.loop.utilities.Driver;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import javax.swing.*;
//import java.util.Map;
//
//import static org.junit.Assert.assertTrue;
//
//public class LoginStepDefs {
//
//    LoginPage loginPage = new LoginPage();
//    private static final Logger LOG = LogManager.getLogger();
//
//    @Given("user is on Docuport login page")
//    public void user_is_on_docuport_login_page() {
//        Driver.getDriver().get(ConfigurationReader.getProperties("docuportBETA"));
//        BrowserUtils.takeScreenShot();
//        LOG.info("user is on docuport login page");
//    }
//
//    @When("user enters username for client")
//    public void user_enters_username_for_client() {
//        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.EXTRA_LARGE);
//        assertTrue("Login button is NOT displayed", loginPage.loginButton.isDisplayed());
//        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT_GROUP1);
//        BrowserUtils.takeScreenShot();
//        LOG.info("user enters username");
//    }
//
//    @When("user enters password for client")
//    public void user_enters_password_for_client() {
//        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_GROUP1);
//        BrowserUtils.takeScreenShot();
//        LOG.info("user enters password");
//    }
//
//    @When("user click login button")
//    public void user_click_login_button() {
//        loginPage.loginButton.click();
//        BrowserUtils.takeScreenShot();
//        LOG.info("user clicks login button");
//    }
//
//    @Then("user should be able to see the home for client")
//    public void user_should_be_able_to_see_the_home_for_client() {
//        BrowserUtils.takeScreenShot();
//        assertTrue(loginPage.continueButton.isDisplayed());
//    }
//
//    @When("user enters username for employee")
//    public void user_enters_username_for_employee() {
//
//    }
//    @When("user enters password for employee")
//    public void user_enters_password_for_employee() {
//
//    }
//    @Then("user should bbe able to see the home for employee")
//    public void user_should_bbe_able_to_see_the_home_for_employee() {
//
//    }
//
//
//    @When("user enters username for advisor")
//    public void user_enters_username_for_advisor() {
//
//    }
//
//    @When("user enters password for advisor")
//    public void user_enters_password_for_advisor() {
//
//    }
//
//    @Then("user should bbe able to see the home for advisor")
//    public void user_should_bbe_able_to_see_the_home_for_advisor() {
//
//    }
//
//    @When("user enters username for supervisor")
//    public void user_enters_username_for_supervisor() {
//
//    }
//    @When("user enters password for supervisor")
//    public void user_enters_password_for_supervisor() {
//
//    }
//    @Then("user should bbe able to see the home for supervisor")
//    public void user_should_bbe_able_to_see_the_home_for_supervisor() {
//
//    }
//
//    @When("user enters credentials")
//    public void user_enters_credentials(Map<String, String > credentials) {
//        for (Map.Entry<String, String> entry : credentials.entrySet()) {
//            String key = entry.getKey();
//            System.out.println("key = " + key);
//
//            String value = entry.getValue();
//            System.out.println("value = " + value);
//
//            System.out.println("==========================");
//        }
//
//        loginPage.login2(credentials.get("username"), credentials.get("password"));
//
//    }
//}
package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.LoginPage;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.DocuportConstants;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.remote.http.jdk.JdkHttpClient.LOG;


public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();


    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuportBETA"))  ;
        BrowserUtils.takeScreenShot();
        LOG.info("user is on docuport login page");
    }
    @When("user enters username for Client")
    public void user_enters_username_for_client() {
        BrowserUtils.waitForClickable(LoginPage.loginButton, DocuportConstants.EXTRA_LARGE);
        assertTrue("Login button is NOT displayed", LoginPage.loginButton.isDisplayed());
        LoginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT_GROUP1);
        LoginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_GROUP1);
        LoginPage.loginButton.click();
        BrowserUtils.takeScreenShot();
        LOG.info("user enters username");

    }
    @When("User enters password for client")
    public void user_enters_password_for_client() {
        BrowserUtils.takeScreenShot();
        LOG.info("user enters password");
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        BrowserUtils.takeScreenShot();
        LOG.info("user clicks login button");
    }

    @Then("user should be able to see the home for client")
    public void user_should_be_able_to_see_the_home_for_client() {
        BrowserUtils.takeScreenShot();
        assertTrue(loginPage.continueButton.isDisplayed());


    }
    @When("user enters username for employee")
    public void user_enters_username_for_employee() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("User enters password for employee")
    public void user_enters_password_for_employee() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("user should be able to see the home for employee")
    public void user_should_be_able_to_see_the_home_for_employee() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("User enters password for advisor")
    public void user_enters_password_for_advisor() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("user should be able to see the home for advisor")
    public void user_should_be_able_to_see_the_home_for_advisor() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user enters username for supervisor")
    public void user_enters_username_for_supervisor() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("User enters password for supervisor")
    public void user_enters_password_for_supervisor() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("user should be able to see the home supervisor")
    public void user_should_be_able_to_see_the_home_supervisor() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("user enters credentials")
    public void user_enters_credentials(Map<String,String> credentials) {
          for (Map.Entry<String, String> entry : credentials.entrySet()) {
           String key = entry.getKey();
             System.out.println("key = " + key);

           String value = entry.getValue();
           System.out.println("value =" + value );
          System.out.println("================================");
           }
        loginPage.login2(credentials.get("username"), credentials.get("password"));
    }

}