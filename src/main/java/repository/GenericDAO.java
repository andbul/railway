package repository;


import java.io.Serializable;

/**
 * Created by andrey on 04.02.16.
 */
public interface GenericDAO<T, PK extends Serializable>{
    T create();
    T read(PK id);
    void update(T transientObject);
    void delete(T persistentObject);
    void delete(PK id);

}
