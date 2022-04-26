package tests.pageNavigationtest;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageNavigation.navigationtoPage;
import tests.Login;
import tests.utils.ExtentTestManager;
import java.io.IOException;
import static tests.Helper.getDriver;
import static tests.Helper.takescreenshot;


public class pageNavigationtest extends Login {

    Logger log = Logger.getLogger("browser navigation test");

    WebDriver driver;

    @Test(description = "test to navigate all page and validate",priority = 1)
    public void Test_to_navigate_and_validate_allpages() throws IOException, InterruptedException {
            Login login = new Login();
            login.normalLogin();

            String aboutusURL = "https://www.bajratechnologies.com/aboutus";
            String workURL ="https://www.bajratechnologies.com/portfolios/";
            String carrerursURL="https://www.bajratechnologies.com/jobs";
            String contactusURL="https://www.bajratechnologies.com/contactus";



         navigationtoPage nav = new navigationtoPage(getDriver());

        ExtentTestManager.getTest().log(LogStatus.INFO, "Navigating to about US page", "");
        log.info("Navigating to about US page");
        nav.navigateToAboutUS();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Validating URl of about us page");
        log.info("Validating URl of about us page");
        String URLaboutUS = nav.getURL();

        if (URLaboutUS.contains(aboutusURL))
        {
            ExtentTestManager.getTest().log(LogStatus.PASS, " Navigation to about us page Validated Successfully",ExtentTestManager.getTest().addBase64ScreenShot(takescreenshot()));
            log.info("URl of about us page Validated Successfully");
        }
        else
        {
            ExtentTestManager.getTest().log(LogStatus.FAIL, " URl of about us page didn't match",ExtentTestManager.getTest().addBase64ScreenShot(takescreenshot()));
            log.info("URl of about us page didn't match");
        }

        ExtentTestManager.getTest().log(LogStatus.INFO, "Navigating to work page", "");
        log.info("Navigating to work page");
        nav.navigateToWork();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Validating URl of work page");
        log.info("Validating URl of work page");
        String URLwork = nav.getURL();


        if (URLwork.contains(workURL))
        {
            ExtentTestManager.getTest().log(LogStatus.PASS, " URl of work page Validated Successfully",ExtentTestManager.getTest().addBase64ScreenShot(takescreenshot()));
            log.info("URl of work page Validated Successfully");
        }
        else
        {
            ExtentTestManager.getTest().log(LogStatus.FAIL, " Navigation to work page didn't match",ExtentTestManager.getTest().addBase64ScreenShot(takescreenshot()));
            log.info("Navigation of work page didn't match");
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "Navigating to Carrer page", "");
        log.info("Navigating to Carrer page");
        nav.navigateToCarrer();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Validating URl of Carrer page",ExtentTestManager.getTest().addBase64ScreenShot(takescreenshot()));
        log.info("Validating URl of Carrer page");
        String URLcarrer = nav.getURL();

        if (URLcarrer.contains(carrerursURL))
        {
            ExtentTestManager.getTest().log(LogStatus.PASS, " Navigation of Carrer page Validated Successfully",ExtentTestManager.getTest().addBase64ScreenShot(takescreenshot()));
            log.info("Navigation of Carrer page Validated Successfully");
        }
        else
        {
            ExtentTestManager.getTest().log(LogStatus.FAIL, " URl of Carrer page didn't match",ExtentTestManager.getTest().addBase64ScreenShot(takescreenshot()));
            log.info("URl of Carrer page didn't match");
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "Navigating to contact page", "");
        log.info("Navigating to contact US page");
        nav.navigateToContactus();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Validating URl of about us page");
        log.info("Validating URl of about us page");
        String URLcontactUS = nav.getURL();

        if (URLcontactUS.contains(contactusURL))
        {
            ExtentTestManager.getTest().log(LogStatus.PASS, " Navigation of contact us page Validated Successfully",ExtentTestManager.getTest().addBase64ScreenShot(takescreenshot()));
            log.info("Navigation of contact us page Validated Successfully");
        }
        else
        {
            ExtentTestManager.getTest().log(LogStatus.FAIL, " URl of contact us page didn't match",ExtentTestManager.getTest().addBase64ScreenShot(takescreenshot()));
            log.info("URl of contact us page didn't match");
        }
    }

}
