package ua.goit.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.goit.dao.BasicDao;
import ua.goit.model.BasicEntity;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractBasicDaoImpl<K extends Serializable, V extends BasicEntity> implements BasicDao<K, V> {

    private SessionFactory sessionFactory;

    public AbstractBasicDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public V getById(K id, Class<? extends V> idClass) {
        return getSession().get(idClass, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<V> getAll(Class<? extends V> entityClass) {
        return (List<V>) getSession().getNamedQuery("getAll" + getCleanEntityClass(entityClass) + "s").list();
    }

    private String getCleanEntityClass(Class<?> entityClass) {
        String[] split = entityClass.toString().split("\\.");
        return split[split.length - 1];
    }

    @Override
    public void save(V value) {
        getSession().save(value);
    }

    @Override
    public void update(V value) {
        getSession().update(value);
    }

    @Override
    public void remove(V value) {
        getSession().remove(value);
    }
}
