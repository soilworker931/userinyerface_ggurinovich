package test;

import framework.base.BaseElement;
import framework.base.BaseForm;
import framework.browser.Browser;
import framework.elements.Button;
import framework.elements.TextBox;
import framework.forms.FirstCard;
import framework.forms.FirstPage;
import framework.forms.SecondCard;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertiesRead;
import utils.Utility;

public class UserInyerface {
    private Utility utility = new Utility();
    private static final String PAGE = PropertiesRead.readFromFrameworkConfig("page");
    private final String passwordAndName = utility.textGeneration(15);
    private final BaseElement hereButton = new Button(By.className("start__link"), "clicking HERE button");
    private final TextBox inputPassword = new TextBox(By.xpath("//input[@placeholder='Choose Password']"), "input password");
    private final TextBox inputNickname = new TextBox(By.xpath("//input[@placeholder='Your email']"), "input nickname");
    private final TextBox inputDomain = new TextBox(By.xpath("//input[@placeholder='Domain']"), "input domain");
    private final Button inputOrgCode = new Button(By.className("dropdown__field"), "input domain");
    private final BaseElement termsAccept = new Button(By.className("checkbox__box"), "checkbox clicking");
    private final BaseElement nextButton = new Button(By.className("button--secondary"), "move to the second card");
    private final BaseForm secondCard = new SecondCard(By.className("page-indicator"), "required text is displayed");
    private final Button hobbiesChoose = new Button(By.tagName("label"), "chose 3 different hobbies");
    private final Button uploadRequiredFile = new Button(By.className("avatar-and-interests__upload-button"), "upload file");
    private final BaseElement helpButton = new Button(By.className("discrete"), "clicking hide button to hide popup");
    private final Button cookies = new Button(By.xpath("//button[@class='button button--solid button--transparent']"), "closing cookies");
//    private final BaseForm timer = new FirstCard(By.xpath("//div[@class = 'timer timer--white timer--center']"), "check correct timer starting value");

    @BeforeMethod
    public void start() {
        Browser.getBrowser();
        Browser.goToUrl(PAGE);
        Browser.maximize();
    }

    @Test
    public void checkingTwoFirstCards() {
        FirstPage firstPage = new FirstPage(By.className("start__paragraph"), "required text is displayed");
//        Assert.assertTrue(firstPage.isPageOpened("Hi and welcome to User Inyerface"), "Incorrect page was opened");
        hereButton.click();
        FirstCard firstCard = new FirstCard();
//        Assert.assertTrue(firstCard.isPageOpened("1 / 4"), "incorrect page was opened");
//        firstCard.insertPassword(passwordAndName);
//        inputNickname.insertEmail();
//        inputDomain.insertDomain();
//        inputOrgCode.insertOrgCode(By.className("dropdown__list-item"));
//        termsAccept.click();
//        nextButton.click();
//        Assert.assertTrue(secondCard.isPageOpened("2 / 4"), "incorrect page was opened");
//        hobbiesChoose.chooseDifferentHobbies();
//        uploadRequiredFile.uploadFileForAvatar();
    }

//    @Test
//    public void checkHelpScreenIsHidden() {
//        Assert.assertTrue(firstPage.isPageOpened("Hi and welcome to User Inyerface"), "Incorrect page was opened");
//        hereButton.click();
//        helpButton.click();
//        Assert.assertFalse(helpButton.webElementisDisplayed());
//
//    }
//
//    @Test
//    public void CheckCookiesClosed() {
//        Assert.assertTrue(firstPage.isPageOpened("Hi and welcome to User Inyerface"), "Incorrect page was opened");
//        hereButton.click();
//        cookies.closeCookies();
//        Assert.assertFalse(cookies.isCookiesClosed());
//    }
//
//    @Test
//    public void CheckDefaultTimerValue() {
//        Assert.assertTrue(firstPage.isPageOpened("Hi and welcome to User Inyerface"), "Incorrect page was opened");
//        hereButton.click();
//        Assert.assertTrue(timer.checkText("00:00:00"), "incorrect timer starting value is displayed");
//    }

    @AfterMethod
    public void close() {
        Browser.close();
    }
}
