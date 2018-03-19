package com.telesens.test.appmanager.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="email")
    private WebElement loginField;
    @FindBy(id="passwd")
    private WebElement passwField;
    @FindBy(id="SubmitLogin")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
        return this;
    }

    // TODO use type
    public LoginPage inputPassword(String passw) {
        passwField.clear();
        passwField.sendKeys(passw);
        return this;
    }

    public AccountPage submitLogin() {
        signInButton.click();
        return new AccountPage(driver);
    }
}
