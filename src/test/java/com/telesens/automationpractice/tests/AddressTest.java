package com.telesens.automationpractice.tests;

import com.telesens.automationpractice.appmanager.model.AddressData;
import com.telesens.automationpractice.appmanager.model.Addresses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressTest extends BaseTest {

    @BeforeMethod
    public void preparePreconditions() {
        app.session().login();
        app.address().goToMyAddressesPage();
    }

    @Test(dataProvider = "creationAddress")
    public void testAddressCreation(AddressData address) {
        if (app.address().isPresentAlias(address.getAlias())) {
            app.address().remove(address.getAlias());
        }

        Addresses before = app.address().all();
        app.address().create(address);
        Set<AddressData> after = app.address().all();

        assertThat(after.size(), equalTo(before.size()+1));
        assertThat(after, equalTo(before.withAdded(address.withAddressAlias(address.getAlias().toUpperCase()))));
    }

    @DataProvider(name="creationAddress")
    private Object[] getCreationAddressData() {
        return new Object[]{
                new AddressData()
                        .withFirstName("Kolya")
                        .withLastName("Ivanov")
                        .withAddress("Petrovskogo st. 35")
                        .withCity("Kharkov")
                        .withState("Alaska")
                        .withZipCode("61033")
                        .withCountry("United States")
                        .withHomePhone("+3809353613437")
                        .withMobilePhone("093234567")
                        .withAddressAlias("addressRef")
        };
    }
}

