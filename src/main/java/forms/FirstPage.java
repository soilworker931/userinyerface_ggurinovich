package forms;

import configurations.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstPage {

    private WebDriver driver;
    private String requiredText = "Hi and welcome to User Inyerface";
    private Environment environment = new Environment();

    public FirstPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(environment.getCurrentEnvironment());
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