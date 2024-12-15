package org;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.exception.DuplicateProductException;
import org.junit.jupiter.api.*;
import org.model.Product;
import org.repository.Cart;
import org.repository.ProductsImpl;
import org.repository.cartImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
@Slf4j
public class CartImplTest extends TestCase {
    private static final Logger log = LoggerFactory.getLogger(CartImplTest.class);


    ProductsImpl products;
    cartImpl cart;
    @BeforeAll
    static void init() {

        log.info("Objects setup completed...");
    }
    @BeforeEach
    void setup() throws DuplicateProductException {
        products=new ProductsImpl();
        cart=new cartImpl();
        Product p =new Product("Air2", 22, 195000,4);
        Product p1=new Product("Mac1",12,20100,4);
        Product p2=new Product("iphone",13,24355,12);
        try {
            products.addProductsdata(p);
            products.addProductsdata(p1);
            products.addProductsdata(p2);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        cart.addProduct(p.getProductId());
        cart.addProduct(p1.getProductId());
        log.info("Implementing cart...");
    }

    @AfterEach
    void teardown(){
        cart=null;
        products=null;
        log.info("Deleting after each");
    }

    @AfterAll
    static void delelecomplete(){
        log.info("Totally deleted....");
    }

    @Test
    public void addproducttocart() throws DuplicateProductException {
        if(cart.getAllProducts().size()>0){
            log.info("Not nulllll");
        }

        log.info(cart.getAllProducts().toString());
        Assertions.assertEquals(2,cart.getAllProducts().size());

        Assertions.assertEquals("Mac1",cart.getAllProducts().get(1).getProductName());
    }

    @Test
    public void findproductbyid() throws ArithmeticException, IOException, DuplicateProductException {
        Assertions.assertEquals("Mac1",cart.findProduct(12).getProductName());
        Assertions.assertThrows(ArithmeticException.class,()->{
            cart.findProduct(-1);
        });
        Assertions.assertEquals(2,cart.getAllProducts().size());
    }

}
