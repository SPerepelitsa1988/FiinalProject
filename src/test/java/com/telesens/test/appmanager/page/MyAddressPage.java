package com.telesens.test.appmanager.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAddressPage extends BasePage {

    @FindBy(css="#center_column > div.clearfix.main-page-indent > a")
    private WebElement addNewAddressButton;

    public MyAddressPage(WebDriver driver) {
        super(driver);
    }

    public FormAddressPage clickByAddNewAddress() {
        addNewAddressButton.click();
        return new FormAddressPage(driver);
    }
}
