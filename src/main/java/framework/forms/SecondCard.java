package framework.forms;

import framework.base.BaseForm;
import framework.browser.Browser;
import framework.elements.Button;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SecondCard extends BaseForm {
    static final Logger log = Logger.getLogger(FirstCard.class);
    private final int requiredHobbiesQuantity = 3;
    private final Button browseAvatarButton = new Button(By.className("avatar-and-interests__upload-button"), "upload file");

    public SecondCard() {
        super(By.xpath("//div[@class='page-indicator' and contains(text(),'2 / 4')]"), "second card");
    }

    public void browseAvatarButton() {
        log.info("upload avatar");
        browseAvatarButton.click();
    }

    public void chooseDifferentHobbies() {
        log.info("choose hobbies");
        List<WebElement> hobbiesList = Browser.getBrowser().findElements(By.tagName("label"));
        int i = 0;
        for (WebElement hobby : hobbiesList) {
            i++;
            if (hobby.getAttribute("for").equals("interest_unselectall")) {
                break;
            } else if (i > hobbiesList.size()) {
                break;
            }
        }
        Browser.getBrowser().findElement(By.xpath(String.format("(//span[@class='checkbox__box'])[%s]", i))).click();
        hobbiesList.removeIf(x -> x.getAttribute("for").equals("interest_selectall") || x.getAttribute("for").equals("interest_unselectall"));
        for (int j = 0; j < requiredHobbiesQuantity; j++) {
            int randomHobby = (int) (Math.random() * hobbiesList.size());
            WebElement generatedHobby = hobbiesList.get(randomHobby);
            String xPathForHobbies = String.format("//label[@for='%s']/span", generatedHobby.getAttribute("for")) ;
            hobbiesList.remove(generatedHobby);
            Browser.getBrowser().findElement(By.xpath(xPathForHobbies)).click();
        }
    }
}