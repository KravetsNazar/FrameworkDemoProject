package com.Tablet.pages;

import com.Tablet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class AccountPage {

    public AccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='Button Button RegisterModal__ContinueBtn RegisterModal__blackButton']")
    public WebElement gotItButton;

    @FindBy(xpath = "//a[@href='/account']//span[contains(text(),'My Info')]")
    public WebElement myInfoPage;

    @FindBy(xpath = "//textarea[@placeholder='Add a brief bio']")
    public WebElement bioTextField;

    @FindBy(xpath = "//button[@class = 'Button UpdateProfile__saveProfileBtn']")
    public WebElement saveProfileButton;

    @FindBy(xpath = "//button[@class='Accounts__signout#QA']")
    public WebElement signOutButton;

    @FindBy(xpath = "//button[@class='Cropper__updatePhotoBtn']/span[text()='Choose']")
    public WebElement chooseButton;

    @FindBy(xpath = "//button[@class=\"Button Cropper__doneWithCropping\"]")
    public WebElement imDoneButton;

    // Method to upload a file using the Robot class for macOS
    public void uploadFileWithRobot(String filePath) {
        try {
            // Get file path as a string -> copy it to the System memory
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            // Creating instance of Robot class
            Robot robot = new Robot();

            // Delay for window switching and other actions
            robot.delay(1000);

            // Press Command (Cmd) + Tab to switch window focus (macOS)
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_TAB);

            // Delay for window switching
            robot.delay(1000);

            // Press Command (Cmd) + Shift + G to open the GOTO window (macOS)
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_G);

            // Delay for the GOTO window to open
            robot.delay(1000);

            // Paste the file path by pressing Command (Cmd) + V (macOS)
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_V);

            // Delay for the paste to complete
            robot.delay(1000);

            // Press Enter to confirm the file selection
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // Delay for the action to complete
            robot.delay(1000);

            // Press Enter again to confirm the file upload
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // Delay for the action to complete
            robot.delay(1000);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
