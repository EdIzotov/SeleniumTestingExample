package org.example.pages;

import org.example.config.Log;
import org.example.config.SeleniumDriver;
import org.example.pages.models.Credentials;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private final WebDriver driver = SeleniumDriver.getDriver();
    @FindBy(name = "username")
    private WebElement usernameField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(name = "register")
    private WebElement registerButton;
    public RegisterPage() {
        PageFactory.initElements(this.driver, this);
    }
    public void registerUser(Credentials credentials) {
        this.inputUsername(credentials.getUsername());
        this.inputPassword(credentials.getPassword());
        this.clickRegister();
    }
    private void inputUsername(String username) {
        try {
            Log.getLogger().info("Check if USERNAME is visible");
            usernameField.isDisplayed();
            Log.getLogger().info("Input USERNAME");
            usernameField.sendKeys(username);
        } catch (NoSuchElementException e) {
            Log.getLogger().error(e.toString());
            throw e;
        }
    }
    private void inputPassword(String password) {
        try {
            Log.getLogger().info("Check if PASSWORD is visible");
            passwordField.isDisplayed();
            Log.getLogger().info("Input PASSWORD");
            passwordField.sendKeys(password);
        } catch (NoSuchElementException e) {
            Log.getLogger().error(e.toString());
            throw e;
        }
    }
    private void clickRegister() {
        try {
            Log.getLogger().info("Check if REGISTER BUTTON is visible");
            registerButton.isDisplayed();
            Log.getLogger().info("Click REGISTER BUTTON");
            registerButton.click();
        } catch (NoSuchElementException e) {
            Log.getLogger().error(e.toString());
            throw e;
        }
    }
}
