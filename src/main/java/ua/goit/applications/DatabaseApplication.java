package ua.goit.applications;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.core.userdetails.UserDetailsService;
import ua.goit.configuration.ModelConfiguration;
import ua.goit.configuration.SecurityConfiguration;
import ua.goit.model.User;
import ua.goit.service.UserDetailedServiceImpl;
import ua.goit.service.UserService;

public class DatabaseApplication {

    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(ModelConfiguration.class, SecurityConfiguration.class)){
            System.out.println("-------------------------------------------------------------------------------------");

            UserService userService = context.getBean(UserService.class);
            UserDetailedServiceImpl userDetailedService = context.getBean(UserDetailedServiceImpl.class);

            User user = userService.getById("user");
            System.out.println(user);

            System.out.println(userDetailedService.loadUserByUsername("user"));


            //user.setRegistrationDate(null);
            //user.setPassword("qqq");

            //userService.save(user);


            System.out.println("-------------------------------------------------------------------------------------");
        }
    }

}
