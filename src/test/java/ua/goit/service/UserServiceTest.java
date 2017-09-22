package ua.goit.service;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.goit.dao.UserDao;
import ua.goit.dao.impl.UserDaoImpl;
import ua.goit.model.User;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@Ignore
public class UserServiceTest {

    private User user;
    private UserDao userDao;
    private UserService userService;
    private String rightId;
    private String wrongId;

    @Before
    public void setUp() throws Exception {
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
        user = mock(User.class);
        userDao = mock(UserDaoImpl.class);
        userService = new UserService(userDao, passwordEncoder);
        rightId = "login";
        wrongId = "lagin";
    }

    @Test
    public void userNotExists() {
        when(userDao.getById(wrongId, User.class)).thenReturn(null);
        assertNull(userService.getById(wrongId));
    }

    @Test
    public void getById() {
        when(userDao.getById(rightId, User.class)).thenReturn(user);
        assertEquals(user, userService.getById(rightId));
    }

    @Test
    public void getAll() throws Exception {
       when(userDao.getAll(User.class)).thenReturn(Collections.singletonList(user));
        assertEquals(Collections.singletonList(user), userService.getAll());
    }

    @Test
    public void getAllEmpty() throws Exception {
       when(userDao.getAll(User.class)).thenReturn(Collections.emptyList());
        assertEquals(Collections.emptyList(), userService.getAll());
    }

    @Test
    public void save() throws Exception {
        doAnswer(i -> null).when(userDao).save(user);
        userDao.save(user);
        verify(userDao, times(1)).save(user);
    }

    @Test
    public void update() throws Exception {
        doAnswer(i -> null).when(userDao).update(user);
        userDao.update(user);
        verify(userDao, times(1)).update(user);
    }

    @Test
    public void remove() throws Exception {
        doAnswer(i -> null).when(userDao).remove(user);
        userDao.remove(user);
        verify(userDao, times(1)).remove(user);
    }

}