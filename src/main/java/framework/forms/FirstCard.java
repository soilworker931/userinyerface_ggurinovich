package framework.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utility;

import java.util.concurrent.TimeUnit;

public class FirstCard {
    private WebDriver driver;
    private Utility utility = new Utility();
    private int timeout = 5;
    private String requiredPage = "1 / 4";

    public FirstCard(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpened() {
        if (driver.findElement(By.className("page-indicator")).getText().equals(requiredPage)){
        return (true);
        } else
            return false;
    }

    public void insertPassword() {
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Choose Password']"));
        passwordField.clear();
        String generatedPassword = utility.textGeneration(15);
        passwordField.sendKeys(generatedPassword);
    }

    public void insertEmail() {
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Your email']"));
        email.clear();
        email.sendKeys(utility.textGeneration(15));
    }

    public void insertDomain() {
        WebElement domain = driver.findElement(By.xpath("//input[@placeholder='Domain']"));
        domain.clear();
        domain.sendKeys("mail");
    }

    public void insertOrgCode() {
        driver.findElement(By.className("dropdown__field")).click();
        driver.findElement(By.xpath("//*[contains(text(), '.org')]")).click();
    }

    public void termsAccept() {
        driver.findElement(By.className("checkbox__box")).click();
    }

    public void moveToTheSecondCard() {
        driver.findElement(By.className("button--secondary")).click();
    }

    public void hideHelp() {
        driver.findElement(By.className("discrete")).click();
    }

    public boolean checkHelpIsHidden() {
        if (driver.getPageSource().contains("help-form is-hidden")) {
            return true;
        } else return false;
    }

    public void closeCookies() {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@class='button button--solid button--transparent']")).click();
    }

    public boolean isCookiesClosed() {
        if (driver.getPageSource().contains("cookies")) {
            return true;
        } else return false;
    }

    public boolean timerCheck(String requiredTimerValue) {
       if (driver.findElement(By.xpath("//div[@class = 'timer timer--white timer--center']")).getText().contains(requiredTimerValue)) {
           return true;
       } else return false;
    }
}