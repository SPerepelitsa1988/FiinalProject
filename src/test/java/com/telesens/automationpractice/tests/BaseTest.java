package com.telesens.automationpractice.tests;

import com.telesens.automationpractice.appmanager.ApplicationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class BaseTest {
    private static Logger LOGGER = LogManager.getLogger(BaseTest.class.getName());
    protected static final ApplicationManager app = new ApplicationManager("firefox");

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        LOGGER.info("Start test " + m.getName() + " with params " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        LOGGER.info("Stop test " + m.getName());
    }
}
