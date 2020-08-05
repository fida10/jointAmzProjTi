package joint.titi.amazon.testCode.commonTests;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementIsVisible {
    public boolean elementVisible(WebDriver dr, WebElement elementToCheckVisibility){
        try {
            elementToCheckVisibility.isDisplayed();
            Actions a = new Actions(dr);
            a
                    .moveToElement(elementToCheckVisibility)
                    .build()
                    .perform();
            return true;
        } catch (ElementNotVisibleException e){
            return false;
        }

    }
}
