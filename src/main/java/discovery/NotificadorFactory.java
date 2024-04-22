package discovery;

import java.lang.reflect.InvocationTargetException;

public class NotificadorFactory {

    public static Notificador crearNotificador(Notificador notificador) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return notificador.getClass().getConstructor().newInstance();
    }
}
