package Leumit.auto;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class TestPropsReader {

    private static final String CONF_FILE = File.separator + "src/main/resources";
    private static final String DEFAULT_PROPS = "TestProps.properties";
    private static Properties properties;

    static {
        loadProperties();
    }

    private static void loadProperties() {
        properties = new Properties();
        try {
            File file = new File("");
            String absolutePath = file.getAbsolutePath();
            InputStream is = Files.newInputStream(Paths.get(absolutePath + CONF_FILE + File.separator + DEFAULT_PROPS));
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            Properties p = new Properties();
            p.load(isr);
            is.close();
            properties = p;
            if (properties.isEmpty()) {
                LogManager.error("Properties file '" + DEFAULT_PROPS + "' NOT found");
            } else {
                LogManager.debug("Properties file '" + DEFAULT_PROPS + "' found Successfully");
            }
        } catch (IOException e) {
            LogManager.error("Failed to load properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
