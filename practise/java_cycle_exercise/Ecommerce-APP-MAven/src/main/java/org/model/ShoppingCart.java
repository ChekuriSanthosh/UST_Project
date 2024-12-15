package org.model;

import java.util.ArrayList;

public class ShoppingCart {
    public ArrayList<Product> cart = new ArrayList<>();
    public void addProduct(Product p){
        cart.add(p);
    }

    public void displayProducts(){
        for (Product product : cart) {
            product.displayDetails();
            System.out.println('\n');
        }
    }

    public void totalprice(){
        double sum=0;
        for(Product p: cart){
            if (p.getClass().getSimpleName().equals("Electronics")) {
                System.out.println("Discount: 10%");
                double actualPrice = p.getPrice();
                double discountedPrice = actualPrice - actualPrice * 0.1;
                System.out.println("Final Price: " + discountedPrice);
                System.out.println('\n');
                sum+=discountedPrice;
            } else if (p.getClass().getSimpleName().equals("Clothing")) {
                System.out.println("Discount: 20%");
                double actualPrice = p.getPrice();
                double discountedPrice = actualPrice - actualPrice * 0.2;
                System.out.println("Final Price: " + discountedPrice);
                System.out.println('\n');
                sum+=discountedPrice;
            }
        }
        System.out.println("--------------------------------------");
        System.out.println("total cart price: "+ sum);
    }
}
