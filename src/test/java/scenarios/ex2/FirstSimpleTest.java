package scenarios.ex2;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSimpleTest extends DriverSetup {

    @BeforeClass
    /**
     * Prepare driver to run test(s)
     */
    public void setUp() throws Exception {
        prepareAndroidNative();
//       prepareAndroidWeb();
    }

    @Test(description = "This simple test just click on button 'Add contact'")
    public void SimplestTest() {
        String app_package_name = "com.example.android.contactmanager:id/";
//       By addBtn = By.id(app_package_name + "addContactButton");
//       driver.findElement(addBtn).click();
//        By addBtnByXpath = By.xpath("//android.widget.Button[@content-desc=\"Add Contact\"]");
//        driver.findElement(addBtnByXpath).click();
        By addBtnByClassName = By.className("android.widget.Button");
        driver.findElement(addBtnByClassName).click();

        System.out.println("Simplest Appium test done");
    }

    //    @Test(description = "Open website")
    public void webTest() {
        driver.get("http://iana.org");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Site opening done");
    }


    @AfterClass
    /**
     * Close driver on all tests completion
     */
    public void tearDown() throws Exception {
        driver.quit();
    }
}
