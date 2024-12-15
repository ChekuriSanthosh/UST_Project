package org.model;

public class Clothing extends Product {
    protected String material;
//    protected String size;
    protected Size size;

    public Clothing(String productName, int productId, double price, int quantityInStock, String material, Size size) {
        super(productName, productId, price, quantityInStock);
        this.material = material;
        this.size = size;
    }
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Material Name: "+material +'\n'+"Size :"+size);

    }
}
