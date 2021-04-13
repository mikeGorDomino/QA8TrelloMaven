package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPageHelper extends PageBase{

    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement loginIcon;

    @FindBy(id = "user")
    WebElement loginField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = "#error >.error-message")
    WebElement errorMessageNotAttl;

    @FindBy(xpath = "//input[@value = 'Log in with Atlassian']")
    WebElement loginAsAttlButton;

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public LoginPageHelper openLoginPage() {
        loginIcon.click();
        return this;
    }

    public LoginPageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(loginField,10);
        waitUntilElementIsClickable(loginButton,20);
        return this;
    }

    public LoginPageHelper enterLoginPassNotAttl(String login, String password) {
        this.enterLoginNotAttl(login);
        this.enterPasswordNotAttl(password);
        this.clickLoginInButtonNotAttl();
        return this;
    }

    public LoginPageHelper enterLoginNotAttl(String value) {
        // WebElement loginField = driver.findElement(By.id("user"));
        fillField(loginField,value);
        return this;

    }

    public LoginPageHelper enterPasswordNotAttl(String value){
        waitUntilElementIsClickable(passwordField,10);
        // WebElement passwordField = driver.findElement(By.id("password"));
        fillField(passwordField,value);
        //to be sure that loginField and passwordField are already filled in
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;

    }
    // -------- Click login button ------------
    public LoginPageHelper clickLoginInButtonNotAttl() {
        waitUntilElementIsClickable(loginButton, 20);
        loginButton.click();
        return this;
    }

    public String getErrorNotAttlMessage() {
        waitUntilElementIsVisible(errorMessageNotAttl, 20);
        // --------- Print error message ----------
        return errorMessageNotAttl.getText();
    }

    public LoginPageHelper clickLoginAttl() {
        waitUntilElementIsClickable(loginAsAttlButton, 10);
        loginAsAttlButton.click();
        return this;
    }

    public LoginPageHelper enterPasswordAttl(String value) {
        waitUntilElementIsClickable(passwordField,10);
        //WebElement passwordField = driver.findElement(By.id("password"));
        fillField(passwordField,value);
        return this;

    }

    public LoginPageHelper submitAttl() {
        waitUntilElementIsClickable(By.id("login-submit"), 10);
        driver.findElement(By.id("login-submit")).click();
        return this;
    }

    public void enterLoginPasswordAttl(String login, String password) {
        this.enterLoginNotAttl(login);
        this.clickLoginAttl();
        this.enterPasswordAttl(password);
        this.submitAttl();
    }

    public String getErrorAttlMessage() {
        //------Wait the error-message and print it -------
        waitUntilElementIsVisible(By.id("login-error"), 10);
        return driver.findElement(By.id("login-error")).getText();

    }
}