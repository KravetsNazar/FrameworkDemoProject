package com.Tablet.step_definitions;

import com.Tablet.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {

    @Before
    public void setUp() {
        // we put a logic that should apply to every scenario
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @After
    public void tearDown(Scenario scenario) {
        // only takes a screenshot if the scenario fails
        if (scenario.isFailed()) {
            // taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","screenshot");
        }
        Driver.closeDriver();
    }



}

