package ua.goit.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.dao.ProductDao;
import ua.goit.model.Product;

@Repository
public class ProductDaoImpl extends AbstractBasicDaoImpl<Long, Product> implements ProductDao {

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
