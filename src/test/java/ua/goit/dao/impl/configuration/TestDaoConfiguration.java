package ua.goit.dao.impl.configuration;

import org.hibernate.SessionFactory;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestDaoConfiguration {

    @Bean
    public SessionFactory sessionFactory() {
        return Mockito.mock(SessionFactory.class);
    }

}
