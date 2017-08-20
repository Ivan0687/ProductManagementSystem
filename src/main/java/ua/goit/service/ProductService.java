package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.dao.ProductDao;
import ua.goit.model.Product;

import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return productDao.getById(id, Product.class);
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productDao.getAll(Product.class);
    }

    @Transactional
    public void save(Product value) {
        productDao.save(value);
    }

    @Transactional
    public void update(Product value) {
        productDao.update(value);
    }

    @Transactional
    public void remove(Product value) {
        productDao.remove(value);
    }
}
