package framework.forms;

import framework.base.BaseForm;
import framework.elements.TextBox;
import org.openqa.selenium.By;


public class FirstCard extends BaseForm {

    private TextBox passwordTbx = new TextBox(By.xpath("//input[@placeholder='Choose Password']"), "Password");

    public FirstCard() {
        super(By.xpath("//div[@class='page-indicator' and contains(text(),'1 / 4')]"), "Hi and welcome to User Inyerface");
    }

    public void insertPassword(String password) {
        passwordTbx.clearAndType(password);
    }

}