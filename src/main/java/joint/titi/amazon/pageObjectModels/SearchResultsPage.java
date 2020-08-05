package joint.titi.amazon.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    WebDriver dr;
    @FindBy(xpath = ("//span[@class='a-color-state a-text-bold']"))
    WebElement searchPageCommonText;

    public SearchResultsPage(WebDriver driver){
        this.dr = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getSearchPageCommonText(){
        return searchPageCommonText;
    }
}
