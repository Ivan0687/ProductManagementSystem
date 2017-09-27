package ua.goit.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.goit.model.User;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailedServiceImplTest {

    @BeforeClass
    public static void beforeClass() {
        MockitoAnnotations.initMocks(UserDetailedServiceImpl.class);
    }

    @Mock
    private UserService userService;

    private User user;

    @InjectMocks
    private UserDetailedServiceImpl userDetailsService;


    @Test
    public void loadUserByUsername() throws Exception {

        user = mock(User.class);

        when(userService.getById(anyString())).thenReturn(user);

        UserDetails details = userDetailsService.loadUserByUsername(anyString());

        assertNotNull(details);
    }



    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsernameAUserIsNull() {

        when(userService.getById(anyString())).thenReturn(null);

        userDetailsService.loadUserByUsername(anyString());
    }

}