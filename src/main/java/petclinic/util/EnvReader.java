package petclinic.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvReader {

    private static Properties properties = new Properties();

    static {
        InputStream is = EnvReader.class.getClassLoader().getResourceAsStream("env.properties"); //citim din fisi
        try {
            properties.load( is );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUri() {
       return properties.getProperty("baseUri");
    }

}
