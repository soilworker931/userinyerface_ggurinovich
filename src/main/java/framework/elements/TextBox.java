package framework.elements;

import framework.base.BaseElement;
import framework.browser.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {
    static final Logger log = Logger.getLogger(TextBox.class);
    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void clearAndType(String value) {
        log.info("TextBox is cleared and input" + value);
        Browser.getBrowser().findElement(elementLocator).clear();
        Browser.getBrowser().findElement(elementLocator).sendKeys(value);
    }
}