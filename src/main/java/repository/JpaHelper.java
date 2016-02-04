package repository;


import exception.NotFoundException;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by andrey on 03.02.16.
 */
public abstract class JpaHelper {
    public static Object getSingleResult(Query query) throws NotFoundException {
        List results = query.getResultList();
        if (results.isEmpty()) throw  new NotFoundException();
        return results.get(0);
    }
}
