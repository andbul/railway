package repository;

import util.JpaHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by andrey on 09.02.16.
 */
public abstract class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK>{

    private Class<T> clazz = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass())
            .getActualTypeArguments()[0];

    protected EntityManagerFactory emf = JpaHelper.getEmf();

    @Override
    public void create(T entity) {
        EntityManager manager = emf.createEntityManager();
        try {
            try {
                manager.getTransaction().begin();
                manager.persist(entity);
                manager.getTransaction().commit();
            }
            finally {
                if (manager.getTransaction().isActive())
                    manager.getTransaction().rollback();
            }
        } finally {
            manager.close();
        }
    }

    @Override
    public T read(PK id) {
        EntityManager manager = emf.createEntityManager();
        return manager.find(clazz, id);
    }

    @Override
    public void update(T entity) {
        EntityManager manager = emf.createEntityManager();
        try {
            try {
                manager.getTransaction().begin();
                manager.merge(entity);
                manager.getTransaction().commit();
            }
            finally {
                if (manager.getTransaction().isActive())
                    manager.getTransaction().rollback();
            }
        } finally {
            manager.close();
        }
    }

    @Override
    public void delete(PK id) {
        EntityManager manager = emf.createEntityManager();
        try {
            try {
                manager.getTransaction().begin();
                T entity = manager.find(clazz, id);
                manager.remove(entity);
                manager.getTransaction().commit();
            }
            finally {
                if (manager.getTransaction().isActive())
                    manager.getTransaction().rollback();
            }
        } finally {
            manager.close();
        }
    }
}