package joint.titi.amazon.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver dr;
    @FindBy (xpath = "//h1[contains(text(), 'Sign-In')]")
    WebElement signInPageHeader;
    @FindBy (xpath = "//span[contains(text(), 'Need help')]//parent::a")
    WebElement needHelpOptions;
    @FindBy (xpath = "//a[contains(text(), 'Forgot your password')]")
    WebElement needHelp_forgotPassword;
    @FindBy (xpath = "//a[contains(text(), 'Other issues with Sign-In')]")
    WebElement needHelp_otherIssuesSignIn;
    public SignInPage(WebDriver driver){
        this.dr = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getSignInPageHeader(){
        return signInPageHeader;
    }
    public WebElement getNeedHelpOptions(){
        return needHelpOptions;
    }
    public WebElement getNeedHelp_forgotPassword(){
        return needHelp_forgotPassword;
    }
    public WebElement getNeedHelp_otherIssuesSignIn(){
        return needHelp_otherIssuesSignIn;
    }

}
