package ChoosingRegion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Step {

    public void moveAndClick(Actions actions, WebElement element) {
        actions
                .moveToElement(element)
                .click()
                .perform();
    }
}
