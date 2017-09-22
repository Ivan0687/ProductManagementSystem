package ua.goit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.goit.model.User;
import ua.goit.service.UserService;

@Controller
@RequestMapping(method = RequestMethod.POST, value = "/register")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String registerUser(@RequestParam("login") String login,
                               @RequestParam("password") String password) {
        User user = new User(login, password);
        user.setRole(User.Roles.USER);
            userService.save(user);
        return "redirect:/login";
    }

}
