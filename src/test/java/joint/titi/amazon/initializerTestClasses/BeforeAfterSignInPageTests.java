package joint.titi.amazon.initializerTestClasses;

import joint.titi.amazon.initializerClasses.InitialFunctions;
import joint.titi.amazon.pageObjectModels.HomePage;
import joint.titi.amazon.pageObjectModels.SignInPage;
import joint.titi.amazon.testCode.testCode.SignInPageTestsCode;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BeforeAfterSignInPageTests {
    protected Properties pro;
    protected WebDriver dr;
    protected SignInPage signInPage;
    protected SignInPageTestsCode signInPageTestsCode;
    protected HomePage homePage;

    @BeforeMethod
    public void setDrAndProperties(){
        pro = InitialFunctions.getProperties();
        dr = InitialFunctions.getWebDriver();
        signInPageTestsCode = new SignInPageTestsCode();
        signInPage = new SignInPage(dr);
        homePage = new HomePage(dr);
        signInPageTestsCode.goToSignInPageBasic(dr, pro, homePage.getSignInLink());
    }
    @AfterMethod
    public void quitBrowser(){
        dr.quit();
    }
}
