package com.cybertek.step_definitions;

import com.cybertek.pages.WikiSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class WikiStepDefinitions {
    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("User is on the Wiki home page")
    public void user_is_on_the_wiki_home_page() {
        Driver.getDriver().get("https://www.wikipedia.com");
    }

    @When("User types {string} in the wiki search page")
    public void user_types_in_the_wiki_search_page(String string) {
        wikiSearchPage.searchBox.sendKeys(string + Keys.ENTER);
    }

    @Then("User should see {string} in the wiki title")
    public void user_should_see_in_the_wiki_title(String expectedInTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }


    @Then("USer should see {string} in the main header")
    public void userShouldSeeInTheMainHeader(String expected) {

        String actualHeaderText = wikiSearchPage.mainHeaderAfterSearch.getText();

        Assert.assertEquals(actualHeaderText,expected);
    }

    @Then("USer should see {string} in the image header")
    public void userShouldSeeInTheImageHeader(String expectedHeader) {
       String actualHeader= wikiSearchPage.imageAfterSearch.getText();

        Assert.assertEquals(actualHeader,expectedHeader);





    }
}


