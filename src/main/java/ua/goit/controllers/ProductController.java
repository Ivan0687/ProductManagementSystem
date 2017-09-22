package ua.goit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.model.Product;
import ua.goit.service.ProductService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/show_all", "/list"})
    public ModelAndView showAllProducts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products");
        List<Product> products = productService.getAll();

        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product_delete/id={id}")
    public String deleteProduct(@PathVariable("id") String id) {
        Product product = productService.getById(Long.parseLong(id));
        productService.remove(product);
        return "redirect:/product/show_all";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product_update/id={id}")
    public ModelAndView updateProduct(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.getById(Long.parseLong(id));
        modelAndView.setViewName("product_update");

        modelAndView.addObject("product", product);
        return modelAndView;
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateProduct(@RequestParam("id") Long id,
                                @RequestParam("name") String name,
                                @RequestParam("manufacturer") String manufacturer,
                                @RequestParam("dollars") Integer dollars,
                                @RequestParam("cents") Integer cents,
                                @RequestParam("description") String description
    ) throws IOException {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setManufacturer(manufacturer);
        product.setDescription(description);
        BigDecimal price = BigDecimal.valueOf(dollars + (double)cents/100);
        product.setCost(price);
        productService.update(product);
        return "redirect:/product/show_all";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createProduct(@RequestParam("name") String name,
                                @RequestParam("manufacturer") String manufacturer,
                                @RequestParam("dollars") Integer dollars,
                                @RequestParam("cents") Integer cents,
                                @RequestParam("description") String description
    ) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setManufacturer(manufacturer);
        product.setDescription(description);
        BigDecimal price = BigDecimal.valueOf(dollars + (double)cents / 100);
        product.setCost(price);
        productService.save(product);
        return "redirect:/product/show_all";
    }

    /*
    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void createUser(@RequestParam("username") @NotEmpty String username,
                           @NotEmpty String password,
                           @RequestParam("admin") boolean isAdmin,
                           @RequestParam(required = false) String email,
                           @RequestHeader(value = "x", required = false) String x,
                           @CookieValue(value = "y", required = false) String y) throws IOException {
        User user = new User();
        user.setUsername(username);
        user.setAdministrator(isAdmin);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        usersService.save(user);
    }
    */
}
