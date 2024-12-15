package org.repository;
import org.exception.DuplicateProductException;
import org.exception.InvalidInputException;
import org.exception.ProductNotFoundException;
import org.model.Product;

import java.util.ArrayList;

public class ProductsImpl implements Products{
    public static ArrayList<Product> allProducts=new ArrayList<>();

    public void addProductsdata(Product product) throws InvalidInputException, DuplicateProductException {
        for(Product p:allProducts){
            if(p.getProductId()==product.getProductId()){
                throw new DuplicateProductException("Tried Product Duplication with id: "+product.getProductId());
            }
        }

        if(product.getProductId()<0 || product.getProductName()==null || product.getProductName()==""|| product.getPrice()<0){
            throw new InvalidInputException();
        }
        allProducts.add(product);
    }

    public void viewallProducts(){
//        List<Product> res=allProducts;
//        res.sort((Product a, Product b)->{
//            return (int) (a.getPrice()-b.getPrice());
//        });
        for(Product p: allProducts){
            p.displayDetails();
        }
    }

    public ArrayList<Product> getAll(){
        return allProducts;
    }

    public Product findProduc(int id) throws ProductNotFoundException{
        for(Product p:allProducts){
            if(p.getProductId()==id){
                return p;
            }
        }

        throw new ProductNotFoundException("Product not found with the given id "+id);


    }


}
