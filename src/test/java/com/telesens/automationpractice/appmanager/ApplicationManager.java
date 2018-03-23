package com.telesens.automationpractice.appmanager;

import com.telesens.automationpractice.appmanager.helper.AddressHelper;
import com.telesens.automationpractice.appmanager.helper.SessionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private AddressHelper addressHelper;
    private SessionHelper sessionHelper;
    protected WebDriver driver;
    protected String baseUrl;

    private final String browser;
    private final Properties properties;

    public ApplicationManager(String browser)  {
        this.browser = browser;
        this.properties=new Properties();
        try {
            properties.load(new FileReader(new File("src/main/resources/test.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AddressHelper address() {
        return addressHelper;
    }

    public SessionHelper session() {
        return sessionHelper;
    }

    public void init() throws Exception {

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("firefox.driver"));
            driver = new FirefoxDriver();
        }
        else if(browser.equals("IE")) {
            File ie = new File("d:/distribs/selenium/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", properties.getProperty("ie.driver"));
            driver = new InternetExplorerDriver();
        }
        else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", properties.getProperty("edge.driver"));
            driver = new EdgeDriver();
        }

        baseUrl = properties.getProperty("url");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl + "/index.php");
        addressHelper = new AddressHelper(driver);
        sessionHelper = new SessionHelper(driver);
        session().login(properties.getProperty("login"), properties.getProperty("password"));
    }


    public void stop() throws Exception {
        driver.quit();
    }

}
