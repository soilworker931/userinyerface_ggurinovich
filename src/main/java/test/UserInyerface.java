package test;

import framework.browser.Browser;
import framework.forms.FirstCard;
import framework.forms.FirstPage;
import framework.forms.SecondCard;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertiesRead;

public class UserInyerface {
    private FirstPage firstPage = new FirstPage(Browser.getBrowser());
    private FirstCard firstCard = new FirstCard(Browser.getBrowser());
    private SecondCard secondCard = new SecondCard(Browser.getBrowser());
    private static final String page = PropertiesRead.readFromFrameworkConfig("page");

    @BeforeMethod
    public void start() {
        Browser.getBrowser();
        Browser.goToUrl(page);
        Browser.maximize();
    }

    @Test
    public void checkingTwoFirstCards() {
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
        Assert.assertTrue(firstPage.isPageOpened(), "incorrect page was opened");
        firstPage.pushHereButton();
        firstCard.hideHelp();
        firstCard.checkHelpIsHidden();
    }

    @Test
    public void CheckCookiesClosed() {
        Assert.assertTrue(firstPage.isPageOpened(), "incorrect page was opened");
        firstPage.pushHereButton();
        firstCard.closeCookies();
        firstCard.isCookiesClosed();
    }

    @Test
    public void CheckDefaultTimerValue() {
        Assert.assertTrue(firstPage.isPageOpened(), "incorrect page was opened");
        firstPage.pushHereButton();
        firstCard.timerCheck("00:00:00");
    }

    @AfterMethod
    public void close() {
        Browser.close();
    }
}
