package com.autoc0de.steps;

import com.autoc0de.pages.*;
import io.cucumber.java.en.*;


public class ExampleSteps {

    //PAGE INSTANCE
    ExamplePage examplePage = new ExamplePage();

    @Given("the user is on the login screen of Example App")
    public void theUserIsOnTheLoginScreenOfExampleApp() {
    }

    @When("the user enter his credentials User Name: <username> and Password <password>")
    public void theUserEnterHisCredentialsUserNameUsernameAndPasswordPassword() {
    }

    @And("the user tap the Login button")
    public void theUserTapTheLoginButton() {
    }

    @Then("the user verifies that he was on the Welcome to Autoc{int}de screen")
    public void theUserVerifiesThatHeWasOnTheWelcomeToAutocDeScreen(int arg0) {
    }
}
