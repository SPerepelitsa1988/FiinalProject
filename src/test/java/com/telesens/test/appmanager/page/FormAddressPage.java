package com.telesens.test.appmanager.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAddressPage extends BasePage {

    @FindBy(id="firstname")
    private WebElement firstNameInput;

    @FindBy(id="lastname")
    private WebElement lastNameInput;

    public FormAddressPage(WebDriver driver) {
        super(driver);
    }

    public FormAddressPage inputFirstName(String firstName) {
        type(firstNameInput, firstName);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputsLastName(String lastName) {
        type(lastNameInput, lastName);
        return new FormAddressPage(driver);
    }
}
