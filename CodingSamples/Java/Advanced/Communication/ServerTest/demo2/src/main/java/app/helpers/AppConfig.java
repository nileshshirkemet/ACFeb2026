package app.helpers;

import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    
    private static final Properties settings = loadProperties();

    private static Properties loadProperties() {
        Properties props = new Properties();
        try(var input = AppConfig.class.getResourceAsStream("/application.properties")){
            props.load(input);
        }catch(IOException e){}
        return props;
    }

    public static String getSetting(String name, String defaultValue) {
        String value = settings.getProperty(name, defaultValue);
        return System.getProperty(name, value);
    }

    public static String getSetting(String name) {
        return getSetting(name, null);
    }

    public static int getSetting(String name, int defaultValue) {
        return Integer.parseInt(getSetting(name, String.valueOf(defaultValue)));
    }

    private AppConfig() {}
}
