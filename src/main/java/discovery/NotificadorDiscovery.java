package discovery;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.HashSet;
import java.util.Set;

public class NotificadorDiscovery {
    private String packageName = "notificadores";

    public NotificadorDiscovery() {}

    public Set<Notificador> discovery(String path) throws NoSuchFileException {
        Set<Notificador> result = new HashSet<>();

        for (File f : new File(path).listFiles()){
            String className = f.getName();
            if ( !className.endsWith(".class")) continue;

            //className = getFQDN(className, packageName);
            className = className.substring(0, className.lastIndexOf('.'));
            try {
                Class c = Class.forName(className);
                if (Notificador.class.isAssignableFrom(c)){
                    Notificador notifier = (Notificador) c.getDeclaredConstructor().newInstance();
                    result.add(notifier);
                }
            } catch (Exception e) { throw new RuntimeException(e); }
        }
        return result;
    }

}
