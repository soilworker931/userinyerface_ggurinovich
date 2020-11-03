package framework.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstPage {

    private WebDriver driver;
    private String requiredText = "Hi and welcome to User Inyerface";

    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpened() {
        if (driver.findElement(By.className("start__paragraph")).getText().contains(requiredText)) {
            return true;
        } else return false;
    }

    public void pushHereButton() {
        driver.findElement(By.className("start__link")).click();
    }
}