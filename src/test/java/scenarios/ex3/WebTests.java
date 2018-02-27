package scenarios.ex3;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;
import java.net.URL;

@Test(groups = "web")
public class WebTests extends TestsSettings {

    private String pageTitle = "Internet Assigned Numbers Authority";

    @Test(groups = "web", description = "Open website, test URL & page title")
    public void webTest() {
        driverSingle.get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT));

        Assert.assertEquals(SUT, driverSingle.getCurrentUrl());
        Assert.assertEquals(pageTitle, driverSingle.getTitle());
    }

}
