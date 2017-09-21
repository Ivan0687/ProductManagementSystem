package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.goit.model.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailedServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailedServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = userService.getById(login);

        if (user == null)
            throw new UsernameNotFoundException("User" + login + " was not found");

        return new UserDetailsWrapper(user);
    }

    private static class UserDetailsWrapper implements UserDetails{

        private User user;
        private Collection<SimpleGrantedAuthority> grantedAuthorities;

        private UserDetailsWrapper(User user) {
            this.user = user;
            this.grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return grantedAuthorities;
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getLogin();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        public String getRegistrationDate(){
            return user.getRegistrationDate().toString();
        }

        public String getEmail (){
            return user.getLogin() + "@email.com";
        }

        @Override
        public String toString() {
            return "UserDetailsWrapper{" +
                    "user=" + user +
                    ", grantedAuthorities=" + grantedAuthorities +
                    '}';
        }
    }

}
