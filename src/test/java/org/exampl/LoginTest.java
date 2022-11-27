package org.exampl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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
        //нажимаем Да в регионе
        loginPage.acceptRegion();
        //выбираем радиобаттон
        loginPage.chooseCountOfBox();
        //проверка на быюор радиобаттона
        assertTrue(loginPage.isClickRadioButton());
        //вводим количество коробок
        loginPage.inputQuantity();
        //вводим ФИО
        loginPage.inputName();
        //вводим почту
        loginPage.inputEmail();
        //вводим телефон
        loginPage.inputPhone();
        //вводим текст
        loginPage.inputWriteText();
        //выбираем чекбокс
        loginPage.clickCheckBox();
        //загружаем файл
        loginPage.uploadFile();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertTrue(loginPage.isElementPresent(By.xpath("//*[@id=\"form\"]/div/div[5]/div[1]/input[1]")));
        loginPage.sendForm();
       assertTrue(loginPage.isElementPresent(By.xpath("//*[@id=\"globalMessages\"]/div/div[1]")));

    }
  /* @AfterAll
 public static void shotDown(){
      driver.close();
  }*/
}