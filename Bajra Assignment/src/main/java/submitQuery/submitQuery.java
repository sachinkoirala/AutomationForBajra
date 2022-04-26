package submitQuery;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class submitQuery {
    WebDriver driver;

    public submitQuery(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//input[@name='Your Name']")
    WebElement yourName;

    @FindBy(xpath="//input[@name='Phone Number']")
    WebElement phoneNumber;

    @FindBy(xpath="//input[@name='email_from']")
    WebElement emailFrom;

    @FindBy(xpath="//input[@name='subject']")
    WebElement subject;

    @FindBy(xpath="//textarea[@name='Your Question']")
    WebElement yourQuestion;

    @FindBy(xpath="//a[normalize-space()='Submit']")
    WebElement submit;

    public void setYourName(String name) throws InterruptedException
    {
        Thread.sleep(1000);
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(yourName));
        yourName.sendKeys(name);

    }
    public void setPhoneNumber(String num) throws InterruptedException
    {
        Thread.sleep(1000);
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumber));
        phoneNumber.sendKeys(num);

    }  public void setSubject(String sub) throws InterruptedException
    {
        Thread.sleep(1000);
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(subject));
        subject.sendKeys(sub);

    }  public void setEmailFrom(String email) throws InterruptedException
    {
        Thread.sleep(1000);
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(emailFrom));
        emailFrom.sendKeys(email);

    }  public void setYourQuestion(String question) throws InterruptedException
    {
        Thread.sleep(1000);
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(yourQuestion));
        yourQuestion.sendKeys(question);

    }
    public void clicksubmitButton() throws InterruptedException
    {
        Thread.sleep(1000);
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
    }


}
