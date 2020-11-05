package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesRead {
    private static final Properties prop = new Properties();
    private static final String path = "src/main/resources/config.properties";

    public static String readFromFrameworkConfig(String key) {
        try {
            InputStream input = new FileInputStream(path);
            prop.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}