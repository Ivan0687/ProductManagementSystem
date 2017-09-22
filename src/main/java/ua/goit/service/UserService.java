package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.dao.UserDao;
import ua.goit.model.User;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public User getById(String login) {
        return userDao.getById(login, User.class);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.getAll(User.class);
    }

    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public void remove(User user) {
        userDao.remove(user);
    }

}
