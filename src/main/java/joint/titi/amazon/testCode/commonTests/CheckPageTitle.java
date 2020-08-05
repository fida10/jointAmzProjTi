package joint.titi.amazon.testCode.commonTests;

import org.openqa.selenium.WebDriver;

public class CheckPageTitle {
    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }
    public boolean validatePageTitle(WebDriver driver, String expectedPageTitle){
        String currentPageTitle = getPageTitle(driver);
        return (currentPageTitle.contains(expectedPageTitle));
    }
}
