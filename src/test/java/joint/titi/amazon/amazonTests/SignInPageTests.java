package joint.titi.amazon.amazonTests;

import joint.titi.amazon.initializerTestClasses.BeforeAfterSignInPageTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPageTests extends BeforeAfterSignInPageTests {
    @Test (priority = 1)
    public void verifySignInPageTest(){
        Assert.assertTrue(signInPageTestsCode.verifySignInPage(dr, signInPage.getSignInPageHeader()));
    }
    @Test (priority = 2)
    public void seeNeedHelpOptionsTest(){
        Assert.assertTrue(signInPageTestsCode.seeNeedHelpOptionsTest(dr, signInPage.getNeedHelpOptions(), signInPage.getNeedHelp_forgotPassword(), signInPage.getNeedHelp_otherIssuesSignIn()));
    }
}
