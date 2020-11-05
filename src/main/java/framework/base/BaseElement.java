package framework.base;

import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public abstract class BaseElement {

    protected By elementLocator;
    protected String elementName;
    private final int timeout = 10;

    public BaseElement(By locator, String name) {
        this.elementLocator = locator;
        this.elementName = name;
    }

    private WebElement getElement() {
        return Browser.getBrowser().findElement(elementLocator);
    }

    public void click() {
        getElement().click();
    }

    public boolean isDisplayed(String requiredText) {
        return getElement().getText().contains(requiredText);
    }


    public boolean webElementisDisplayed() {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getElement().isDisplayed();
    }
}
