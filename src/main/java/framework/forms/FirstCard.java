package framework.forms;

import framework.base.BaseForm;
import framework.elements.TextBox;
import org.openqa.selenium.By;


public class FirstCard extends BaseForm {

    private TextBox passwordTbx = new TextBox(By.xpath("//input[@placeholder='Choose Password']"), "Password");

    public FirstCard(By locator, String name) {
        super(locator, name);
    }

    public void insertPassword(String password) {
        passwordTbx.clearAndType(password);
    }

}