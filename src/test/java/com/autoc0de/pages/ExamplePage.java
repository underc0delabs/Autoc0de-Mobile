package com.autoc0de.pages;

import io.appium.java_client.MobileBy;
import org.testng.Assert;
import tests.MasterPage;

public class ExamplePage extends MasterPage {

    //PAGE INSTANCE


    //CONSTANTS
    private final String TITLE_LABEL_ACCESIBILITY_ID = "title";
    private final String USER_INPUT_ACCESIBILITY_ID = "user";
    private final String PASS_INPUT_ACCESIBILITY_ID = "pass";
    private final String BUTTON_ACCESIBILITY_ID = "button";
    private final String RESULT_LABEL_ACCESIBILITY_ID = "textoResultado";

    public ExamplePage() {
    }

    //FUNCTIONS
    public void validateLoginScreen(){
        Assert.assertTrue(auto_isElementVisible(MobileBy.AccessibilityId(TITLE_LABEL_ACCESIBILITY_ID)));
    }

    public void completeLoginFields(String user, String pass){
        auto_setTextToInput(MobileBy.AccessibilityId(USER_INPUT_ACCESIBILITY_ID), user);
        auto_setTextToInput(MobileBy.AccessibilityId(PASS_INPUT_ACCESIBILITY_ID), pass);
    }

    public void doClickInButton(){
        auto_setTapElement(MobileBy.AccessibilityId(BUTTON_ACCESIBILITY_ID));
    }

    public void validateCorrectLogin(){
        Assert.assertTrue(auto_isElementVisible(MobileBy.AccessibilityId(RESULT_LABEL_ACCESIBILITY_ID)), "The logged in messaje is not displayed");
        Assert.assertEquals(auto_getElementText(MobileBy.AccessibilityId(RESULT_LABEL_ACCESIBILITY_ID)), "Your are Logged in!", "Incorrect login");
    }

}
