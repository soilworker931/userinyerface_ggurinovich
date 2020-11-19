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
import utils.RobotUtils;
import utils.StringUtils;

import java.io.File;

public class UserInyerface {
    private StringUtils utility = new StringUtils();
    private final String nicknameAndPassword = utility.textGeneration(15);
    private final String domainName = "mail";
    private static final String PAGE = PropertiesRead.readFromFrameworkConfig("page");
    private static File file = new File(PropertiesRead.readFromDataConfig("file"));

    @BeforeMethod
    public void start() {
        Browser.getBrowser();
        Browser.goToUrl(PAGE);
        Browser.maximize();
    }

    @Test
    public void checkingTwoFirstCards() {
        FirstPage firstPage = new FirstPage();
        Assert.assertTrue(firstPage.pageIsDisplayed(), "incorrect page was displayed");
        firstPage.clickHereButton();
        FirstCard firstCard = new FirstCard();
        Assert.assertTrue(firstCard.pageIsDisplayed(), "incorrect page was opened");
        firstCard.insertPassword(nicknameAndPassword);
        firstCard.insertNickName(nicknameAndPassword);
        firstCard.insertDomain(domainName);
        firstCard.insertOrgCode();
        firstCard.acceptTermsButtonClick();
        firstCard.moveToTheSecondCard();
        SecondCard secondCard = new SecondCard();
        Assert.assertTrue(secondCard.pageIsDisplayed());
        secondCard.chooseDifferentHobbies();
        secondCard.browseAvatarButton();
        RobotUtils.uploadFile(file);
    }

    @Test
    public void checkHelpScreenIsHidden() {
        FirstPage firstPage = new FirstPage();
        Assert.assertTrue(firstPage.pageIsDisplayed(), "incorrect page was displayed");
        firstPage.clickHereButton();
        FirstCard firstCard = new FirstCard();
        firstCard.hideHelpButton();
        Assert.assertFalse(firstCard.helpButtonIsHidden());
    }

    @Test
    public void CheckCookiesClosed() {
        FirstPage firstPage = new FirstPage();
        Assert.assertTrue(firstPage.pageIsDisplayed(), "incorrect page was displayed");
        firstPage.clickHereButton();
        FirstCard firstCard = new FirstCard();
        firstCard.closeCookies();
        Assert.assertFalse(firstCard.isCookiesClosed());
    }

    @Test
    public void CheckDefaultTimerValue() {
        FirstPage firstPage = new FirstPage();
        Assert.assertTrue(firstPage.pageIsDisplayed(), "incorrect page was displayed");
        firstPage.clickHereButton();
        FirstCard firstCard = new FirstCard();
        Assert.assertTrue(firstCard.timerShowsCorrectValue("00:00:00"), "incorrect timer starting value is displayed");
    }

    @AfterMethod
    public void close() {
        Browser.close();
    }
}
