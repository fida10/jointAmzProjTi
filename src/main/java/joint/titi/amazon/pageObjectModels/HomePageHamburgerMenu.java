package joint.titi.amazon.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageHamburgerMenu {
    WebDriver dr;
    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible']")
    WebElement hamburgerMenuMain;
    public HomePageHamburgerMenu(WebDriver driver){
        this.dr = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getHamburgerMenuMain(){
        return hamburgerMenuMain;
    }
}
