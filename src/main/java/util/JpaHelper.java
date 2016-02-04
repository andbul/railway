package util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by andrey on 04.02.16.
 */
public class JpaHelper {
    private static final EntityManager manager;

    static {
        try {
            manager = Persistence
                    .createEntityManagerFactory("RAILWAY")
                    .createEntityManager();
        }
        catch (Throwable e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManager getManager() {
        return manager;
    }
}
