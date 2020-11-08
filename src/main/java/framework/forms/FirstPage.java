package framework.forms;

import framework.base.BaseForm;
import framework.elements.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class FirstPage extends BaseForm {
    static final Logger log = Logger.getLogger(FirstCard.class);

    private Button hereButton = new Button(By.className("start__link"), "clicking HERE button");

    public FirstPage() {
        super(By.className("start__paragraph"), "first page");
    }

    public void clickHereButton() {
        log.info("here button click");
        hereButton.click();
    }
}