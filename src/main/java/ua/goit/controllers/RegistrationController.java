package ua.goit.controllers;

import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public String registerUser(@RequestParam("login") @NotNull String login,
                               @RequestParam("password") @NotNull String password) {
        User user = new User(login, password);
        user.setRole(User.Roles.USER);
            userService.save(user);
        return "redirect:/login";
    }

}
