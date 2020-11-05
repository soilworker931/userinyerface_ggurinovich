package framework.elements;

import framework.base.BaseElement;
import framework.browser.Browser;
import org.openqa.selenium.By;
import utils.Utility;

public class TextBox extends BaseElement {

    private Utility utility = new Utility();
    private final int stringLength = 15;
    private final String passwordAndName = utility.textGeneration(stringLength);

    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void insertPassword() {
        Browser.getBrowser().findElement(elementLocator).clear();
        Browser.getBrowser().findElement(elementLocator).sendKeys(passwordAndName);
    }

        public void insertEmail() {
        Browser.getBrowser().findElement(elementLocator).clear();
        Browser.getBrowser().findElement(elementLocator).sendKeys(passwordAndName);
    }

    public void insertDomain() {
        Browser.getBrowser().findElement(elementLocator).clear();
        Browser.getBrowser().findElement(elementLocator).sendKeys("mail");
    }
}