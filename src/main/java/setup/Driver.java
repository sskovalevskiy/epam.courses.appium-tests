package setup;

/**
 * Initialize a driver with test properties
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.SAFARI;

public class Driver extends TestProperties {
    protected DesiredCapabilities capabilities;

    // Properties to be read
    protected String AUT; // (mobile) app under testing
    protected String SUT; // site under testing
    protected String testPlatform;
    protected String driver;

    protected String browserName;

    // Constructor initializes properties on driver creation
    protected Driver() {
        AUT = getProp("aut");
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "http://" + t_sut +"/";
        testPlatform = getProp("platform");
        driver = getProp("driver");
    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     *
     * @throws Exception
     */
    @BeforeSuite
    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (testPlatform) {
            case ANDROID:
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");//default Android emulator
                browserName = CHROME;
                break;
            case IOS:
                browserName = SAFARI;
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, testPlatform);
    }
}
