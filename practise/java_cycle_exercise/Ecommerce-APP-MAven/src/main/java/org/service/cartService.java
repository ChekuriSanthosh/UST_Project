package org.service;

import org.model.Product;

import java.io.IOException;
import java.util.ArrayList;

public interface cartService {
    public void addToCArt(int id);

    public ArrayList<Product> getCartItems();

    public double calculateTotalPrice();

    public void applyDiscounts();

    public Product findproduct(int id) throws IOException;

}
