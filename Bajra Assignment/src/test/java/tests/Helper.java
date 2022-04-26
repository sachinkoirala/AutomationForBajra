package tests;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import java.io.*;
import java.util.*;


public class Helper {
    WebDriver driver;
    static int total, pass, fail, unknown;


    public Helper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static Properties prop;
    public static String dataFolderBasePath = "data/config/";

    static {
        prop = new Properties();
    }

    public static void readConfig(String configFileName) throws IOException {
        try {
            File file = new File(dataFolderBasePath + configFileName);

            if (!file.exists()) {
                configFileName = "default-test-data.xml";
                file = new File(dataFolderBasePath + configFileName);
            }
            FileInputStream fileInput = new FileInputStream(file);
            prop.loadFromXML(fileInput);

            fileInput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Take screenshot for failed test
    public static String takeScreenShot(String imageFileName) throws IOException, InterruptedException {
        TakesScreenshot screenshot = (TakesScreenshot) Helper.getDriver();
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\data\\images\\screenShotImage\\" + imageFileName + ".jpg"));
        String filePath = System.getProperty("user.dir") + "\\data\\images\\screenShotImage\\" + imageFileName + ".jpg";
        return filePath;
    }


    // LocalWebDriverManager
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }


    static void invokeBrowser(String url) {
        getDriver().get(url);
    }

    public static String takescreenshot()
    {
        String Screenshot = "data:image/png;base64," + ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);

        return Screenshot;
    }
}









