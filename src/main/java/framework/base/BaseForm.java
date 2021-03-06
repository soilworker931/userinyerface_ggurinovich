package framework.base;

import framework.elements.Label;
import org.openqa.selenium.By;

public abstract class BaseForm {
    private final By locator;
    private final String name;

    protected BaseForm(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public boolean pageIsDisplayed() {
        return new Label(locator, name).isDisplayed();
    }

}