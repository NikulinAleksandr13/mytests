package ChoosingRegion;

import org.exampl.ConfProperties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegionTest {
    public static MainPage mainPage;
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", org.exampl.ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpages"));
    }
    @Test
    public void regiontest (){
        mainPage.choosingRegion();
        mainPage.isElementPresents(By.xpath("/html/body/div[3]/div[1]/div[2]/div/noindex/div/div[7]/div[1]/span"));
    }

}
