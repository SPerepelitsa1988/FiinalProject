package com.telesens.automationpractice.appmanager.helper;

import com.telesens.automationpractice.appmanager.model.AddressData;
import com.telesens.automationpractice.appmanager.page.AccountPage;
import com.telesens.automationpractice.appmanager.page.FormAddressPage;
import com.telesens.automationpractice.appmanager.page.MyAddressPage;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class AddressHelper {

    private WebDriver driver;

    public AddressHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void initCreationAddress() {
        new MyAddressPage(driver)
                .clickByAddNewAddress();
    }

    public void goToMyAddressesPage() {
        new AccountPage(driver)
                .clickByAccountLink()
                .clickByMyAddress();
    }

    public void goToMyAccountPage() {
        new AccountPage(driver)
                .clickByAccountLink();
    }

    public void fillAddressForm(AddressData addressData) {
        new FormAddressPage(driver)
                .inputFirstName(addressData.getFirstName())
                .inputsLastName(addressData.getLastName())
                .inputAddress(addressData.getAddress())
                .inputCity(addressData.getCity())
                .inputState(addressData.getState())
                .inputZipCode(addressData.getZipCode())
                .inputCountry(addressData.getCountry())
                .inputHomePhone(addressData.getHomePhone())
                .inputMobilePhone(addressData.getMobilePhone())
                .inputAddressAlias(addressData.getAddressAlias());

//        Select selectStateEl = new Select(driver.findElement(By.id("id_state")));
//        selectStateEl.selectByValue("4");
    }

    public void submitAddress() {
        new FormAddressPage(driver)
                .clickSaveButton();
    }

    public boolean isPresentAddressAlias(String addressAlias) {
        return new MyAddressPage(driver)
                .getAddressAliasList()
                .contains(addressAlias.toUpperCase());
    }

    // TOdo
    public void removeAddressByAlias(String addressAlias) {
        new MyAddressPage(driver)
                .clickDeleteButton(addressAlias)
                .acceptDeletion();

    }

    // TODO
    public List<AddressData> getAddresses() {
        List<AddressData> addressDataList = new ArrayList<>();

        List<String> firstNames = new MyAddressPage(driver).getFirstNameList();
        List<String> lastNames = new MyAddressPage(driver).getLastNameList();
        List<String> addresses = new MyAddressPage(driver).getAddressList();
        List<String> cities = new MyAddressPage(driver).getCityList();
        List<String> states = new MyAddressPage(driver).getStateList();
        List<String> zipCodes = new MyAddressPage(driver).getZipCodeList();
        List<String> countries = new MyAddressPage(driver).getCountryList();
        List<String> homePhones = new MyAddressPage(driver).getHomePhoneList();
        List<String> mobilePhones = new MyAddressPage(driver).getMobilePhoneList();
        List<String> addressAliases = new MyAddressPage(driver).getAddressAliasList();

        for (int i = 0; i < addressAliases.size(); i++) {
            addressDataList.add(new AddressData()
                    .withFirstName(firstNames.get(i))
                    .withLastName(lastNames.get(i))
                    .withAddress(addresses.get(i))
                    .withCity(cities.get(i).substring(0, cities.get(i).length()-1))
                    .withState(states.get(i))
                    .withZipCode(zipCodes.get(i))
                    .withCountry(countries.get(i))
                    .withHomePhone(homePhones.get(i))
                    .withMobilePhone(mobilePhones.get(i))
                    .withAddressAlias(addressAliases.get(i))
            );
        }

        return addressDataList;
    }
}
