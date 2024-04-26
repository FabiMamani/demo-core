package main;

import discovery.Notificador;
import discovery.NotificadorDiscovery;
import discovery.NotificadorFactory;
import properties.DemoProperties;

import java.nio.file.NoSuchFileException;
import java.util.Set;

public class Main {
     public static String path = "";

    public static void main(String[] args) throws NoSuchFileException {
        DemoProperties prop = DemoProperties.getInstance("src/test/resources/config-test.properties");
        path = prop.get("notificatorPath");
        NotificadorDiscovery notificadores = new NotificadorDiscovery();
        Set<Notificador> not= notificadores.discovery(path);
        for(Notificador n: not){
            System.out.println(n);
        }

    }
}
