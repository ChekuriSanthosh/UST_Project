package org;

import org.exception.DuplicateProductException;
import org.exception.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.model.Clothing;
import org.model.Product;
import org.model.Size;
import org.repository.ProductsImpl;
import org.repository.cartImpl;
import org.service.cartServiceImpl;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

//    public void addToCart(Product product) {
//
//        cartRepo.addProduct(product);
//
//    }

    @Mock
    cartImpl cartRepository;

    @InjectMocks
    cartServiceImpl cartService;

    @Test
    void testAddToCart() throws ProductNotFoundException, DuplicateProductException, IOException {
        ProductsImpl products=new ProductsImpl();

        // Given
        Product product = new Clothing("T-Shirt", 10,2000, 10,  "cotton",Size.MEDIUM);
        products.addProductsdata(product);
//
//        // When
        Mockito.doNothing().when(cartRepository).addProduct(product.getProductId());
        Mockito.when(cartRepository.findProduct(product.getProductId())).thenReturn(product);
//
//        // Then
        cartService.addToCArt(product.getProductId());
        Assertions.assertDoesNotThrow(() -> cartService.findproduct(product.getProductId()));

        Mockito.verify(cartRepository, Mockito.times(1)).addProduct(product.getProductId());


    }

@Test
    void findBYID() throws DuplicateProductException, IOException {

        Product product = new Clothing("T-Shirt", 10,2000, 10,  "cotton",Size.MEDIUM);
        Mockito.when(cartRepository.findProduct(product.getProductId())).thenReturn(product);
        Assertions.assertDoesNotThrow(() -> cartService.findproduct(product.getProductId()));

        Mockito.verify(cartRepository, Mockito.times(1)).findProduct(10);


    }







}

