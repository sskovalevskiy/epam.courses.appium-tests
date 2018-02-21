package scenarios.ex3;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class TestsSettings extends Driver {

    private String nativeTest = "native";
    private String webTest = "web";
    private String exceptionMessage = "Unclear type of test group.";

    protected static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle = null;

    @BeforeMethod
    protected void prepareBeforeTest(Method method) throws Exception {

//      Setup type of application: mobile, web (or hybrid)
        List<String> groups = Arrays.asList(method.getAnnotation(Test.class).groups());

        if (groups.contains(nativeTest) && !groups.contains(webTest)) {
//        Native
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (groups.contains(webTest) && !groups.contains(nativeTest)) {
//        Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception(exceptionMessage);
        }

        // Init driver for local Appium server with capabilities have been set
        if (driverSingle == null) driverSingle = new AppiumDriver(new URL(driver), capabilities);
    }

    /**
     * Set an object to handle timeouts
     *
     * @return WebDriverWait waitSingle;
     * @throws Exception
     */
    protected WebDriverWait driverWait() {
        if (waitSingle == null) waitSingle = new WebDriverWait(driverSingle, 10);
        return waitSingle;
    }

}
