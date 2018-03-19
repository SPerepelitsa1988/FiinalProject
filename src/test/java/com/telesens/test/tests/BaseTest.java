package com.telesens.test.tests;

import com.telesens.test.appmanager.ApplicationManager;
import org.testng.annotations.*;

public class BaseTest {
    protected final ApplicationManager app = new ApplicationManager();

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) throws Exception {
        app.init(browser);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        app.stop();
    }
}
