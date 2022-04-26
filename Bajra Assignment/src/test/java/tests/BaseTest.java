package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import tests.utils.ExtentTestManager;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogManager;

import static tests.Helper.getDriver;
import static tests.Helper.readConfig;


public class BaseTest {

    static String browser;
    static String confFile;
    static String Hub;


    @BeforeSuite
    @Parameters({"configFile", "HubUrl"})
    public void getConfigFile(String configFile, String HubUrl) {
        confFile = configFile;
        Hub = HubUrl;
    }


    //Before Suite
    @BeforeSuite(alwaysRun = true, dependsOnMethods = "getConfigFile")
    public static void readConfigFile() throws Exception {
        Logger log = Logger.getLogger(BaseTest.class);
        try {
            readConfig(confFile);
            log.info("Config File that is used is :" + confFile);
        } catch (Exception errorReadConfig) {
            // log.info("Cannot Read config File :" + errorReadConfig);
        }
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browserName")
    public void getRemoteUrl(String browserName) {
        Logger log = Logger.getLogger(BaseTest.class);
        try {
            log.info("Browser to be used is : " + browserName);
            browser = "chrome";
        } catch (Exception errorGetRemoteUrl) {
            log.error("Failed to get RemoteUrl : " + errorGetRemoteUrl);
        }
    }

    static WebDriver createInstance() throws IOException {
        Logger log = Logger.getLogger(BaseTest.class);
        WebDriver driver = null;
        try {
            log.info("Creating Instances For the test");
            if (browser.equalsIgnoreCase("chrome")) {
                // Added Dynamic webdriver manager
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.silentOutput", "true");
                java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
                LogManager.getLogManager().reset();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                driver = new ChromeDriver(chromeOptions);
                ExtentTestManager.getTest().setDescription("---start-maximized---");
                driver.manage().window().maximize();


                log.info("Setting screen size completed");
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                return driver;
            }
        } catch (Exception errorCreateInstance) {
            log.error("Cannot create Instance due to :" + errorCreateInstance);
        }
        return driver;
    }


//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        Logger log = Logger.getLogger(BaseTest.class);
//        try {
//            //Thread.sleep(10000);
//            WebDriver driver = Helper.getDriver();
//            if (driver != null) {
//                log.info("--Closing Browser--\n\n");
//                driver.quit();
//            }
//        } catch (TestNGException e) {
//            e.printStackTrace();
//        }
//    }

}

