package framework.forms;

import framework.base.BaseForm;
import framework.browser.Browser;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FirstCard extends BaseForm {
    static final Logger log = Logger.getLogger(FirstCard.class);
    private TextBox passwordTbx = new TextBox(By.xpath("//input[@placeholder='Choose Password']"), "password");
    private TextBox nickNameTbx = new TextBox(By.xpath("//input[@placeholder='Your email']"), "nickname");
    private TextBox domainTbx = new TextBox(By.xpath("//input[@placeholder='Domain']"), "domain");
    private Button dropDownListOrgCodes = new Button(By.className("dropdown__opener"),"dropdown list");
    private Button orgCodes = new Button(By.className("dropdown__list-item"),"dropdown list");
    private Button acceptTermsButton = new Button(By.className("checkbox__box"), "accept terms button");
    private Button nextButton = new Button(By.className("button--secondary"), "move to second card");
    private Button helpButton = new Button(By.className("discrete"), "help button");
    private Button declineCookies = new Button(By.xpath("//button[@class='button button--solid button--transparent']"), "decline cookies");
    private Label cookiesPopup = new Label(By.className("cookies"), "cookies window");
    private Label timer = new Label(By.xpath("//div[@class = 'timer timer--white timer--center']"), "timer");

    public FirstCard() {
        super(By.xpath("//div[@class='page-indicator' and contains(text(),'1 / 4')]"), "first card");
    }

    public void insertPassword(String password) {
        log.info("input password" + password);
        passwordTbx.clearAndType(password);
    }

    public void insertNickName(String nickName) {
        log.info("input nickname" + nickName);
        nickNameTbx.clearAndType(nickName);
    }

    public void insertDomain(String domain) {
        log.info("input domain" + domain);
        domainTbx.clearAndType(domain);
    }

    public void insertOrgCode() {
        log.info("input orgcode");
        dropDownListOrgCodes.click();
        List<WebElement> orgCodeLists = orgCodes.getElements();
        int randomOrgCode = (int) (Math.random() * orgCodeLists.size());
        Browser.getBrowser().findElement(By.xpath(String.format("(//div[@class='dropdown__list-item'])[%d]",randomOrgCode))).click();
    }

    public void acceptTermsButtonClick() {
        log.info("accept terms");
        acceptTermsButton.click();
    }

    public void moveToTheSecondCard() {
        log.info("move to the second card");
        nextButton.click();
    }

    public void hideHelpButton() {
        log.info("hide help button");
        helpButton.click();
    }

    public boolean helpButtonIsHidden() {
        log.info("help button is hidden check");
        return helpButton.webElementIsDisplayed();
    }

    public void closeCookies() {
        log.info("close cookies");
        Browser.setImplicitlyWait();
        declineCookies.click();
    }

    public boolean isCookiesClosed() {
        log.info("cookies closed check");
        return cookiesPopup.isDisplayed();
    }

    public boolean timerShowsCorrectValue(String requiredTimerValue) {
        log.info("timer check");
        return timer.getElement().getText().equals(requiredTimerValue);
    }
}