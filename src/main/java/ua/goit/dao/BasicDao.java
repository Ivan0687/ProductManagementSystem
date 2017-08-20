package ua.goit.dao;

import ua.goit.model.BasicEntity;

import java.io.Serializable;
import java.util.List;

public interface BasicDao<K extends Serializable, V extends BasicEntity> {

    V getById(K id, Class<? extends V> idClass);

    List<V> getAll(Class<? extends V> entityClass);

    void save(V value);

    void update(V value);

    void remove(V value);

}
