package apiAutomation.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public Properties prop;

    public int RESPONSE_STATUS_CODE_200 = 200;
    public int RESPONSE_STATUS_CODE_500 = 200;
    public int RESPONSE_STATUS_CODE_400 = 200;
    public int RESPONSE_STATUS_CODE_401 = 200;
    public int RESPONSE_STATUS_CODE_201 = 200;

    public TestBase() {
        try {
            prop = new Properties();
            try (FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\apiAutomation\\config\\config.properties")) {
                prop.load(ip);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

