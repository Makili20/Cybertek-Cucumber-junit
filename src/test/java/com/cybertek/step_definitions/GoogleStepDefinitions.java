package com.cybertek.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GoogleStepDefinitions {


    @Given("User is on the google search page")
    public void user_is_on_the_google_search_page() {
        System.out.println("User is on the Google search page!");
    }

    @Then("User should see title is Google")
    public void user_should_see_title_is_google() {
        System.out.println("User sees the title is Google!");
    }





}
