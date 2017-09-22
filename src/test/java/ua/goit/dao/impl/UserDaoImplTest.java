package ua.goit.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.goit.dao.UserDao;
import ua.goit.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserDaoImplTest {

    private SessionFactory sessionFactory;
    private Session session;
    private UserDao userDao;
    private User user;

    @Before
    public void setUp() throws Exception {
        sessionFactory = mock(SessionFactory.class);
        session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        userDao = new UserDaoImpl(sessionFactory);
        user = mock(User.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
        sessionFactory.close();
    }

    @Test
    public void getById() throws Exception {
        when(session.get(User.class, 1L)).thenReturn(user);
        assertEquals(user, userDao.getById("a", User.class));
    }

    @Test
    public void getAll() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(user);
        Query query = mock(Query.class);
        when(session.getNamedQuery("query")).thenReturn(query);

//        when(query.list()).thenReturn(Collections.singletonList(user));
        when(query.list()).thenReturn(users);

        assertEquals(Collections.singletonList(user), userDao.getAll(User.class));
        assertEquals(users, userDao.getAll(User.class));
//        assertEquals(user, userDao.getAll(User.class).get(0));

    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

}