package com.telesens.automationpractice.tests;

import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName;
import com.telesens.automationpractice.appmanager.ApplicationManager;
import org.testng.annotations.*;

public class BaseTest {
    protected static final ApplicationManager app = new ApplicationManager("firefox");

//    @Parameters("browser")
    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }
}
