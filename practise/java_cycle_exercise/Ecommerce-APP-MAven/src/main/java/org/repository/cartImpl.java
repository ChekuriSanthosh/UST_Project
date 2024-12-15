package org.repository;

import org.model.Product;

import java.io.IOException;
import java.util.ArrayList;

public class cartImpl implements Cart{
    public ArrayList<Product> cartss=new ArrayList<>();
    public static Products allproduc=new ProductsImpl();
    ArrayList<Product> allproducts=allproduc.getAll();

    public void addProduct(int id) {

        for(Product p:allproducts){

            if(p.getProductId()==id){
                cartss.add(p);
            }
        }
    }
    public Product findProduct(int id) throws IOException {
        if(id<=0){
            throw new ArithmeticException("Id is less than zero");
        }
        for(Product p:cartss){
            if(p.getProductId()==id){
                return p;
            }
        }
        return null;
    }

    public ArrayList<Product> getAllProducts(){
//        ArrayList<Product> res=cartss;
//        res.sort((a,b)->{
//            return (int) (a.getPrice()-b.getPrice());
//        });
        return cartss;
    }
}
