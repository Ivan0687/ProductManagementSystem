package ua.goit.service;

import org.junit.Before;
import org.junit.Test;
import ua.goit.dao.UserDao;
import ua.goit.dao.impl.UserDaoImpl;
import ua.goit.model.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private User user;
    private UserDao userDao;
    private UserService userService;
    private String rightId;
    private String wrongId;

    @Before
    public void setUp() throws Exception {
        user = mock(User.class);
        userDao = mock(UserDaoImpl.class);
        userService = new UserService(userDao);
        rightId = "login";
        wrongId = "lagin";
    }

    @Test
    public void userNotExists(){
        when(userDao.getById(wrongId, User.class)).thenReturn(null);
        assertNull(userService.getById(wrongId));
    }

    @Test
    public void getById(){
        when(userDao.getById(rightId, User.class)).thenReturn(user);
        assertEquals(user, userService.getById(rightId));
    }

    @Test
    public void getAll() throws Exception {

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