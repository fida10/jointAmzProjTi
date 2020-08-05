package joint.titi.amazon.pageObjectModels;

import com.google.inject.internal.asm.$ClassTooLargeException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    WebDriver dr;
    @FindBy(xpath = ("//div[@id='desktop-grid-1']"))
    WebElement commonHomePageElement;
    @FindBy(xpath = "//a[@class='nav-logo-link' and @aria-label='Amazon']")
    WebElement amazonLogo;
    @FindBy(xpath = ("//input[@type='text' and @id='twotabsearchtextbox']"))
    WebElement searchBar;
    @FindBy(xpath = ("//a[@id='nav-hamburger-menu']"))
    WebElement hamburgerMenuOpener;
    @FindBy(xpath = ("//input[@type='submit' and @class='nav-input']"))
    WebElement searchButton;
    @FindBy(xpath = ("//span[contains(text(), 'Hello, Sign in')]//parent::div//parent::a"))
    WebElement signInLink;
    @FindBy(xpath = ("//a[text()='Best Sellers' and @class='nav-a  ']"))
    WebElement bestSellersLink;
    @FindBy(xpath = "//div[@id='nav-xshop']")
    WebElement navBar;
    @FindBy(xpath = ("//div[@id='nav-xshop']//a"))
    List<WebElement> allNavBarLinks;
    public HomePage(WebDriver driver){
        this.dr = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getCommonHomePageElement(){
        return commonHomePageElement;
    }
    public WebElement getAmazonLogo(){
        return amazonLogo;
    }
    public WebElement getSearchBar(){
        return searchBar;
    }
    public WebElement getHamburgerMenuOpener(){
        return hamburgerMenuOpener;
    }
    public WebElement getSearchButton(){
        return searchButton;
    }
    public WebElement getSignInLink(){
        return signInLink;
    }
    public WebElement getBestSellersLink(){
        return bestSellersLink;
    }
    public WebElement getNavBar(){
        return navBar;
    }
    public List<WebElement> getAllNavBarLinks(){
        return allNavBarLinks;
    }
}
