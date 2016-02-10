package util;

import org.apache.log4j.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by andrey on 04.02.16.
 */
public class JpaHelper {
    private static final Logger LOGGER = Logger.getLogger(JpaHelper.class);
    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("RAILWAY");
        } catch (Throwable e) {
            LOGGER.fatal("Initialization Entity manager factory error");
            throw new ExceptionInInitializerError(e);
        }
    }


    public static EntityManagerFactory getEmf() {
        return emf;
    }

}
