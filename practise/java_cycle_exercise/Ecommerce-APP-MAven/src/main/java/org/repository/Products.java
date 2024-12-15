package org.repository;
import org.exception.DuplicateProductException;
import org.exception.InvalidInputException;
import org.exception.ProductNotFoundException;
import org.model.Product;

import java.util.ArrayList;

public interface Products {

    void addProductsdata(Product product) throws InvalidInputException, DuplicateProductException;
    void viewallProducts();
    ArrayList<Product> getAll();
    Product findProduc(int id) throws ProductNotFoundException;

}
