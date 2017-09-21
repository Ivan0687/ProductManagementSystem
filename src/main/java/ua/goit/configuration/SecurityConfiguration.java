package ua.goit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("ua.goit.service")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/login", "/registration", "/register").permitAll()
                .antMatchers("/product/list", "/product/show_all").hasAnyRole("USER", "ADMIN")
                .antMatchers("/product/**").hasRole("ADMIN")
                .antMatchers("/**").authenticated()
                .anyRequest().denyAll()
            .and()
                .formLogin()
                //.successForwardUrl("/product/show_all")
                .defaultSuccessUrl("/product/show_all")
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()
            .and()
                // разрешаем делать логаут всем
                .logout().permitAll()
                // указываем URL логаута
                .logoutUrl("/logout")
                // указываем URL при удачном логауте
                .logoutSuccessUrl("/")
                // делаем не валидной текущую сессию
                .invalidateHttpSession(true)
            .and()
                .csrf().disable();
    }
}
