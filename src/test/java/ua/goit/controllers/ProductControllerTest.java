package ua.goit.controllers;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.goit.configuration.MvcConfiguration;
import ua.goit.configuration.SecurityConfiguration;
import ua.goit.controllers.configuration.TestControllersConfiguration;
import ua.goit.model.Product;
import ua.goit.service.ProductService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        TestControllersConfiguration.class,
        MvcConfiguration.class,
        SecurityConfiguration.class})
public class ProductControllerTest {

    @Autowired
    private ProductService productService;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    private Product product;

    @Before
    public void setUp() throws Exception {
        product = mock(Product.class);

        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    public void showAllProducts() throws Exception {
        mvc.perform(get("/product/show_all", "/product/list").with(user("user").roles("ADMIN", "USER")))
                .andExpect(model().attribute("products", equalTo(productService.getAll())))
                .andExpect(view().name("products"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteProduct() throws Exception {
        mvc.perform(get("/product/product_delete/id=1").with(user("user").roles("USER", "ADMIN")))
                .andExpect(redirectedUrl("/product/show_all"))
                .andExpect(status().isFound());
    }

    @Test
    public void updateProductForm() throws Exception {
        mvc.perform(get("/product//product_update/id=1").with(user("user").roles("ADMIN", "USER")))
                .andExpect(model().attribute("product", equalTo(productService.getById(anyLong()))))
                .andExpect(view().name("product_update"))
                .andExpect(status().isOk());
    }

    @Ignore
    @Test
    public void updateProduct() throws Exception {
        mvc.perform(post("/product/update").with(user("user").roles("USER", "ADMIN")))
                .andExpect(redirectedUrl("/product/show_all"))
                .andExpect(status().isFound());
    }

    @Test
    public void createProduct() throws Exception {
    }

}