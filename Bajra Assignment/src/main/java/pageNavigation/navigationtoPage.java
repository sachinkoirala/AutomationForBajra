package pageNavigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class navigationtoPage {
    WebDriver driver;

    public navigationtoPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//div[@id='top_menu_collapse']//span[contains(text(),'About Us')]")
    WebElement aboutUs;

    @FindBy(xpath="//div[@id='top_menu_collapse']//span[contains(text(),'Work')]")
    WebElement work;

    @FindBy(xpath="//div[@id='top_menu_collapse']//span[contains(text(),'Careers')]")
    WebElement careers;

    @FindBy(xpath="//div[@id='top_menu_collapse']//span[contains(text(),'Contact Us')]")
    WebElement contactUs;

    public String getURL() throws InterruptedException
    {
        Thread.sleep(500);
        String url = driver.getCurrentUrl();
        return url;
    }

    public void navigateToAboutUS() throws InterruptedException
    {
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(aboutUs)) ;
        aboutUs.click();
    }
    public void navigateToCarrer() throws InterruptedException
    {
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(careers)) ;
        careers.click();
    }

    public void navigateToWork() throws InterruptedException
    {
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(work)) ;
        work.click();
    }
    public void navigateToContactus() throws InterruptedException
    {
        WebDriverWait wait =  new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(contactUs)) ;
        contactUs.click();
    }





}
