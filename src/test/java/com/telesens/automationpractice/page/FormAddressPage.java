package com.telesens.automationpractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FormAddressPage extends BasePage {

    @FindBy(id="firstname")
    private WebElement firstNameInput;

    @FindBy(id="lastname")
    private WebElement lastNameInput;

    @FindBy(id="address1")
    private WebElement addressInput;

    @FindBy(id="city")
    private WebElement cityInput;

    @FindBy(id="id_state")
    private WebElement stateSelect;

    @FindBy(id="postcode")
    private WebElement zipCodeInput;

    @FindBy(id="id_country")
    private WebElement countrySelect;

    @FindBy(id="phone")
    private WebElement homePhoneInput;

    @FindBy(id="phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id="submitAddress")
    private WebElement saveButton;

    @FindBy(id="alias")
    private WebElement addressAlias;

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

    public FormAddressPage inputAddress(String address) {
        type(addressInput, address);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputCity(String city) {
        type(cityInput, city);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputState(String state) {
        selectByText(stateSelect, state);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputZipCode(String zipCode) {
        type(zipCodeInput, zipCode);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputCountry(String country) {
        selectByText(countrySelect, country);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputHomePhone(String homePhone) {
        type(homePhoneInput, homePhone);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputMobilePhone(String mobilePhone) {
        type(mobilePhoneInput, mobilePhone);
        return new FormAddressPage(driver);
    }

    public FormAddressPage inputAddressAlias(String alias) {
        type(addressAlias, alias);
        return new FormAddressPage(driver);
    }

    public MyAddressPage clickSaveButton() {
        click(saveButton);
        return new MyAddressPage(driver);
    }

//    public int getAddressCount() {
//        return addresses.size();
//    }
}
