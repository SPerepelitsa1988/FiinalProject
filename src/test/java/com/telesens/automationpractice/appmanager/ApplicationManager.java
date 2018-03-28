package com.telesens.automationpractice.appmanager;

import com.telesens.automationpractice.appmanager.helper.AddressHelper;
import com.telesens.automationpractice.appmanager.helper.SessionHelper;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.*;

public class ApplicationManager {

    private AddressHelper addressHelper;
    private SessionHelper sessionHelper;
    protected WebDriver driver;
    protected String baseUrl;

    private final Properties properties;

    public ApplicationManager()  {
        this.properties=new Properties();
        try {
            String propertyFile = System.getProperty("configFile", "src/main/resources/test.properties");
            properties.load(new FileReader(new File(propertyFile)));
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

    public void init(String browser) {

        if (browser.equals(CHROME)) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
            driver = new ChromeDriver();
        }
        else if (browser.equals(FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("firefox.driver"));
            driver = new FirefoxDriver();
        }
        else if(browser.equals(IE)) {
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, System.getProperty("url"));
            caps.setCapability("ignoreZoomSetting", true);
            caps.setCapability("nativeEvents",false);
            driver = new InternetExplorerDriver(caps);
        }
        else if (browser.equals(EDGE)) {
            System.setProperty("webdriver.edge.driver", properties.getProperty("edge.driver"));
            driver = new EdgeDriver();
        }

        baseUrl = properties.getProperty("url");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl + "/index.php");
        addressHelper = new AddressHelper(driver);
        sessionHelper = new SessionHelper(driver);
        session().login(properties.getProperty("login"), properties.getProperty("password"));
    }


    public void stop()  {
        driver.quit();
    }

}
