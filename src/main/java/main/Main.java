package main;

import discovery.Notificador;
import discovery.NotificadorDiscovery;
import discovery.NotificadorFactory;

import java.nio.file.NoSuchFileException;
import java.util.Set;

public class Main {
    //public static String path = "notificadores";
    public static String path = "src/test/resources/notificadores";
    //public String packname = "notificadores";

    public static void main(String[] args) throws NoSuchFileException {
        NotificadorDiscovery notificadores = new NotificadorDiscovery();
        Set<Notificador> not= notificadores.discovery(path);

    }
}
