package framework.elements;

import framework.base.BaseElement;
import framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utility;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Button extends BaseElement {

    private final int hobbiesQuantity = 3;
    private int timeout = 5;
    private Utility utility = new Utility();

    public Button(By locator, String name) {
        super(locator, name);
    }

    public void insertOrgCode(By droplist) {
        Browser.getBrowser().findElement(elementLocator).click();
        List<WebElement> orgCodeLists = Browser.getBrowser().findElements(droplist);
        int randomOrgCode = (int) (Math.random() * orgCodeLists.size());
        Browser.getBrowser().findElement(By.xpath("//div[@class='dropdown__list-item']["+ randomOrgCode +"]")).click();
    }

    public void chooseDifferentHobbies() {
        List<WebElement> hobbiesList = Browser.getBrowser().findElements(elementLocator);
        int i = 0;
        for (WebElement hobby : hobbiesList) {
            i++;
            if (hobby.getAttribute("for").equals("interest_unselectall")) {
                break;
            } else if (i > hobbiesList.size()) {
                break;
            }
        }
        Browser.getBrowser().findElement(By.xpath("(//span[@class='checkbox__box'])[" + i + "]")).click();
        hobbiesList.removeIf(x -> x.getAttribute("for").equals("interest_selectall") || x.getAttribute("for").equals("interest_unselectall"));
        for (int j = 0; j < hobbiesQuantity; j++) {
            int randomHobby = (int) (Math.random() * hobbiesList.size());
            WebElement generatedHobby = hobbiesList.get(randomHobby);
            String xPathForHobbies = "//label[@for='" + generatedHobby.getAttribute("for") + "']/span";
            hobbiesList.remove(generatedHobby);
            Browser.getBrowser().findElement(By.xpath(xPathForHobbies)).click();
        }
    }

    public void uploadFileForAvatar() {
        Browser.getBrowser().findElement(elementLocator).click();
        utility.uploadFile();
    }

    public void closeCookies() {
        Browser.getBrowser().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        Browser.getBrowser().findElement(elementLocator).click();
    }

    public boolean isCookiesClosed() {
        if (Browser.getBrowser().getPageSource().contains("cookies")) {
            return true;
        } else return false;
    }
}