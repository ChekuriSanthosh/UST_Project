package org.service;

import org.exception.DuplicateProductException;
import org.exception.InvalidInputException;
import org.exception.ProductNotFoundException;
import org.model.Product;
import org.repository.Products;
import org.repository.ProductsImpl;

public class ProductServiceImpl implements productService{

    private Products productRepo= new ProductsImpl();

    public void addProductstodata(Product product) throws InvalidInputException, DuplicateProductException {
        productRepo.addProductsdata(product);
    }

    public void viewallProductsdata(){
        productRepo.viewallProducts();
    }

    public Product findProductdata(int id) throws ProductNotFoundException {
        return productRepo.findProduc(id);

    }
}
