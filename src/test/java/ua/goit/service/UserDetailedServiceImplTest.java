package ua.goit.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetailsService;
import ua.goit.model.User;

import static org.mockito.Mockito.mock;

public class UserDetailedServiceImplTest {

    private User user;
    private UserService userService;
    private UserDetailsService userDetailsService;

    @Before
    public void setUp() throws Exception {
    user = mock(User.class);
    userService = mock(UserService.class);
    userDetailsService = new UserDetailedServiceImpl(userService);
    }

    @Test
    public void loadUserByUsername() throws Exception {
    }

}