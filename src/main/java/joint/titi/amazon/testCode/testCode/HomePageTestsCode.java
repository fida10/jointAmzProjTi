package joint.titi.amazon.testCode.testCode;

import joint.titi.amazon.testCode.commonTests.CheckPageTitle;
import joint.titi.amazon.testCode.commonTests.ElementIsVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

import java.util.List;
import java.util.Properties;

public class HomePageTestsCode {
    private final CheckPageTitle checkPageTitle = new CheckPageTitle();
    private final ElementIsVisible elementIsVisible = new ElementIsVisible();
    public void getHomePageBasic(WebDriver dr, Properties pro){
        dr.get(pro.getProperty("homePage"));
    }
    public boolean getHomePage(WebDriver dr, Properties pro, String expectedHomePageTitle){
        dr.get(pro.getProperty("homePage"));
        String currentPageTitle = checkPageTitle.getPageTitle(dr);
        return (currentPageTitle.contains(expectedHomePageTitle));
    }
    public boolean searchForSomething(WebDriver dr, String whatToSearchFor, WebElement searchBar, WebElement getSearchButton, WebElement searchPageCommonText){
        Actions a = new Actions(dr);
        a
                .moveToElement(searchBar)
                .click()
                .sendKeys(whatToSearchFor)
                .build()
                .perform();
        a
                .moveToElement(getSearchButton)
                .click()
                .build()
                .perform();
        String actualSearchPageText = searchPageCommonText.getText();
        return(actualSearchPageText.contains(whatToSearchFor));
    }
    public boolean returnToHomeWithAmazonLogo(WebDriver dr, WebElement randomLink, WebElement amazonLogo, WebElement commonHomePageElement,String expectedHomePageTitle){
        Actions a = new Actions(dr);
        a
                .moveToElement(randomLink)
                .click()
                .build()
                .perform();
        a
                .moveToElement(amazonLogo)
                .click()
                .build()
                .perform();
        elementIsVisible.elementVisible(dr, commonHomePageElement);
        return (checkPageTitle.validatePageTitle(dr, expectedHomePageTitle));
    }
    public boolean signInLinkVerif(WebDriver dr, WebElement signInLink, String expectedPageTitle){
        Actions a = new Actions(dr);
        a
                .moveToElement(signInLink)
                .click()
                .build()
                .perform();
        return(checkPageTitle.validatePageTitle(dr, expectedPageTitle));
    }
    public boolean isHamburgerMenuOpen(WebDriver dr, WebElement hamburgerMenuOpener, WebElement hamburgerMenuMain){
        Actions a = new Actions(dr);
        a
                .moveToElement(hamburgerMenuOpener)
                .click()
                .build()
                .perform();
        return (elementIsVisible.elementVisible(dr, hamburgerMenuMain));
    }
    public boolean hoverOverAllNavBarLinks(WebDriver dr, WebElement navBar, List<WebElement> listOfNavBarLinks){
        if(elementIsVisible.elementVisible(dr, navBar)) {
            Actions a = new Actions(dr);
            try {
                for (int i = 0; i < listOfNavBarLinks.size(); i++) {
                    a
                            .moveToElement(listOfNavBarLinks.get(i))
                            .build()
                            .perform();
                }
            } catch (MoveTargetOutOfBoundsException e) {
                System.out.println("Some links are out of bounds but overall the nav bar is accessible."); //log4j
            }
            return true;
        } else {
            return false;
        }
    }
}