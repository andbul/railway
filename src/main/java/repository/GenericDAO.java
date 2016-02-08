package repository;


import java.io.Serializable;

/**
 * Created by andrey on 04.02.16.
 */
public interface GenericDAO<T, PK extends Serializable> {
    void create(T entity);

    T read(PK id);

    void update(T entity);

    void delete(T entity);

    void delete(PK id);

}
