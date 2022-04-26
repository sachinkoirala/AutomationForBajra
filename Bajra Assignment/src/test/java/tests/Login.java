package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import tests.utils.ExtentTestManager;

import java.io.IOException;

import static tests.Helper.*;

public class Login extends BaseTest{

    Logger log = Logger.getLogger(Login.class);

    public void normalLogin() throws InterruptedException, IOException
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, "Invoking URL", "");
        log.info("*****INVOKING URL*******");

        String url = "https://www.bajratechnologies.com/";
        System.out.println(url);
        invokeBrowser(url);



    }

    private void invokeBrowser(String url) {
        getDriver().get(url);
    }


}
