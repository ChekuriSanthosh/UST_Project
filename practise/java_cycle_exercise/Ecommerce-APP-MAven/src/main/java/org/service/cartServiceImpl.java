package org.service;

import org.model.Clothing;
import org.model.Electronics;
import org.model.Product;
import org.repository.Cart;
import org.repository.cartImpl;

import java.io.IOException;
import java.util.ArrayList;

public class cartServiceImpl implements cartService {
    private Cart cartRepo= new cartImpl();

    public void addToCArt(int id){
        cartRepo.addProduct(id);
    }

    public ArrayList<Product> getCartItems(){
        return cartRepo.getAllProducts();
    }

    public double calculateTotalPrice(){
        ArrayList<Product> products = cartRepo.getAllProducts();
        double total = 0;
        for (Product p:products){
            total+=p.getPrice();
        }
        return total;
    }

    public void applyDiscounts() {
        ArrayList<Product> products = cartRepo.getAllProducts();
        for (Product p:products){
            if (p instanceof Electronics){
                double price = p.getPrice();
                price = price - price*.10;
                p.setPrice(price);
            } else if (p instanceof Clothing) {
                double price = p.getPrice();
                price = price - price*.20;
                p.setPrice(price);
            }
        }
    }
    public Product findproduct(int id) throws IOException {
        return cartRepo.findProduct(id);
    }

}
