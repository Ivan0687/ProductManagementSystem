package ua.goit.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ua.goit.dao.ProductDao;
import ua.goit.dao.impl.configuration.TestDaoConfiguration;
import ua.goit.model.Product;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDaoConfiguration.class)
public class ProductDaoImplTest {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private ProductDao productDao;
    private Product product;

    @Before
    public void setUp() throws Exception {
        session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        productDao = new ProductDaoImpl(sessionFactory);
        product = mock(Product.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
        sessionFactory.close();
    }

    @Test
    public void getByIdTest() throws Exception {
        when(session.get(Product.class, 1L)).thenReturn(product);
        assertEquals(product, productDao.getById(1L, Product.class));
    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

}