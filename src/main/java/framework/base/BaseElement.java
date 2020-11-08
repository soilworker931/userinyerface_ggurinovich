package framework.base;

import framework.browser.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BaseElement {

    protected By elementLocator;
    protected String elementName;
    static final Logger log = Logger.getLogger(BaseElement.class);

    private final int timeout = 10;

    public BaseElement(By locator, String name) {
        this.elementLocator = locator;
        this.elementName = name;
    }

    public WebElement getElement() {
        log.info("get element" + this.elementName);
        return Browser.getBrowser().findElement(elementLocator);
    }

    public void click() {
        log.info(this.elementName + " click");
        getElement().click();
    }

    public List<WebElement> getElements() {
        log.info("get elements" + this.elementName);
        return Browser.getBrowser().findElements(this.elementLocator);
    }


    public boolean isDisplayed() {
        log.info(this.elementName + "check");
        return getElements().size() > 0;
    }


    public boolean webElementisDisplayed() {
        log.info(this.elementName + "check");
        Browser.setImplicitlyWait();
        return getElement().isDisplayed();
    }
}
