package ua.goit.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/", "/login", "/login?logout", "/login?error"})
    public String loginPage(Model model) {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/logout")
    public String logout() {
        return "redirect:/login?logout";
    }


    /*
    @PostConstruct
    public void InitDefaultUsers() {
        if (userService.getById("user") == null) {
            User user = new User();
            user.setLogin("user");
            user.setPassword(passwordEncoder.encode("user"));
            user.setRole(User.Roles.USER);
            userService.save(user);
        }
        if (userService.getById("admin") == null) {
            User admin = new User();
            admin.setLogin("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setRole(User.Roles.ADMIN);
            userService.save(admin);
        }
    }
    */
}
