package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.LoginPage;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.DocuportConstants;
import io.loop.utilities.Driver;

import static org.junit.Assert.assertTrue;

public class LoginStepDefs {
     LoginPage loginPage = new LoginPage();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
     Driver.getDriver().get(ConfigurationReader.getProperties("docuportBETA"))  ;
    }
    @When("user enters username for Client")
    public void user_enters_username_for_client() {
        BrowserUtils.waitForClickable(LoginPage.loginButton, DocuportConstants.EXTRA_LARGE);
        assertTrue("Login button is NOT displayed", LoginPage.loginButton.isDisplayed());
        LoginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT_GROUP1);
        LoginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_GROUP1);
        LoginPage.loginButton.click();
    }
    @When("User enters password for client")
    public void user_enters_password_for_client() {


    }

    @When("user clicks login button")
    public void user_clicks_login_button() {


    }

    @Then("user should be able to see the home for client")
    public void user_should_be_able_to_see_the_home_for_client() {
       assertTrue("Intentially failing",false);


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

    }
