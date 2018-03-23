package com.telesens.automationpractice.appmanager;

import com.telesens.automationpractice.appmanager.helper.AddressHelper;
import com.telesens.automationpractice.appmanager.helper.SessionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private AddressHelper addressHelper;
    private SessionHelper sessionHelper;
    protected WebDriver driver;
    protected String baseUrl;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public AddressHelper getAddressHelper() {
        return addressHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public void init() throws Exception {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "d:/distribs/selenium/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "d:/distribs/selenium/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browser.equals("IE")) {
            File ie = new File("d:/distribs/selenium/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", ie.getAbsolutePath());
            driver = new InternetExplorerDriver();
        }
        else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "d:/distribs/selenium/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }

        baseUrl = "http://automationpractice.com/index.php";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl + "/index.php");
        addressHelper = new AddressHelper(driver);
        sessionHelper = new SessionHelper(driver);
    }


    public void stop() throws Exception {
        driver.quit();
    }

}
