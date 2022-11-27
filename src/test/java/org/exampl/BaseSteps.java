package org.exampl;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BaseSteps {
    private final Random random = new Random();
    public void clickOnButton(WebElement element) {
        element.click();
    }

    public void inputText(String text, WebElement element) {
        element.sendKeys(Keys.HOME + text);
    }

    public void moveAndClick(Actions action, WebElement element) {
        action.moveToElement(element)
                .click()
                .perform();
    }

    public void waitElementShouldBeClick(WebDriverWait wait, WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isClicked(WebElement element) {
        return element.isSelected();
    }

    public WebElement chooseRandomElement(WebElement [] elements) {
        int index = random.nextInt(elements.length - 1);
        System.out.println("тут индекс "+ index);
        return elements[index];
    }

    public void uploadsFile(WebElement element, String pathToFile){
        element.sendKeys(pathToFile);
    }
}
