package setup;

/**
 * Initialize a driver with test properties
 */

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

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
    protected String deviceName;
    protected String appPackage;
    protected String appActivity;
    protected static String UDID;

    protected String browserName;

    // Constructor initializes properties on driver creation
    protected Driver() {
        AUT = getProp("aut");
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "http://" + t_sut +"/";
        testPlatform = getProp("platform");
        driver = getProp("driver");
        deviceName = getProp("devicename");
        appPackage = getProp("appPackage");
        appActivity = getProp("appActivity");
//        UDID = getProp("udid");
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
//                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");//default Android emulator
                capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
                capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
                browserName = CHROME;
                break;
            case IOS:
                browserName = SAFARI;
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, testPlatform);
//        capabilities.setCapability(MobileCapabilityType.UDID, UDID);
    }
}
