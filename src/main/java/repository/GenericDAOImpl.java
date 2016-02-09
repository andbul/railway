package repository;

import util.JpaHelper;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by andrey on 09.02.16.
 */
public abstract class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK>{

    private Class<T> clazz = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass())
            .getActualTypeArguments()[0];

    protected EntityManager manager = JpaHelper.getManager();

    @Override
    public void create(T entity) {
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
    }

    @Override
    public T read(PK id) {
        return manager.find(clazz, id);
    }

    @Override
    public void update(T entity) {
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(PK id) {
        manager.getTransaction().begin();
        T entity = manager.find(clazz, id);
        manager.remove(entity);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        manager.getTransaction().begin();
        manager.remove(entity);
        manager.getTransaction().commit();
    }
}
