package scenarios.ex3;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "native")
public class NativeTests extends TestsSettings {

    private String appPackageName = "com.example.android.contactmanager:id/";

    @Test(groups = "native", description = "Just click on button 'Add contact'")
    public void simplestTest() {

        By addButton = By.id(appPackageName + "addContactButton");
        driverSingle.findElement(addButton).click();

//        Check title above contact name text field
        String actualContactNameField = driverSingle.findElementByAccessibilityId("Contact Name").getText();
        Assert.assertEquals(actualContactNameField, "Contact Name");

//        Check that contact name text field is displayed
        Assert.assertTrue(driverSingle.findElementById(appPackageName + "contactNameEditText").isDisplayed());

//        Check title above contact phone text field
        String actualContactPhoneField = driverSingle.findElementByAccessibilityId("Contact Phone").getText();
        Assert.assertEquals(actualContactPhoneField, "Contact Phone");

//        Check that contact name text field is displayed
        Assert.assertTrue(driverSingle.findElementById(appPackageName + "contactPhoneEditText").isDisplayed());

//        Check title above contact e-mail text field
        String actualContactEmailField = driverSingle.findElementByAccessibilityId("Contact Email").getText();
        Assert.assertEquals(actualContactEmailField, "Contact Email");

//        Check that contact e-mail text field is displayed
        Assert.assertTrue(driverSingle.findElementById(appPackageName + "contactPhoneEditText").isDisplayed());

        Assert.assertTrue(driverSingle.findElementById(appPackageName + "contactSaveButton").isDisplayed());
    }
}