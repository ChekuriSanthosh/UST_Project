package org;

import org.exception.DuplicateProductException;
import org.exception.ProductNotFoundException;
import org.model.Clothing;
import org.model.Electronics;
import org.model.Product;
import org.model.Size;
import org.service.ProductServiceImpl;
import org.service.cartService;
import org.service.cartServiceImpl;
import org.service.productService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DuplicateProductException {
        Product ep1 = new Electronics("Macbook", 12, 195000, 4, "Apple", 12);
        Product ep2 = new Electronics("S24 Ultra", 2, 150000, 5, "Samsung", 13);

        Product cp1 = new Clothing("T-Shirt", 20, 2000, 10, "cotton", Size.MEDIUM);
        Product cp2 = new Clothing("Pant", 10, 4000, 20, "Silk", Size.EXTRA_SMALL);

        cartService Service = new cartServiceImpl();
        productService Productserv = new ProductServiceImpl();
        Productserv.addProductstodata(ep2);
        Productserv.addProductstodata(cp1);
        Productserv.addProductstodata(cp2);

        try{
            Productserv.addProductstodata(ep1);
        }catch(
                Exception e)
        {
            System.out.println(e);
        }

        Productserv.viewallProductsdata();
        System.out.println("___________________________________________________________");
        try{
            Product pro = Productserv.findProductdata(23);
            pro.displayDetails();
        }catch(
                ProductNotFoundException e){
            System.out.println(e.getMessage());
        }
        try
        {
            Productserv.addProductstodata(cp1);
        }catch(
                Exception e)

        {
            System.out.println(e.getMessage());
        }


        System.out.println("___________________________________________________________________");
        System.out.println("___________________________________________________________________");
        System.out.println("___________________________________________________________________");
        Service.addToCArt(12);
        Service.addToCArt(2);
        Service.addToCArt(20);
        Service.addToCArt(10);
        try

        {
            Service.findproduct(-1);
        }
        catch(
                Exception e)

        {
            System.out.println(e);
        }

        ArrayList<Product> products = Service.getCartItems();
        System.out.println("\u001B[33mProducts in Cart : \033[0m");
        for(
                Product p:products)

        {
            p.displayDetails();
        }
        System.out.println("______________________________________________________________");
        double totalPrice = Service.calculateTotalPrice();
        System.out.println("Total : "+totalPrice);

        Service.applyDiscounts();

        double discountedPrice = Service.calculateTotalPrice();

        System.out.println("After Discounts : "+discountedPrice);




        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("welcome to My Shopping App!"+'\n'+
                "Select an option:"+'\n'+
                "1. View all Products"+'\n'+
                "2. Add Product to cart"+'\n'+
                "3. View Cart"
                );

            int res = scanner.nextInt();
            switch (res) {
                case 1:
                    Productserv.viewallProductsdata();
                    break;
                case 2:
                    System.out.println("Enter the product id to add: ");
                    int id = scanner.nextInt();
                    Service.addToCArt(id);
                    System.out.println("added to the cart!!!!");
                case 3:
                    System.out.println("_____________________________________________________");
                    ArrayList<Product> productss = Service.getCartItems();
                    productss.sort((a, b) -> {
                        return (int) (a.getPrice() - b.getPrice());
                    });
                    System.out.println("Products in Cart : ");
                    for (Product p : productss) {
                        p.displayDetails();
                        System.out.println("_____________________________________________________");
                    }

            }
        }
    }
}
