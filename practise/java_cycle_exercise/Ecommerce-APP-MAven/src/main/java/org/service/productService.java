package org.service;

import org.exception.DuplicateProductException;
import org.exception.InvalidInputException;
import org.exception.ProductNotFoundException;
import org.model.Product;

public interface productService {
    public void addProductstodata(Product product) throws InvalidInputException, DuplicateProductException;
    public void viewallProductsdata();
    public Product findProductdata(int id) throws ProductNotFoundException;
}
