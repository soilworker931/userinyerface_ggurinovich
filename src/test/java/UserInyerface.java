import forms.FirstCard;
import forms.FirstPage;
import forms.SecondCard;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserInyerface {
    private FirstPage firstPage;
    private FirstCard firstCard;
    private SecondCard secondCard;
    private ChromeDriver driver;

    @BeforeMethod
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        firstPage = new FirstPage(driver);
        firstCard = new FirstCard(driver);
        secondCard = new SecondCard(driver);
    }

    @Test
    public void checkingTwoFirstCards() {
        firstPage.open();
        Assert.assertTrue(firstPage.isPageOpened(), "incorrect page was opened");
        firstPage.pushHereButton();

        Assert.assertTrue(firstCard.isPageOpened(), "incorrect page was opened");
        firstCard.insertPassword();
        firstCard.insertEmail();
        firstCard.insertDomain();
        firstCard.insertOrgCode();
        firstCard.termsAccept();
        firstCard.moveToTheSecondCard();

        Assert.assertTrue(secondCard.isPageOpened(), "incorrect page was opened");
        secondCard.chooseDifferentHobbies();
        secondCard.fileUpload();
    }

    @Test
    public void checkHelpScreenIsHidden() {
        firstPage.open();
        Assert.assertTrue(firstPage.isPageOpened(), "incorrect page was opened");
        firstPage.pushHereButton();

        firstCard.hideHelp();
        firstCard.checkHelpIsHidden();
    }

    @Test
    public void CheckCookiesClosed() {
        firstPage.open();
        Assert.assertTrue(firstPage.isPageOpened(), "incorrect page was opened");
        firstPage.pushHereButton();

        firstCard.closeCookies();
        firstCard.isCookiesClosed();
    }

    @Test
    public void CheckDefaultTimerValue() {
        firstPage.open();
        Assert.assertTrue(firstPage.isPageOpened(), "incorrect page was opened");
        firstPage.pushHereButton();

        firstCard.timerCheck("00:00:00");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
