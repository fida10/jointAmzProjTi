package joint.titi.amazon.commonCode;

import joint.titi.amazon.initializerClasses.InitialFunctions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotsCode {
    private WebDriver dr; //might use this later on
    private String screenShotString;
    public void screenShotDirStringGenerator(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy\\MM\\dd\\HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        this.screenShotString =  System.getProperty("user.dir").concat("\\src\\resources\\reports\\screenshots\\").concat(dtf.format(now));
    }
    public void takeScreenShot(String passFailSkip){
        this.dr = InitialFunctions.getWebDriverPlainWithoutReinitializing();
        File src = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
        try {
            if (passFailSkip.equalsIgnoreCase("pass")) { //add method name to screenshot name
                FileUtils.copyFileToDirectory(src, new File(screenShotString.concat("\\pass")));
            } else if (passFailSkip.equalsIgnoreCase("fail")) {
                FileUtils.copyFileToDirectory(src, new File(screenShotString.concat("\\fail")));
            } else if (passFailSkip.equalsIgnoreCase("skip")) {
                FileUtils.copyFileToDirectory(src, new File(screenShotString.concat("\\skip")));
            }
        }
        catch (IOException e) {
            System.out.println("File directory is invalid, directory given was: " + screenShotString); //log4j
        }
    }
}
