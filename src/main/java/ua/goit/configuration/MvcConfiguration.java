package ua.goit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("ua.goit.controllers")
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*.css").addResourceLocations("/resources/css/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/product/product_add").setViewName("product_add");
    }


    //
    // "view" -> new View("/PATH/TO/view")
    //
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // mean we will work with JPS
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jps/");
        resolver.setSuffix(".jsp");
        // Give me view name 'users' -> JstlView(/WEB-INF/jps/ + users + .jsp)
        return resolver;
    }

}
