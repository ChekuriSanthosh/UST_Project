package org;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.exception.DuplicateProductException;
import org.exception.ProductNotFoundException;
import org.junit.jupiter.api.*;
import org.model.Product;
import org.repository.ProductsImpl;
import org.repository.cartImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
@Slf4j
public class ProductImplTest
    extends TestCase
{
    private static final Logger log = LoggerFactory.getLogger(ProductImplTest.class);

    ProductsImpl products;
    @BeforeAll
    static void init() {

        log.info("Objects setup completed...");
    }
    @BeforeEach
    void setup() throws DuplicateProductException {
        products=new ProductsImpl();
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
//        cart.addProduct(p.getProductId());
//        cart.addProduct(p1.getProductId());
        log.info("Implementing cart...");
    }

    @AfterEach
    void teardown(){
        products=null;
        log.info("Deleting after each");
    }

    @AfterAll
    static void delelecomplete(){
        log.info("Totally deleted....");
    }
    @Test
    public void testAddProduct(){
        Assertions.assertEquals(3,products.getAll().size());
        Assertions.assertEquals("Air2",products.getAll().get(0).getProductName());
        Assertions.assertEquals(22,products.getAll().get(0).getProductId());

    }
@Test
    public void findproductbyid() throws DuplicateProductException, ProductNotFoundException {
        Product p =new Product("Air2", 22, 195000,4);
        Product p1=new Product("Mac1",12,20100,4);
        Product p2=new Product("iphone",13,24355,12);
        Product res=products.findProduc(22);
        Assertions.assertEquals(p.getProductId(),res.getProductId());
        Assertions.assertEquals(p1.getProductId(),products.findProduc(12).getProductId());
    ProductsImpl finalProducts = products;
    Assertions.assertThrows(ProductNotFoundException.class,()->{
            finalProducts.findProduc(25);
        });
//        Assertions.assertThrows(ProductNotFoundException,products.findProduc(18));

    }

}
