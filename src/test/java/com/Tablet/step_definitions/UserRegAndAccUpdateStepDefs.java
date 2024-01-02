package com.Tablet.step_definitions;

import com.Tablet.pages.AccountPage;
import com.Tablet.pages.TabletHomePage;
import com.Tablet.utilities.ConfigurationReader;
import com.Tablet.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class UserRegAndAccUpdateStepDefs {

    TabletHomePage tabletHomePage = new TabletHomePage();
    AccountPage accountPage = new AccountPage();

    @Given("user is on the Tablet home page")
    public void user_is_on_the_tablet_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("tabletUrl"));
    }


    @When("user selects {string} from the homepage header navigation menu")
    public void user_selects_from_the_homepage_header_navigation_menu(String registration) {
        tabletHomePage.mainMenu.click();
        tabletHomePage.registerButton.click();

    }

    @When("user fills out email input with valid email and clicks submit")
    public void user_fills_out_email_input_with_valid_email_and_clicks_submit() throws InterruptedException {
        //generating email as per request using dynamic email from Config.properties and method created in BrowserUtils
        String formattedEmail = TabletHomePage.generateFormattedEmail(ConfigurationReader.getProperty("email"));

        // in case I need to store this email for future login, assigned in a class level
        tabletHomePage.enterEmailInputBox.sendKeys(formattedEmail);
        tabletHomePage.submitButton.click();
        Thread.sleep(2000);
        //using Thread.sleep for demonstration purposes to better define each step
    }

    @And("user fills first name and last name and clicks submit")
    public void user_fills_first_name_and_last_name_and_clicks_submit() {
        tabletHomePage.fillAndSubmitRegistrationForm();
    }


    @And("user provides valid password and submits the registration form")
    public void user_provides_valid_password_and_submits_the_registration_form() throws InterruptedException {
        Thread.sleep(2000);
        tabletHomePage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        tabletHomePage.submitButton.click();


    }

    @Then("the user should have a registered account")
    public void the_user_should_have_a_registered_account() throws InterruptedException {
        Thread.sleep(4000);
        //Verifying registration message
        Assert.assertEquals("You're in! Always stay signed in and you’ll always see our lowest prices.", tabletHomePage.registerConfirmationMessage.getText());
    }


    @Then("user updates their bio with new information")
    public void user_updates_their_bio_with_new_information() throws InterruptedException {

        //accountPage.gotItButton.click();
        tabletHomePage.mainMenu.click();
        accountPage.myInfoPage.click();
        Thread.sleep(3000);
        // Create a Faker instance
        Faker faker = new Faker();
        // Generate a random sentence
        String randomText = faker.lorem().sentence();
        accountPage.bioTextField.sendKeys(randomText);

    }

    @When("user uploads a profile image and saves updates")
    public void user_uploads_a_profile_image_and_saves_updates() throws AWTException, InterruptedException {

        //uploading image
        System.err.println("\nAutomated image upload is inconsistent on my Mac, I will leave it commented out, so the entire TC runs smoothly\n");

        //  <----- delete this to test Img Upload
        accountPage.chooseButton.click();
        //------------------------------------------------
        //change this PATH to the image on your local MAC
        //------------------------------------------------
        String filePath = "/Users/nazarkravets/Downloads/NewProfilePhoto.jpg";
        accountPage.uploadFileWithRobot(filePath);//the robot method is set for macOS shortcuts
                                                  // you check the methods logic in AccountPage
        accountPage.imDoneButton.click();

        //<----- delete this to test Img Upload

        accountPage.saveProfileButton.click();
    }

    @Then("the user signs out and should be redirected to the homepage")
    public void the_user_signs_out_and_should_be_redirected_the_homepage() throws InterruptedException {

        Thread.sleep(3000);
        tabletHomePage.mainMenu.click();
        accountPage.signOutButton.click();
    }
}


