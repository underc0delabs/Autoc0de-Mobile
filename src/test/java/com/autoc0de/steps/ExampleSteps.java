package com.autoc0de.steps;

import com.autoc0de.pages.*;
import io.cucumber.java.en.*;


public class ExampleSteps {

    //PAGE INSTANCE
    ExamplePage examplePage = new ExamplePage();

    @Given("the user is on the login screen of Example App")
    public void theUserIsOnTheLoginScreenOfExampleApp() {
        examplePage.validateLoginScreen();
    }

    @When("^the user enter his credentials User Name: (.*) and Password (.*)$")
    public void theUserEnterHisCredentialsUserNameUsernameAndPasswordPassword(String user, String pass) {
        examplePage.completeLoginFields(user, pass);
    }

    @And("the user tap the Login button")
    public void theUserTapTheLoginButton() {
        examplePage.doClickInButton();
    }

    @Then("the user verifies that he was on the Welcome to Autoc0de screen")
    public void theUserVerifiesThatHeWasOnTheWelcomeToAutocDeScreen() {
        examplePage.validateCorrectLogin();
    }
}
