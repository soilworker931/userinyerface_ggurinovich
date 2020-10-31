package forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class SecondCard {
    private WebDriver driver;
    private String requiredPage = "2 / 4";
    private int hobbiesQuantity = 3;

    public SecondCard(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpened() {
        if (driver.findElement(By.className("page-indicator")).getText().equals(requiredPage)) {
            return true;
        } else return false;
    }

    public void chooseDifferentHobbies() {
        List<WebElement> hobbiesList = driver.findElements(By.tagName("label"));
        int i = 0;
        for (WebElement hobby : hobbiesList) {
            i++;
            if (hobby.getAttribute("for").equals("interest_unselectall")) {
                break;
            } else if (i > hobbiesList.size()) {
                break;
            }
        }
        driver.findElement(By.xpath("(//span[@class='checkbox__box'])[" + i + "]")).click();
        hobbiesList.removeIf(x -> x.getAttribute("for").equals("interest_selectall") || x.getAttribute("for").equals("interest_unselectall"));
        for (int j = 0; j < hobbiesQuantity; j++) {
            int randomHobby = (int) (Math.random() * hobbiesList.size());
            WebElement generatedHobby = hobbiesList.get(randomHobby);
            String xPathForHobbies = "//label[@for='" + generatedHobby.getAttribute("for") + "']/span";
            hobbiesList.remove(generatedHobby);
            driver.findElement(By.xpath(xPathForHobbies)).click();
        }
    }

    public void fileUpload() {
        driver.findElement(By.xpath("//a[@class='avatar-and-interests__upload-button']")).click();
        Utility.uploadFile();
    }
}
