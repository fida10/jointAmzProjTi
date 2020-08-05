package joint.titi.amazon.testCode.testCode;

import joint.titi.amazon.pageObjectModels.HomePage;
import joint.titi.amazon.testCode.commonTests.ElementIsVisible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Properties;

public class SignInPageTestsCode {
    private final HomePageTestsCode homePage = new HomePageTestsCode();
    private final ElementIsVisible elementIsVisible = new ElementIsVisible();

    public void goToSignInPageBasic(WebDriver dr, Properties pro, WebElement signInLink){
        homePage.getHomePageBasic(dr, pro);
        Actions a = new Actions(dr);
        a
                .moveToElement(signInLink)
                .click()
                .build()
                .perform();
    }
    public boolean verifySignInPage(WebDriver dr, WebElement signInPageHeader){
        return elementIsVisible.elementVisible(dr, signInPageHeader);
    }
    public boolean seeNeedHelpOptionsTest(WebDriver dr, WebElement needHelpOptions, WebElement forgotPassword, WebElement otherIssuesSignIn){
        Actions a = new Actions(dr);
        a
                .moveToElement(needHelpOptions)
                .click()
                .build()
                .perform();
        return (elementIsVisible.elementVisible(dr, forgotPassword) && elementIsVisible.elementVisible(dr, otherIssuesSignIn));
    }
}
