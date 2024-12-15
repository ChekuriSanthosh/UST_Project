package org.model;

public class Electronics extends Product{

    protected String brand;
    protected int warrentyPeriod;


    public Electronics(String productName, int productId, double price, int quantityInStock, String brand, int warrentyPeriod) {
        super(productName, productId, price, quantityInStock);
        this.brand = brand;
        this.warrentyPeriod = warrentyPeriod;
    }
    public void displayDetails(){
        super.displayDetails();
        System.out.println("BrandName: "+brand +'\n'+"Warrenty Period :"+warrentyPeriod);

    }
}
