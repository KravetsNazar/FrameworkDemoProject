package com.Tablet.pages;

import com.Tablet.utilities.ConfigurationReader;
import com.Tablet.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabletHomePage {
    public TabletHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@class='QuickMenu__launch']")
    public WebElement mainMenu;

    @FindBy(xpath = "//button[@aria-label='Register a new account.']")
    public WebElement registerButton;

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(id = "register_email_input")
    public WebElement enterEmailInputBox;

    @FindBy(id = "RegisterNamesfirst_name")
    public WebElement firstNameInput;

    @FindBy(id = "RegisterNameslast_name")
    public WebElement lastNameInput;

    @FindBy(id = "RegisterPasswordpassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//p[@class='RegistrationConfirmationToast__message']")
    public WebElement registerConfirmationMessage;

    @FindBy(xpath = "//a[@href='/account']")
    public WebElement myInfoMenu;



    // random alphanumeric string
    public static String generateRandomString(int length) {
        Faker faker = new Faker();
        return faker.regexify("[a-zA-Z0-9]{" + length + "}");
    }

    // Method to format the email address
    public static String generateFormattedEmail(String email) {
        String randomString = generateRandomString(6);
        return email.replaceFirst("@", "+qainterview-" + randomString + "@");
    }

    public void fillAndSubmitRegistrationForm() {
        String firstName = ConfigurationReader.getProperty("firstName");
        String lastName = ConfigurationReader.getProperty("lastName");

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        submitButton.click();
    }


}
