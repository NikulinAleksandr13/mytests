package org.exampl;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.NumericHelper;
import utils.StringHelper;

import java.time.Duration;

public class LoginPage extends BaseSteps {
    private final WebDriver driver;
    private final Actions actions;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofMillis(Long.parseLong(ConfProperties.getProperty("login.page.time_out"))));
    }

    @FindBy(xpath = "//*[@id=\"cardboardBoxType1\"]")
    private WebElement boxType1;
    @FindBy(xpath = "//*[@id=\"tippy-2\"]/div[2]/div[3]/a")
    private WebElement acceptRegion;

    @FindBy(xpath = "//*[@id=\"cardboardBoxType2\"]")
    private WebElement boxType2;

    @FindBy(xpath = "//*[@id=\"feedback.komus.quantity\"]")
    private WebElement quantity;

    @FindBy(xpath = "//*[@id=\"feedback.komus.comment\"]")
    private WebElement writeText;

    @FindBy(xpath = "//*[@id=\"feedback.komus.alias\"]")
    private WebElement inputName;

    @FindBy(xpath = "//*[@id=\"feedback.komus.email\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"feedback.komus.phone\"]")
    private WebElement phone;
    @FindBy(xpath = "//*[@id=\"form\"]/div[1]/div[5]/div[1]/div[1]/div/label/span[1]")
    private WebElement checkBox1;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div[5]/div[1]/div[2]/div/label/span[1]")
    private WebElement checkBox2;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div[5]/div[1]/div[3]/div/label/span[1]")
    private WebElement checkBox3;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div[7]/button")
    private WebElement submit;

    @FindBy(xpath = "//*[@id=\"file\"]")
    private WebElement uploadsFile;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div[5]/div[1]/input[2]")
    private WebElement fileName;





    public void inputEmail() {
        inputText(StringHelper.getMail(), email);
    }

    public void inputName() {
        inputText(StringHelper.getRandomRussianString(6) + " " + StringHelper.getRandomRussianString(5), inputName);
    }

    public void inputPhone() {
        inputText(StringHelper.getPhoneNumber(), phone);
    }

    public void inputQuantity() {
        inputText(String.valueOf(NumericHelper.getRandomInt(69)), quantity);
    }

    public void inputWriteText() {
        inputText(StringHelper.getRandomRussianString(20), writeText);
    }

    public void chooseCountOfBox() {
        WebElement[] arrayRadioButton = {boxType1, boxType2};
        WebElement element = chooseRandomElement(arrayRadioButton);
        waitElementShouldBeClick(wait, element);
        moveAndClick(actions, element);
    }

    public boolean isClickRadioButton() {
        return isClicked(boxType1);
    }

    public void clickCheckBox() {
        WebElement[] arrayCheckBox = {checkBox1, checkBox2, checkBox3};
        moveAndClick(actions, chooseRandomElement(arrayCheckBox));
    }

    public void sendForm() {
        clickOnButton(submit);
    }

    public void acceptRegion() {
        waitElementShouldBeClick(wait, acceptRegion);
        clickOnButton(acceptRegion);
    }

    public void uploadFile() {
        uploadsFile(uploadsFile, "C:\\Users\\nikulin\\IdeaProjects\\Alex\\src\\test\\resources\\logoFile.png");
    }
    public boolean isElementPresent(By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    }




