package org.repository;

import org.model.Product;

import java.io.IOException;
import java.util.ArrayList;

public interface Cart {
    public void addProduct(int id);
    public Product findProduct(int id) throws IOException;

    public ArrayList<Product> getAllProducts();

}
