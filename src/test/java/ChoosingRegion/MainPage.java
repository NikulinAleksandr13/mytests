package ChoosingRegion;

import org.exampl.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class MainPage extends Step {
    private final WebDriver driver;
    private final Actions actions;
    private final Random random = new Random();

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(Long.parseLong(ConfProperties.getProperty("login.page.time_out"))));

    }

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div/noindex/div/div[7]/div[1]/span")
    private WebElement menuRegion;


    public void clickIsRegion() {
        moveAndClick(actions, menuRegion);
    }


    public void choosingRegion() {
        moveAndClick(actions, menuRegion);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> regionList = driver.findElements(By.className("b-region__list__item"));
        regionList.forEach(r -> System.out.println("тут текст " + r.getAttribute("innerHTML")));
        WebElement randomElement = regionList.get(random.nextInt(regionList.size()));
        System.out.println("тут элемент " + randomElement.getAttribute("innerHTML"));
        moveAndClick(actions, randomElement);
    }

    public boolean isElementPresents(By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
