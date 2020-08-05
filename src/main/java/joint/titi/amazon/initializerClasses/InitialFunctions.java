package joint.titi.amazon.initializerClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class InitialFunctions {
    static String absPath = System.getProperty("user.dir");
    private static WebDriver dr;
    private static Properties staticProperties;
    private static void propertiesInit(){
        File f = new File(absPath.concat("//src//resources//propertiesFiles//staticProps.properties"));
        try {
            FileInputStream fileInputStream = new FileInputStream(f);
            staticProperties = new Properties();
            staticProperties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("IO Exception thrown, file path invalid"); //log4j
        }
    }
    private static void webDriverInit(){
        String browserProp = staticProperties.getProperty("browser");
        String pathToBrowserDrivers = absPath.concat("//src//resources//browserDrivers//");
        if(browserProp.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", pathToBrowserDrivers.concat("chromedriver.exe"));
            dr = new ChromeDriver();
            System.out.println("Using chrome"); //log4j
        } else if (browserProp.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", pathToBrowserDrivers.concat("geckodriver.exe"));
            dr = new FirefoxDriver();
            System.out.println("Using firefox"); //log4j
        } else {
            System.out.println("Invalid browser driver"); //log4j
        }
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public static Properties getProperties(){
        propertiesInit();
        return staticProperties;
    }
    public static WebDriver getWebDriver(){
        webDriverInit();
        return dr;
    }
}
