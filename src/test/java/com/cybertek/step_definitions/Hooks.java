package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order = 2)
    public void setUpScenario() {
        System.out.println("-----> Before annotation:Setting up browser");
    }

    @Before(value = "@db", order = 1)
    public void setUpDataBaseConnection() {
        System.out.println("------> Before annotation: DB CONNECTION CREATED<------");
    }

    @After(order = 5)
    public void tearDownScenario(Scenario scenario) {
        //System.out.println("-----> After annotation:Closing browser");
        //  System.out.println("scenario.getName() = " + scenario.getName());
        //System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        // System.out.println("scenario.isFailed() = " + scenario.isFailed());

        //#1 we need to take a screen shotusing Selenium-->getScreenshotAs
        //to be able to use this method we need to cast our driver to TakeScreenshot
        //#2 we are going to attach it into our report
        //attach method accepts 3 arguments:1;screenshot itself,2:image type 3:current scenario name
        if(scenario.isFailed()){

        }
        byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

    }

    @After(value = "@db", order = 4)
    public void tearDownDataBaseConnection() {
        System.out.println("----->After annotation: DB CONNECTION CLOSED<------");
    }

    @BeforeStep
    public void setUpStep() {
        System.out.println("=======> BEFORE STEP: TAKING SCREENSHOT");
    }

    @AfterStep
    public void tearDOwnStep() {
        System.out.println("=======> AFTER STEP: TAKING SCREENSHOT");
    }


}
