package ua.goit.endpoints;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.goit.model.User;
import ua.goit.service.UserService;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
public class UserEndpoints {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserEndpoints(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void InitDefaultUsers(){

        User user = new User();
        user.setLogin("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setUsername("test user");
        user.setRole(User.Roles.USER);
        userService.save(user);

        User admin = new User();
        admin.setLogin("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setUsername("test admin");
        admin.setRole(User.Roles.ADMIN);
        userService.save(admin);

    }

}
