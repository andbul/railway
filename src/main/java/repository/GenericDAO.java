package repository;


import java.io.Serializable;

/**
 * Interface used to interact with the persistence context.<p>
 * GenericDAO pattern implementation.<p>
 * Contains basic CRUD methods.<p>
 * @param <T> the type of entity
 * @param <PK> the type of entity primary key
 */
public interface GenericDAO<T, PK extends Serializable> {
    /**
     * Create entity, make it managed and persistent.
     * @see javax.persistence.EntityManager#persist(Object)
     * @param entity entity instance
     */
    void create(T entity);

    /**
     * Get entity by primary key
     * @see javax.persistence.EntityManager#find(Class, Object)
     * @param id entity primary key
     * @return  the found entity instance or null if the entity does
     *         not exist
     */
    T read(PK id);

    /**
     * Update managed entity
     * @see javax.persistence.EntityManager#merge(Object)
     * @param entity entity instance
     */
    void update(T entity);

    /**
     * Delete managed entity
     * @see javax.persistence.EntityManager#remove(Object)
     * @param entity entity instance
     */
    void delete(T entity);

    /**
     * Update managed entity
     * @see javax.persistence.EntityManager#find(Class, Object)
     * @see javax.persistence.EntityManager#remove(Object)
     * @param id entity primary key
     */
    void delete(PK id);

}
