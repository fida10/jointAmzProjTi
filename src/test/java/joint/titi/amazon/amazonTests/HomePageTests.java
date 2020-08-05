package joint.titi.amazon.amazonTests;

import joint.titi.amazon.initializerTestClasses.BeforeAfterHomePageTests;

import joint.titi.amazon.pageObjectModels.HomePageHamburgerMenu;
import joint.titi.amazon.pageObjectModels.SearchResultsPage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTests extends BeforeAfterHomePageTests {
    String expectedHomePageTitle = "Amazon.com: Online Shopping for";

    @Test (priority = 1)
    public void getHomePageTest(){
        boolean testPassFail = homePageTestsCode.getHomePage(dr, pro, expectedHomePageTitle); //add something here to verify that this is the home page, i.e. verify the title
        Assert.assertTrue(testPassFail);
    }
    @Test (priority = 2)
    public void searchForSomethingTest(){
        SearchResultsPage searchResultsPage = new SearchResultsPage(dr);
        boolean testPassFail = homePageTestsCode.searchForSomething(dr,"a4 Size Paper", homePage.getSearchBar(), homePage.getSearchButton(), searchResultsPage.getSearchPageCommonText());
        Assert.assertTrue(testPassFail);
    }
    @Test (priority = 3)
    public void returnToHomeWithAmazonLogoTest(){
        Assert.assertTrue(homePageTestsCode.returnToHomeWithAmazonLogo(dr, homePage.getBestSellersLink(), homePage.getAmazonLogo(), homePage.getCommonHomePageElement(),expectedHomePageTitle));
    }
    @Test (priority = 4)
    public void signInLinkVerifTest(){
        String expectedSignInPageTitle = "Amazon Sign-In";
        Assert.assertTrue(homePageTestsCode.signInLinkVerif(dr, homePage.getSignInLink(), expectedSignInPageTitle));
    }
    @Test (priority = 5)
    public void hamburgerMenuAppearsTest(){
        HomePageHamburgerMenu homePageHamburgerMenu = new HomePageHamburgerMenu(dr);
        Assert.assertTrue(homePageTestsCode.isHamburgerMenuOpen(dr, homePage.getHamburgerMenuOpener(), homePageHamburgerMenu.getHamburgerMenuMain()));
    }
    @Test (priority = 6)
    public void hoverOverNavBarLinks(){
        Assert.assertTrue(homePageTestsCode.hoverOverAllNavBarLinks(dr, homePage.getNavBar(), homePage.getAllNavBarLinks()));
    }
}
