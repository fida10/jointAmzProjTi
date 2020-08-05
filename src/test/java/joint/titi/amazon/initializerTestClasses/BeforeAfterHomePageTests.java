package joint.titi.amazon.initializerTestClasses;

import joint.titi.amazon.initializerClasses.InitialFunctions;
import joint.titi.amazon.pageObjectModels.HomePage;
import joint.titi.amazon.testCode.testCode.HomePageTestsCode;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BeforeAfterHomePageTests {
    protected Properties pro;
    protected WebDriver dr;
    protected HomePage homePage;
    protected HomePageTestsCode homePageTestsCode;
    @BeforeMethod
    public void setDrAndProperties(){
        pro = InitialFunctions.getProperties();
        dr = InitialFunctions.getWebDriver();
        homePage = new HomePage(dr);
        homePageTestsCode = new HomePageTestsCode();
        homePageTestsCode.getHomePageBasic(dr, pro);
    }
    @AfterMethod
    public void quitBrowser(){
        dr.quit();
    }
}
