package ua.goit.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.dao.UserDao;
import ua.goit.model.User;

@Repository
public class UserDaoImpl extends AbstractBasicDaoImpl<String, User> implements UserDao {

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
