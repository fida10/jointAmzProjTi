package joint.titi.amazon.listeners;

import joint.titi.amazon.commonCode.ScreenshotsCode;
import joint.titi.amazon.initializerClasses.InitialFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners implements ITestListener {
    private final ScreenshotsCode screenshotsCode = new ScreenshotsCode();
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        screenshotsCode.takeScreenShot("pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        screenshotsCode.takeScreenShot("fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        screenshotsCode.takeScreenShot("skip");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        screenshotsCode.screenShotDirStringGenerator();
    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
