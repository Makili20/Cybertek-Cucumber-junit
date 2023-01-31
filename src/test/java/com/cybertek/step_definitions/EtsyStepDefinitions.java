package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsyStepDefinitions {
    EtsySearchPage etsySearchPage=new EtsySearchPage();

    @Given("User is on the etsy home page")
    public void user_is_on_the_etsy_home_page() {
        Driver.getDriver().get("https://www.etsy.com");
    }
    @Then("User should see title is as expected")
    public void userShouldSeeTitleIsAsExpected() {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="Etsy - Shop for hanmade,vintage,custom,and unique gifts for everyone";
    }

    @When("User searches {string} in the search box")
    public void userSearchesInTheSearchBox(String searchValue) {
        etsySearchPage.searchBox.sendKeys(searchValue);

    }
    @And("User clicks tosearch button")
    public void userClicksTosearchButton() {
        etsySearchPage.searchButton.click();
    }

    @Then("User should see {string} in the Etsy title")
    public void userShouldSeeInTheEtsyTitle(String expectedInTitle) {

        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }
}
