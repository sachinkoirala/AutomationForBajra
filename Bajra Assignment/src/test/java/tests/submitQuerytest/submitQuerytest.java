package tests.submitQuerytest;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageNavigation.navigationtoPage;
import submitQuery.submitQuery;
import tests.Login;
import tests.utils.ExtentTestManager;

import java.io.IOException;

import static tests.Helper.getDriver;

public class submitQuerytest {

    Logger log = Logger.getLogger("Query submission test");

    WebDriver driver;

    @Test(description = "test to Submit Contact us Query",priority = 2)
    public void Test_to_submit_contactus_query() throws IOException, InterruptedException {
        Login login = new Login();
        login.normalLogin();
        navigationtoPage nav = new navigationtoPage(getDriver());
        submitQuery sq = new submitQuery(getDriver());

        String name = "testUser";
        String number = "9876543210";
        String email ="test@gmail.com";
        String subject = "QA assignment submission";
        String details = "QA assignment have been submitted";


        ExtentTestManager.getTest().log(LogStatus.INFO, "Navigating to Contact US page", "");
        log.info("Navigating to Contact  US page");
        nav.navigateToContactus();


        ExtentTestManager.getTest().log(LogStatus.INFO, "Filling data in the input field", "");
        log.info("Filling data in the input field");

        ExtentTestManager.getTest().log(LogStatus.INFO, "Entering Name", "");
        log.info("Entering Name");
        sq.setYourName(name);

        ExtentTestManager.getTest().log(LogStatus.INFO, "Entering Number", "");
        log.info("Entering Number");
        sq.setPhoneNumber(number);

        ExtentTestManager.getTest().log(LogStatus.INFO, "Entering email", "");
        log.info("Entering email");
        sq.setEmailFrom(email);

        ExtentTestManager.getTest().log(LogStatus.INFO, "Entering subject", "");
        log.info("Entering subject");
        sq.setSubject(subject);

        ExtentTestManager.getTest().log(LogStatus.INFO, "Entering question details", "");
        log.info("Entering question details");
        sq.setYourQuestion(details);

        ExtentTestManager.getTest().log(LogStatus.INFO, "submiting details", "");
        log.info("submiting details");
        sq.clicksubmitButton();



    }}
