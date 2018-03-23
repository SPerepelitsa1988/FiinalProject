package com.telesens.automationpractice.tests;

import com.telesens.automationpractice.appmanager.model.AddressData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class AddressTest extends BaseTest {
    private static Logger LOG = LogManager.getLogger(AddressTest.class.getName());

    @BeforeMethod
    public void preparePreconditions() {
        app.getSessionHelper().login();
        app.getAddressHelper().goToMyAddressesPage();
    }

    @Test(dataProvider = "creationAddress")
    public void testAddressCreation(AddressData address) {
//        int before = app.getAddressHelper().getCountAddresses();
        if (app.getAddressHelper().isPresentAddressAlias(address.getAddressAlias())) {
            app.getAddressHelper().removeAddressByAlias(address.getAddressAlias());
        }
        List<AddressData> beforeListAddr = app.getAddressHelper().getAddresses();

        app.getAddressHelper().initCreationAddress();
        app.getAddressHelper().fillAddressForm(address);
        app.getAddressHelper().submitAddress();

        // verify
//        int after = app.getAddressHelper().getCountAddresses();
        List<AddressData> afterListAddr = app.getAddressHelper().getAddresses();
        Assert.assertEquals(afterListAddr.size(), beforeListAddr.size()+1);
        beforeListAddr.add(address.withAddressAlias(address.getAddressAlias().toUpperCase()));
        Assert.assertEquals(beforeListAddr, afterListAddr);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

