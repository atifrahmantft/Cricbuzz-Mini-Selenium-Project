package org.example.cricbuzz.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetConfigProperties {
    private static final String config_path = "src/main/java/org/example/cricbuzz/config/config.properties";
    private static Properties properties;

    public static void getProperties() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(config_path));
    }

    public static boolean isScreenShotNeeded(String status){
        if(status.equalsIgnoreCase("pass")){
            if(properties.getProperty("passedstepsscreenshot").equalsIgnoreCase("yes")){
                return true;
            }
            return false;
        } else if (status.equalsIgnoreCase("fail")) {
            if(properties.getProperty("failedstepsscreenshot").equalsIgnoreCase("yes")){
                return true;
            }
            return false;
        } else if (status.equalsIgnoreCase("skip")) {
            if(properties.getProperty("skippedstepsscreenshot").equalsIgnoreCase("yes")){
                return true;
            }
            return false;
        }
        return false;
    }

}
