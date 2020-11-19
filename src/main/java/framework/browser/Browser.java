package framework.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.PropertiesRead;

import java.util.concurrent.TimeUnit;

public abstract class Browser {
    private static WebDriver driver;
    private static final int TIMEOUT = Integer.parseInt(PropertiesRead.readFromFrameworkConfig("timeout"));
    private static final String browserName = PropertiesRead.readFromFrameworkConfig("browser");
    static final Logger log = Logger.getLogger(Browser.class);

    public static WebDriver getBrowser() {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(browserName);
        }
        return driver;
    }

    public static void goToUrl(String url) {
        log.info("go to" + url);
        getBrowser().get(url);
    }

    public static void maximize() {
        log.info("Full screen mode is on");
        getBrowser().manage().window().maximize();
    }

    public static void close() {
        log.info("Browser closes");
        getBrowser().close();
    }

    public static void setImplicitlyWait() {
        log.info("Timeout is " + TIMEOUT);
        getBrowser().manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }
}
