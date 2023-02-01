package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSerachPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {
    //creating the page object
    GoogleSerachPage googleSerachPage = new GoogleSerachPage();


    @Given("User is on the google search page")
    public void user_is_on_the_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }

    @Then("User should see title is Google")
    public void user_should_see_title_is_google() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @When("user searches apple")
    public void userSearchesApple() {

        //sending value into search box using page object
        googleSerachPage.searchBox.sendKeys("apple" + Keys.ENTER);

    }

    @Then("user should see apple in the google title")
    public void userShoulSeeAppleInTheGoogleTitle() {
        String expectedTitle = "apple - Google Search";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @When("user searches {string}")
    public void userSearches(String searchValue) {

        //sending value into search box using page object
        googleSerachPage.searchBox.sendKeys(searchValue + Keys.ENTER);
    }

    @Then("user should see {string} in the google title")
    public void userShouldSeeInTheGoogleTitle(String expectedInTitle) {
        String expectedTitle = expectedInTitle + " - Google Search";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Then("User should see about link")
    public void userShouldSeeAboutLink() {
        //asserting that about link is displayed
       Assert.assertTrue(googleSerachPage.aboutLink.isDisplayed());
    }
    @Then("User should see title Google - About Google,Our Culture & Company News")
    public void userShouldSeeTitleGoogleAboutGoogleOurCultureCompanyNews() {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="Google - About Google,Our Culture & Company News";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @And("User click to About link")
    public void userClickToAboutLink() {
        googleSerachPage.aboutLink.click();
    }




    }
