package ChoosingRegion;

import org.exampl.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitDriver {
    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        return new ChromeDriver();

    }
}
