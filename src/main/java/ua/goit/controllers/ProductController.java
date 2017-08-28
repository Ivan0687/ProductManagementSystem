package ua.goit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.model.Product;
import ua.goit.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "show_all")
    public ModelAndView showAllProducts(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products");
        List<Product> products = productService.getAll();

        modelAndView.addObject("products", products);
        return modelAndView;
    }


}
