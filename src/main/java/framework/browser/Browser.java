package framework.browser;

import org.openqa.selenium.WebDriver;
import utils.PropertiesRead;

public abstract class Browser {
    private static WebDriver driver;
    private static final String browserName = PropertiesRead.readFromFrameworkConfig("browser");

    public static WebDriver getBrowser() {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(browserName);
        }
        return driver;
    }

    public static void goToUrl(String url) {
        getBrowser().get(url);
    }

    public static void maximize() {
        getBrowser().manage().window().maximize();
    }

    public static void close() {
        getBrowser().close();
    }
}
