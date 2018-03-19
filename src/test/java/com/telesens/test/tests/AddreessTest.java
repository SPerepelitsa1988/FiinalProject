package com.telesens.test.tests;

import com.telesens.test.appmanager.model.AddressData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddreessTest extends BaseTest {
    private static Logger LOG = LogManager.getLogger(AddreessTest.class.getName());

//    @Test(enabled=false)
//    public void testDemo() throws Exception {
//        app.driver.get(app.baseUrl + "/index.php");
//        app.driver.findElement(By.linkText("Sign in")).click();
//        LOG.debug("sign in click");
//        app.driver.findElement(By.id("email")).click();
//        app.driver.findElement(By.id("email")).clear();
//        app.driver.findElement(By.id("email")).sendKeys("oleg.kh81@gmail.com");
//        LOG.debug("main input");
//        app.driver.findElement(By.id("passwd")).clear();
//        app.driver.findElement(By.id("passwd")).sendKeys("vlrevlor");
//        LOG.debug("password input");
//        app.driver.findElement(By.id("SubmitLogin")).click();
//        app.driver.findElement(By.xpath("//div[@id='columns']/div[3]")).click();
//        LOG.debug("log in click");
//        try {
//            assertEquals(app.driver.findElement(By.linkText("Sign out")).getText(), "Sign out");
//            LOG.info("Log in  successful");
//        } catch (Error e) {
//            LOG.error(e.getMessage());
//        }
//        app.driver.findElement(By.linkText("Sign out")).click();
//        try {
//            assertEquals(app.driver.findElement(By.linkText("Sign in")).getText(), "Sign in");
//        } catch (Error e) {
//            System.err.println(e.getMessage());
//        }
//    }

    @Test
    public void addNewAddressTest() {
        app.getSessionHelper().login();
        app.getAddressHelper().goToMyAccountPage();
        app.getAddressHelper().goToMyAddressesPage();
        app.getAddressHelper().initCreationAddress();
        app.getAddressHelper().fillAddressForm(new AddressData("Oleg", "Afanas"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

