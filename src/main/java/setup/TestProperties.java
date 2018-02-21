package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class TestProperties {
    Properties currentProps = new Properties();

    Properties getCurrentProps(){
        try (FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/test.properties")) {
            currentProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentProps;
    }

    protected String getProp(String propKey) {
        if (!currentProps.containsKey(propKey)) {
            currentProps = getCurrentProps();
        }
        // "default" form used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);
    }
}
