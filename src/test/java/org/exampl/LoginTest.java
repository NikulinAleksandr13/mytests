package org.exampl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeAll
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() {
        //вводим количество коробок
        loginPage.acceptRegion();
        loginPage.chooseCountOfBox();
        assertTrue(loginPage.isClickRadioButton());
        loginPage.inputQuantity();
        //нажимаем радиобаттон
        //вводим ФИО
        loginPage.inputName();
        //вводим почту
        loginPage.inputEmail();
        //вводим телефон
        loginPage.inputPhone();
        //вводим ntrcn
        loginPage.inputWriteText();
        loginPage.clickCheckBox();
        loginPage.uploadFile();
    }
//    @AfterAll
//    public static void shotDown(){
//        driver.close();
//    }
}