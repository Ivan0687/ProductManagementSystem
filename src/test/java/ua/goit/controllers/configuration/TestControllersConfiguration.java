package ua.goit.controllers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.goit.service.ProductService;
import ua.goit.service.UserService;

import static org.mockito.Mockito.mock;

@Configuration
public class TestControllersConfiguration {

    @Bean
    public UserService userService(){
        return mock(UserService.class);
    }

    @Bean
    public ProductService productService(){
        return mock(ProductService.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return mock(PasswordEncoder.class);
    }

}
