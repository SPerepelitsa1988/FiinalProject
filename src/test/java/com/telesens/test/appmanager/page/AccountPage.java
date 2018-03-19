package com.telesens.test.appmanager.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(linkText = "Sign out")
    private WebElement signOutLink;

    @FindBy(css="#header > div.nav > div > div > nav > div:nth-child(1) > a")
    private WebElement accountLink;

    @FindBy(css="#center_column > div > div:nth-child(1) > ul > li:nth-child(3) > a")
    private WebElement myAddressButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getSignOutText() {
        return signOutLink.getText();
    }

    public AccountPage clickByAccountLink() {
        accountLink.click();
        return new AccountPage(driver);
    }

    public MyAddressPage clickByMyAddress() {
        myAddressButton.click();
        return new MyAddressPage(driver);
    }
}
