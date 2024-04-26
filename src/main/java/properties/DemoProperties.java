package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DemoProperties {
    private static DemoProperties instance = null;
    private Properties properties;

    private DemoProperties(String path){
        properties = new Properties();
        try{
            properties.load(new FileInputStream(new File(path)));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static DemoProperties getInstance(String path){
        if (instance == null){
            synchronized (DemoProperties.class){
                if(instance == null){
                    instance = new DemoProperties(path);
                }
            }
        }
        return instance;
    }

    public String get(String key){
        return properties.getProperty(key);
    }
}
